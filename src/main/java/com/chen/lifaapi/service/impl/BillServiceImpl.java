package com.chen.lifaapi.service.impl;

import com.chen.lifaapi.entity.Bill;
import com.chen.lifaapi.mapper.BillMapper;
import com.chen.lifaapi.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service.impl
 * @date 2022/1/12 20:55
 * @since 1.0
 */
@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillMapper billMapper;
    @Override
    public void addBill(Bill bill) {
        billMapper.insert(bill);
    }

    @Override
    public List<Bill> getTodayBill() {
        return billMapper.getTodayBill();
    }

    @Override
    public List<Bill> allBill() {
        return billMapper.allBill();
    }

    @Override
    public int getOpenBill(int isToday) {
        return billMapper.getOpenBill(isToday);
    }

    @Override
    public List<Bill> getDayBill(String start, String end,int id) {
        Map<String,Object> map=new HashMap<>();
        map.put("start",start);
        map.put("end",end);
        map.put("id",id);
        return billMapper.getDayBill(map);
    }

    @Override
    public List<Bill> pageBills(int num, int pagesize) {
        return billMapper.pageBills(num,pagesize);
    }
}
