package com.chen.lifaapi.service;

import com.chen.lifaapi.entity.Systemlog;

import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service
 * @date 2022/5/2 10:16
 * @since 1.0
 */
public interface LogService {
    int addSystemLog(Systemlog systemlog);
    List<Systemlog> getSystem();
    Systemlog getLastLogin();//查找最新登录的用户
}
