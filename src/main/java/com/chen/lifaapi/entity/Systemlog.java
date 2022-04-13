package com.chen.lifaapi.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * systemlog
 * @author 
 */
@Data
public class Systemlog implements Serializable {
    private Integer systemid;

    private String systemtext;

    private Date systemtime;

    private String systemip;

    private String systemuser;

    private static final long serialVersionUID = 1L;
}