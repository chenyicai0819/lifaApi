package com.chen.lifaapi.mapper;

import com.chen.lifaapi.entity.Viptypes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ViptypesMapper {
    List<Viptypes> allViptype();
    int delVipType(int id);
    Viptypes getDiscountById(int id);
}