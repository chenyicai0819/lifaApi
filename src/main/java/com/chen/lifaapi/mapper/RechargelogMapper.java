package com.chen.lifaapi.mapper;

import com.chen.lifaapi.entity.Rechargelog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RechargelogMapper {
    int deleteByPrimaryKey(Integer rechid);

    int insert(Rechargelog record);

    int insertSelective(Rechargelog record);

    Rechargelog selectByPrimaryKey(Integer rechid);

    int updateByPrimaryKeySelective(Rechargelog record);

    int updateByPrimaryKey(Rechargelog record);
}