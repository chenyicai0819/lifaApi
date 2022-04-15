package com.chen.lifaapi.service;

import com.chen.lifaapi.entity.Users;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service
 * @date 2021/11/21 15:52
 * @since 1.0
 */
public interface UsersService {
    Users getUsers(String userid);
    public Users login( String userid,String password );
    int getNum();
    public int logUp(String id,String username,String password);
    Users getUsersById(String id);
}
