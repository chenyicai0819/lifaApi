package com.chen.lifaapi.service.impl;

import com.chen.lifaapi.entity.ChatLog;
import com.chen.lifaapi.mapper.ChatMapper;
import com.chen.lifaapi.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service.impl
 * @date 2022/4/30 19:26
 * @since 1.0
 */

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatMapper chatMapper;
    @Override
    public int insert(ChatLog chatLog) {
        return chatMapper.insert(chatLog);
    }

    @Override
    public List<ChatLog> getAll() {
        return chatMapper.getChat();
    }
}
