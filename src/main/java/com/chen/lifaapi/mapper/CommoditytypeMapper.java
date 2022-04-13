package com.chen.lifaapi.mapper;

import com.chen.lifaapi.entity.Commoditytype;
import org.apache.ibatis.annotations.Mapper;
import org.yaml.snakeyaml.comments.CommentType;

import java.util.List;

@Mapper
public interface CommoditytypeMapper {
    List<Commoditytype> getAllType();
}