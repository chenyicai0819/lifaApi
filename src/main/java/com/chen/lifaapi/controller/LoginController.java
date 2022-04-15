package com.chen.lifaapi.controller;


import com.chen.lifaapi.entity.Users;
import com.chen.lifaapi.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.controller
 * @date 2021/11/21 11:27
 * @since 1.0
 */

@Api(description="登录Controller")
@RestController
public class LoginController {
    @Autowired
    private UsersService usersService;


    @ApiOperation(value = "登录")
    @PostMapping( "/login")
    public int logIn( String userid,String password ) {
        Users users=usersService.login(userid,password);
        if (users!=null){
            return 1;
        }
        return 0;
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/get/users")
    public Users getUsers(String username){
        return usersService.getUsers(username);
    }

    @ApiOperation("根据id获取用户信息")
    @PostMapping("/id")
    public Users getUsersById(String id){
        return usersService.getUsersById(id);
    }

    @ApiOperation(value = "注册")
    @RequestMapping(value = "/logup", method = RequestMethod.POST)
    public String logUp(String username,String password){
        String id= String.valueOf(usersService.getNum()+1);
        int s=usersService.logUp(id,username,password);
        if (s==1){
            return id;
        }else {
            return "error";
        }
    }
}
