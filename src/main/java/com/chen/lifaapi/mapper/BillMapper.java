package com.chen.lifaapi.mapper;

import com.chen.lifaapi.entity.Bill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BillMapper {
    List<Bill> allBill();
    int insert(Bill record);
    List<Bill> getTodayBill();
    int getOpenBill(int isToday);
    List<Bill> getDayBill(Map<String,Object> map);
    List<Bill> pageBills(int num, int pagesize);
}