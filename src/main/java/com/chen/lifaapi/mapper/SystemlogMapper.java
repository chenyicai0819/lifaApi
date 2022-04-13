package com.chen.lifaapi.mapper;

import com.chen.lifaapi.entity.Systemlog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SystemlogMapper {
    int deleteByPrimaryKey(Integer systemid);

    int insert(Systemlog record);

    int insertSelective(Systemlog record);

    Systemlog selectByPrimaryKey(Integer systemid);

    int updateByPrimaryKeySelective(Systemlog record);

    int updateByPrimaryKey(Systemlog record);
}