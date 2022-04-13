package com.chen.lifaapi.service;

import com.chen.lifaapi.entity.Bill;
import com.chen.lifaapi.entity.Orders;

import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service
 * @date 2022/1/12 20:54
 * @since 1.0
 */
public interface BillService {
    void addBill(Bill bill);// 添加新订单
    List<Bill> getTodayBill();
    List<Bill> allBill();
    int getOpenBill(int isToday); //获取开卡充值金额
    List<Bill> getDayBill(String start,String end,int id);
    List<Bill> pageBills(int num, int pagesize);
}
