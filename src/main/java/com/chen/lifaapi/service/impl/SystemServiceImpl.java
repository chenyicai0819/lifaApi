package com.chen.lifaapi.service.impl;

import com.chen.lifaapi.entity.Systems;
import com.chen.lifaapi.mapper.SystemMapper;
import com.chen.lifaapi.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service.impl
 * @date 2022/2/23 21:40
 * @since 1.0
 */
@Service
public class SystemServiceImpl implements SystemService {
    @Autowired
    private SystemMapper systemMapper;

    @Override
    public int upSystem(Systems systems) {
        return systemMapper.upSystem(systems);
    }

    @Override
    public Systems getSystem(String name) {
        return systemMapper.getSystem(name);
    }
}
