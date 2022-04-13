package com.chen.lifaapi.service.impl;

import com.chen.lifaapi.mapper.ServiceMapper;
import com.chen.lifaapi.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service
 * @date 2022/1/12 19:49
 * @since 1.0
 */
@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceMapper serviceMapper;

    @Override
    public List<com.chen.lifaapi.entity.Service> getAllService() {
        return serviceMapper.getAllService();
    }

    @Override
    public List<com.chen.lifaapi.entity.Service> pageGetService(int num, int pagesize) {
        return serviceMapper.pageGetService(num,pagesize);
    }

    @Override
    public int delService(int id) {
        return serviceMapper.delService(id);
    }

    @Override
    public int addService(String name, String price) {
        return serviceMapper.addService(name,price);
    }
}
