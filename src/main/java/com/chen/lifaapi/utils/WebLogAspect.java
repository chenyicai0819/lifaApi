package com.chen.lifaapi.utils;

import com.chen.lifaapi.aop.Log;
import com.chen.lifaapi.entity.Systemlog;
import com.chen.lifaapi.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.utils
 * @date 2022/5/2 9:57
 * @since 1.0
 */

@Aspect
@Component
public class WebLogAspect {

    @Autowired
    private LogService ls;

    private final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("@annotation(com.chen.lifaapi.aop.Log)")//切入点描述 匹配标有Log注解的方法
    public void controllerLog(){}//签名，可以理解成这个切入点的一个名称


    @After("controllerLog()") //在切入点的方法run完成之后要干的
    public void logBeforeController(JoinPoint joinPoint) {

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();//这个RequestContextHolder是Springmvc提供来获得请求的东西
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();

        // 记录下请求内容
        logger.info("################URL : " + request.getRequestURL().toString());
        logger.info("################HTTP_METHOD : " + request.getMethod());
        logger.info("################IP : " + request.getRemoteAddr());
        logger.info("################THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));

        //下面这个getSignature().getDeclaringTypeName()是获取包+类名的   然后后面的joinPoint.getSignature.getName()获取了方法名
        logger.info("################CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //logger.info("################TARGET: " + joinPoint.getTarget());//返回的是需要加强的目标类的对象
        //logger.info("################THIS: " + joinPoint.getThis());//返回的是经过加强后的代理类的对象
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        Log userAction = method.getAnnotation(Log.class);
        String text="";
        if (userAction != null) {
            // 注解上的描述
            text=userAction.value();
        }

        Systemlog systemlog=new Systemlog();
        Date date=new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        systemlog.setSystemtime(Timestamp.valueOf(dateFormat.format(date)));
        systemlog.setSystemip(request.getRemoteAddr());
        systemlog.setSystemurl(request.getRequestURL().toString());
        String methods=joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        systemlog.setSystemmethod(methods);
        if (!"com.chen.lifaapi.controller.LoginController.getUsersById".equals(methods)){
            String user=ls.getLastLogin().getSystemtext();
            systemlog.setSystemuser(user);
            systemlog.setSystemtext(text);
        }else {

        }
        ls.addSystemLog(systemlog);

    }

}
