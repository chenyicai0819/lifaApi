package com.chen.lifaapi.controller;

import com.chen.lifaapi.aop.Log;
import com.chen.lifaapi.entity.ChatLog;
import com.chen.lifaapi.service.ChatService;
import com.chen.lifaapi.utils.WeChatNotify;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.controller
 * @date 2022/4/30 19:26
 * @since 1.0
 */
@RestController
@RequestMapping("/chat")
@Api(description = "发送信息控制器类")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private WeChatNotify weChatNotify;

    @ApiOperation(value = "添加信息")
    @PostMapping("/add")
    @Log("添加消息")
    public int insert(ChatLog chatLog){
        System.out.println(chatLog.getChatTime());
        if (chatLog.getChatTime()==null){
            Date date=new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            chatLog.setChatTime(Timestamp.valueOf(dateFormat.format(date)));
        }
        return chatService.insert(chatLog);
    }

    @ApiOperation(value = "发送信息")
    @PostMapping("/push")
    @Log("添加消息")
    public void pushMsg(ChatLog chatLog){
        Map<String,Object> map=new HashMap<>();
        map.put("activity",chatLog.getChatName());
        map.put("time",chatLog.getChatText());
        weChatNotify.pushMail(map,1);
    }

    @ApiOperation(value = "查找所有信息")
    @GetMapping("/all")
    public List<ChatLog> getAll(){
     return chatService.getAll();
    }
}
