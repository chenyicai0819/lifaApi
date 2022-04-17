package com.chen.lifaapi.service;

import com.chen.lifaapi.entity.Orders;
import com.chen.lifaapi.entity.Vips;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service
 * @date 2021/11/22 20:13
 * @since 1.0
 */
public interface OrderService {

    int addOrder(Orders orders,double bonus1,double bonus2);
    List<Orders> getTodayOrder();
    int upOrder(Orders orders);
    int numberOrder(int isToday);
    int moneyOrder(int isToday);
    List<Orders> allOrders();
    List<Orders> pageOrders(int num, int pagesize);
    List<Orders> getDayWorkersOrder(String start,String end,String name);
}
