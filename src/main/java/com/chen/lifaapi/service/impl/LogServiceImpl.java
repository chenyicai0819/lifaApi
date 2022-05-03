package com.chen.lifaapi.service.impl;

import com.chen.lifaapi.entity.Systemlog;
import com.chen.lifaapi.mapper.LogMapper;
import com.chen.lifaapi.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service.impl
 * @date 2022/5/2 10:17
 * @since 1.0
 */

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;
    @Override
    public int addSystemLog(Systemlog systemlog) {
        return logMapper.addSystemLog(systemlog);
    }

    @Override
    public List<Systemlog> getSystem() {
        return logMapper.getSystem();
    }

    @Override
    public Systemlog getLastLogin() {
        return logMapper.getLastLogin();
    }
}
