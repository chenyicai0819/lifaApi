package com.chen.lifaapi.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * bill
 * @author CHENYICAI
 */
@Data
public class Bill implements Serializable {
    private Integer billId;

    private Date billTime;

    private Integer billType;

    private Long billMoney;

    private String billText;

    private String billWorker;

    private String billRemark;

    private String payType;

    private String billOrderWorkers;

    private String billNo;

    private static final long serialVersionUID = 1L;
}