package com.chen.lifaapi.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.entity
 * @date 2022/4/30 19:21
 * @since 1.0
 */

@Data
public class ChatLog {
    private int chatId;
    private String chatName;
    private String chatText;
    private int chatMan;
    private String chatVips;
    private Timestamp chatTime;
}
