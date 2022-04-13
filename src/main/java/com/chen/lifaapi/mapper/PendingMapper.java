package com.chen.lifaapi.mapper;

import com.chen.lifaapi.entity.Pending;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PendingMapper {
    int deleteByPrimaryKey(String penid);

    int insert(Pending record);

    int insertSelective(Pending record);

    Pending selectByPrimaryKey(String penid);

    int updateByPrimaryKeySelective(Pending record);

    int updateByPrimaryKey(Pending record);
}