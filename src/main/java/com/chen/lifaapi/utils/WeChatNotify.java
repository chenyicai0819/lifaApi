package com.chen.lifaapi.utils;

import com.chen.lifaapi.entity.Vips;
import com.chen.lifaapi.mapper.VipsMapper;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/**
 * @author George
 * @project glyxybxxththd
 * @package com.glyxybxhtxt.util
 * @date 2021/12/6 14:45
 * @since 1.0
 */
@Component
public class WeChatNotify {

    @Autowired
    private VipsMapper vipsMapper;

    /**
     * 发送模板信息对外接口
     * @param map
     * @param type
     */
    public void pushMail(Map<String,Object> map,int type){
        // 获取会员openid
        List<Vips> list=vipsMapper.getVipList();
        String openid=null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getOpenid()!=null){
                openid=list.get(i).getOpenid();
                // 循环调用发送信息
                if (type==1){
                    //发送活动信息
                    pushAcitvity(map,openid);
                }

            }
        }
    }


    /**
     * 发送活动信息
     * @param map
     * @param openid
     * @return
     */
    private String pushAcitvity(Map<String,Object> map,String openid) {

        //1，配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId("wxacc93d31c5dbd26f");
        wxStorage.setSecret("f8c9e82b590ac71eb12e96f77cf65740");
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);
        //2,推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                //要推送的用户openid
                .toUser(openid)
                //模版id
                .templateId("SNyNJ5RCT78kyaHZQqrzkL6GIH_p-cO2OkoUalL5bOo")
                //点击模版消息要访问的网址
                .url("http://www.cyc292.top/#/home")
                .build();

        //3,正式版发送模版消息，这里需要配置你的信息，替换微信公众号上创建的模板内容
        // 根据type决定发送哪条
        templateMessage.addData(new WxMpTemplateData("activity", map.get("activity").toString(), "#173177"));
        templateMessage.addData(new WxMpTemplateData("time",map.get("time").toString(), "#173177"));
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            System.out.println("推送成功");
            return "推送成功";
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
            return "推送失败";
        }
    }

    // 检查openid是否已经绑定
    // public String selOpenid(String ybid){
    //     String openid=js.selOpenidForYbid(ybid);
    //     if (openid == null){
    //         return null;
    //     }
    //     return openid;
    // }
}
