package com.chen.lifaapi.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * commoditytype
 * @author 
 */
@Data
public class Commoditytype implements Serializable {
    private String commtyId;

    private String commtyName;

    private static final long serialVersionUID = 1L;
}