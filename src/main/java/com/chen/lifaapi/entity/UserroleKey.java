package com.chen.lifaapi.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * userrole
 * @author 
 */
@Data
public class UserroleKey implements Serializable {
    private String userid;

    private String rolesid;

    private static final long serialVersionUID = 1L;
}