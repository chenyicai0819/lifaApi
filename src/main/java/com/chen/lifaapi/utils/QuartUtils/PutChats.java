package com.chen.lifaapi.utils.QuartUtils;

import com.chen.lifaapi.entity.Vips;
import com.chen.lifaapi.service.VipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.utils.QuartUtils
 * @date 2022/4/14 0:40
 * @since 1.0
 */
@Component
public class PutChats {

    @Autowired
    private VipsService vipsService;

    /**
     * 发送生日祝福
     */
    public void putBrithday(){
        List<Vips> vips=vipsService.getVipList();
        Date date=new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (int i = 0; i < vips.size(); i++) {
            if (dateFormat.format(date).equals(vips.get(i).getVipBirthday())){
                System.out.println("发送生日祝福");
            }
        }
        System.out.println("发送生日祝福");
    }
}
