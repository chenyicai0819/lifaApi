package com.chen.lifaapi.mapper;

import com.chen.lifaapi.entity.Wokelevel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WokelevelMapper {
    List<Wokelevel> getAllLevel();
    Wokelevel getLevelForID(String id);
}