package com.chen.lifaapi.service;

import com.chen.lifaapi.entity.AlipayBean;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service
 * @date 2022/4/17 22:47
 * @since 1.0
 */
public interface PaymentService {
    public String toAlipay(AlipayBean alipayBean);
}
