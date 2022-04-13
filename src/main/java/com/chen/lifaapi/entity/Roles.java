package com.chen.lifaapi.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * roles
 * @author 
 */
@Data
public class Roles implements Serializable {
    private String rolesid;

    private String rolename;

    private static final long serialVersionUID = 1L;
}