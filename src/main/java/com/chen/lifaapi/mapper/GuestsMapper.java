package com.chen.lifaapi.mapper;

import com.chen.lifaapi.entity.Guests;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GuestsMapper {
    int deleteByPrimaryKey(String guestid);

    int insert(Guests record);

    int insertSelective(Guests record);

    Guests selectByPrimaryKey(String guestid);

    int updateByPrimaryKeySelective(Guests record);

    int updateByPrimaryKey(Guests record);
}