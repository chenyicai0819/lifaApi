package com.chen.lifaapi.mapper;

import com.chen.lifaapi.entity.Roles;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RolesMapper {
    int deleteByPrimaryKey(String rolesid);

    int insert(Roles record);

    int insertSelective(Roles record);

    Roles selectByPrimaryKey(String rolesid);

    int updateByPrimaryKeySelective(Roles record);

    int updateByPrimaryKey(Roles record);
}