package com.chen.lifaapi.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.utils
 * @date 2022/4/30 18:26
 * @since 1.0
 */

@Controller
public class ConstantWxPayUtils implements InitializingBean {
    // @Value("${wx.pay.app_id}")
    // private String appID;
    // @Value("${wx.pay.partner}")
    // private String partner;
    // @Value("${wx.pay.partnerkey}")
    // private String partnerKey;
    // @Value("${wx.pay.notifyurl}")
    // private String notifyUrl;
    // @Value("${wx.pay.wxurl}")
    // private String wxUrl;
    // @Value("${wx.pay.queryUrl}")
    // private String queryUrl;

    //定义公共静态常量
    public static String WX_PAY_APP_ID;
    public static String WX_PAY_PARTNER;
    public static String WX_PAY_PARTNER_KEY;
    public static String WX_PAY_NOTIFY_URL;
    public static String WX_PAY_WX_URL;
    public static String WX_PAY_QUERY_URL;

    @Override
    public void afterPropertiesSet() throws Exception {
        // WX_PAY_APP_ID = appID;
        // WX_PAY_PARTNER = partner;
        // WX_PAY_PARTNER_KEY = partnerKey;
        // WX_PAY_NOTIFY_URL = notifyUrl;
        // WX_PAY_WX_URL = wxUrl;
        // WX_PAY_QUERY_URL=queryUrl;
    }

}
