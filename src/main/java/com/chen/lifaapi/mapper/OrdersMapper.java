package com.chen.lifaapi.mapper;

import com.chen.lifaapi.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrdersMapper {
    int insert(Orders record);
    // 获取所有订单
    List<Orders> allOrders();
    List<Orders> getTodayOrder();
    int upOrder(Orders orders);
    int numberOrder(int isToday);
    int moneyOrder(int isToday);
    List<Orders> pageOrders(int num, int pagesize);
    List<Orders> getDayWorkersOrder(String start,String end,String name);
}