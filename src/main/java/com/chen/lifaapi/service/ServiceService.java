package com.chen.lifaapi.service;

import com.chen.lifaapi.entity.Service;

import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service
 * @date 2022/1/12 19:48
 * @since 1.0
 */
public interface ServiceService {

    List<Service> getAllService();
    List<Service> pageGetService(int num,int pagesize);
    int delService(int id);
    int addService(String name,String price);
}
