package com.chen.lifaapi.mapper;

import com.chen.lifaapi.entity.UserroleKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserroleMapper {
    int deleteByPrimaryKey(UserroleKey key);

    int insert(UserroleKey record);

    int insertSelective(UserroleKey record);
}