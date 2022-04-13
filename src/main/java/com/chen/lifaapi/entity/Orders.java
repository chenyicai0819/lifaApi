package com.chen.lifaapi.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * orders
 * @author 
 */
@Data
public class Orders implements Serializable {
    private String orderId;

    private Long orderPrice;

    private Date orderDate;

    private String orderText;

    private String orderMan;

    private String orderPhone;

    private String orderSex;

    private String payType;

    private Long orderMoney;

    private String orderWorker;

    private String orderOrderWorker;

    private String orderCome;

    private String orderRemake;

    private static final long serialVersionUID = 1L;
}