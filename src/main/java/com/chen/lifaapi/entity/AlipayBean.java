package com.chen.lifaapi.entity;

import lombok.Data;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.entity
 * @date 2022/4/17 22:42
 * @since 1.0
 */
@Data
public class AlipayBean {
    /*商户订单号，必填*/
    private String out_trade_no;
    /*订单名称，必填*/
    private String subject;
    /*付款金额，必填*/
    private StringBuffer total_amount;
    /*商品描述，可空*/
    private String body;
    /*超时时间参数*/
    private String timeout_express="10m";
    private String product_code="FAST_INSTANT_TRADE_PAY";
}
