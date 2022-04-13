package com.chen.lifaapi.mapper;

import com.chen.lifaapi.entity.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper {


    Users findByUsername(String username);
    public Users login( String userid,String password );
    int getNum();
    int logUp(String id,String username,String password);
}