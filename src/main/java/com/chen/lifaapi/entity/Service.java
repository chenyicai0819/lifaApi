package com.chen.lifaapi.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * service
 * @author 
 */
@Data
public class Service implements Serializable {
    private int serId;

    private String serTyid;

    private String serName;

    private Long serPrice;

    private Integer serState;

    private static final long serialVersionUID = 1L;
}