package com.chen.lifaapi.controller;


import com.chen.lifaapi.entity.Systemlog;
import com.chen.lifaapi.entity.Users;
import com.chen.lifaapi.service.LogService;
import com.chen.lifaapi.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.controller
 * @date 2021/11/21 11:27
 * @since 1.0
 */

@Api(description="登录Controller")
@RestController
public class LoginController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private LogService ls;

    @ApiOperation(value = "登录")
    @PostMapping( "/login")
    public int logIn( String userid,String password ) {
        Users users=usersService.login(userid,password);
        if (users!=null){
            return 1;
        }
        return 0;
    }

    @ApiOperation(value = "登出")
    @PostMapping( "/logout")
    public void logOut(String id) {
        addLog(id,"com.chen.lifaapi.controller.LoginController.logout","登出");
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/get/users")
    public Users getUsers(String username){
        return usersService.getUsers(username);
    }

    @ApiOperation("根据id获取用户信息")
    @PostMapping("/id")
    public Users getUsersById(String id){
        addLog(id,"com.chen.lifaapi.controller.LoginController.getUsersById","登录");
        return usersService.getUsersById(id);
    }

    @ApiOperation(value = "注册")
    @RequestMapping(value = "/logup", method = RequestMethod.POST)
    public String logUp(String username,String password){
        String id= String.valueOf(usersService.getNum()+1);
        int s=usersService.logUp(id,username,password);
        if (s==1){
            return id;
        }else {
            return "error";
        }
    }

    /**
     * 在此处添加登录登出的日志
     */
    private void addLog(String id,String path,String msg){

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();//这个RequestContextHolder是Springmvc提供来获得请求的东西
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();


        Systemlog systemlog=new Systemlog();
        Date date=new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        systemlog.setSystemtime(Timestamp.valueOf(dateFormat.format(date)));
        systemlog.setSystemip(request.getRemoteAddr());
        systemlog.setSystemurl(request.getRequestURL().toString());
        systemlog.setSystemmethod(path);
        systemlog.setSystemuser(id);
        systemlog.setSystemtext(msg);

        ls.addSystemLog(systemlog);
    }
}
