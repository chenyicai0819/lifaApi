package com.chen.lifaapi.controller;

import com.chen.lifaapi.config.AlipayConfig;
import com.chen.lifaapi.entity.AlipayBean;
import com.chen.lifaapi.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.controller
 * @date 2022/4/17 22:49
 * @since 1.0
 */
@RestController
public class PaymetController {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    AlipayConfig alipayConfig;
    @PostMapping("alipay")
    public String toAlipay(AlipayBean alipayBean) throws IOException {
        String result = paymentService.toAlipay(alipayBean);
        return result;
    }
}
