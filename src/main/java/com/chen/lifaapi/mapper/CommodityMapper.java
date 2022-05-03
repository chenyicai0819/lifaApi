package com.chen.lifaapi.mapper;

import com.chen.lifaapi.entity.Commodity;
import com.chen.lifaapi.entity.Vips;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommodityMapper {
    int insert(Commodity record);
    List<Commodity> getAllComm();
    List<Commodity> pageVipList(int num, int pagesize);
    int priceComm();
    int upComm(Commodity commodity);
    int delComm(int id);
    List<Commodity> getSomeComm(String type);
}