package com.chen.lifaapi.mapper;

import com.chen.lifaapi.entity.Servicetype;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ServicetypeMapper {
    int deleteByPrimaryKey(String sertyid);

    int insert(Servicetype record);

    int insertSelective(Servicetype record);

    Servicetype selectByPrimaryKey(String sertyid);

    int updateByPrimaryKeySelective(Servicetype record);

    int updateByPrimaryKey(Servicetype record);
}