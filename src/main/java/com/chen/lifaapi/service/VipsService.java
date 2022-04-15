package com.chen.lifaapi.service;

import com.chen.lifaapi.entity.Vips;

import java.io.InputStream;
import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service
 * @date 2021/11/22 19:40
 * @since 1.0
 */
public interface VipsService {

    List<Vips> getVipList();
    public List<Vips> pageVipList(int num,int pagesize);
    int addVips(Vips vips);
    int updateVips(Vips vips);
    int indexVips();
    int getVipNumForPhone(String phone);// 通过电话判断是否是会员
    Vips getVipForPhone(String phone);// 通过电话查找会员信息
    int getNowMoney(String id);
    List<Vips> getVipsByEvery(Vips vips);
    public Vips getOneVipForId(String id);
    int insertVipBatch(List<Vips> vipDataList);
}
