package com.chen.lifaapi.service;

import com.chen.lifaapi.entity.ChatLog;

import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service
 * @date 2022/4/30 19:26
 * @since 1.0
 */
public interface ChatService {

    int insert(ChatLog chatLog);
    List<ChatLog> getAll();
}
