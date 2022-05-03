package com.chen.lifaapi.mapper;

import com.chen.lifaapi.entity.ChatLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.mapper
 * @date 2022/4/30 19:27
 * @since 1.0
 */
@Mapper
public interface ChatMapper {
    int insert(ChatLog chatLog);
    List<ChatLog> getChat();
}
