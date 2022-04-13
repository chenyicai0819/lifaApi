package com.chen.lifaapi.mapper;

import com.chen.lifaapi.entity.Salarylog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SalarylogMapper {
    int payRoll(Salarylog salarylog);
    List<Map<String,String>> getAllMoney();
}