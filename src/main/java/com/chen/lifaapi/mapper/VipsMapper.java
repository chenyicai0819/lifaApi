package com.chen.lifaapi.mapper;

import com.chen.lifaapi.entity.Vips;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VipsMapper {

    int insert(Vips record);
    int updateByPrimaryKeySelective(Vips record);
    int getVipNumForPhone(String phone);// 通过电话判断是否是会员
    Vips getVipForPhone(String phone);// 通过电话查找会员信息
    List<Vips> getVipList();
    List<Vips> pageVipList(int num,int pagesize);
    int indexVips();
    int getNowMoney(String id);
    List<Vips> getVipsByEvery(Vips vips);
    Vips getOneVipForId(String id);

}