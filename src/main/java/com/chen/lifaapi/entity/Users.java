package com.chen.lifaapi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lombok.Data;

/**
 * users
 * @author 
 */
@Data
public class Users implements Serializable {
    private String userid;

    private String username;

    private String password;

    private String openid;

}