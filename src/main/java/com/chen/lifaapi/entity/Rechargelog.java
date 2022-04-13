package com.chen.lifaapi.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * rechargelog
 * @author 
 */
@Data
public class Rechargelog implements Serializable {
    private Integer rechid;

    private String orderid;

    private Date rechtime;

    private Long rechmoney;

    private String paytype;

    private String rechworker;

    private Integer isopencard;

    private String cardid;

    private static final long serialVersionUID = 1L;
}