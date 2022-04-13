package com.chen.lifaapi.mapper;

import com.chen.lifaapi.entity.Orders;
import com.chen.lifaapi.entity.Service;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ServiceMapper {
    List<Service> getAllService();
    List<Service> pageGetService(int num,int pagesize);
    int delService(int id);
    int addService(String namee,String price);
}