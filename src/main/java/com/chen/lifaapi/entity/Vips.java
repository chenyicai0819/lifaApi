package com.chen.lifaapi.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import lombok.Data;

/**
 * vips
 * @author 
 */
@Data
public class Vips implements Serializable {
    private String vipId;

    private Integer typeId;

    private String vipName;

    private String vipPassword;

    private String vipPhone;

    private String vipSex;

    private Timestamp vipBirthday;

    private Timestamp vipOpencard;

    private Long vipsMoney;

    private Long vipsConsume;

    private Long vipsBonus;

    private Timestamp vipsLast;

    private String openid;

    private static final long serialVersionUID = 1L;
}