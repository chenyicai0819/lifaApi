package com.chen.lifaapi.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * commodity
 * @author 
 */
@Data
public class Commodity implements Serializable {
    private int commId;

    private String commtyId;

    private String commName;

    private Long commPrice;

    private Integer commNum;

    private Integer commState;

    private static final long serialVersionUID = 1L;
}