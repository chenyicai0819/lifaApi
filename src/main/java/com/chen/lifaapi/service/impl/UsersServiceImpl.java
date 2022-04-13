package com.chen.lifaapi.service.impl;

import com.chen.lifaapi.entity.Users;
import com.chen.lifaapi.mapper.UsersMapper;
import com.chen.lifaapi.service.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service.impl
 * @date 2021/11/21 15:52
 * @since 1.0
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users getUsers(String username) {
        return usersMapper.findByUsername(username);
    }

    @Override
    public Users login(String userid, String password) {
        return usersMapper.login(userid,password);
    }

    @Override
    public int getNum() {
        return usersMapper.getNum();
    }

    @Override
    public int logUp(String id, String username, String password) {
        return usersMapper.logUp(id,username,password);
    }
}
