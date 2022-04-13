package com.chen.lifaapi.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * viptypes
 * @author 
 */
@Data
public class Viptypes implements Serializable {
    private Integer typeId;

    private String vipType;

    private Double vipDiscount;

    private String vipRemark;

    private static final long serialVersionUID = 1L;
}