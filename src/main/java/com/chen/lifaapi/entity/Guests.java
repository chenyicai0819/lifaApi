package com.chen.lifaapi.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * guests
 * @author 
 */
@Data
public class Guests implements Serializable {
    private String guestid;

    private String guestname;

    private String guestphone;

    private Integer gusetsex;

    private String guesttext;

    private Long guestmoney;

    private Date guesttime;

    private String guestcome;

    private String guestworker;

    private String guestremark;

    private static final long serialVersionUID = 1L;
}