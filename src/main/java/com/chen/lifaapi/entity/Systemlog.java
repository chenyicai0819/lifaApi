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

    private String systemurl;

    private String systemmethod;

    private static final long serialVersionUID = 1L;
}