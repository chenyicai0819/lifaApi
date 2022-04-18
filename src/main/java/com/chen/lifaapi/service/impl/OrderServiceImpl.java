package com.chen.lifaapi.service.impl;

import com.chen.lifaapi.entity.Orders;
import com.chen.lifaapi.mapper.OrdersMapper;
import com.chen.lifaapi.mapper.WorkerMapper;
import com.chen.lifaapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service.impl
 * @date 2021/11/22 20:13
 * @since 1.0
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private WorkerMapper workerMapper;

    @Override
    public int addOrder(Orders orders,double workerbonus1,double workerbonus2) {
        // 添加订单时给员工添加奖金
        String id1=workerMapper.getIdForName(orders.getOrderWorker());
        String id2=workerMapper.getIdForName(orders.getOrderOrderWorker());
        if (id1!=null){
            Long bonus1= Long.valueOf((int) (orders.getOrderMoney()*workerbonus1));
            Map<String,Object> map1=new HashMap<>();
            map1.put("id",id1);
            map1.put("bonus",bonus1+workerMapper.getBonus(id1));
            workerMapper.addBonus(map1);
        }
        if (id2!=null){
            Long bonus2= Long.valueOf((int) (orders.getOrderMoney()*workerbonus2));
            Map<String,Object> map2=new HashMap<>();
            map2.put("id",id2);
            map2.put("bonus",bonus2+workerMapper.getBonus(id2));
            workerMapper.addBonus(map2);
        }

        return ordersMapper.insert(orders);
    }

    @Override
    public List<Orders> getTodayOrder() {
        return ordersMapper.getTodayOrder();
    }

    @Override
    public int upOrder(Orders orders) {
        return 0;
    }

    @Override
    public int numberOrder(int isToday) {
        if (isToday==1){
            // 获取今日
            return ordersMapper.numberOrder(isToday);
        }else {
            //获取所有
            return ordersMapper.numberOrder(isToday);
        }
    }

    @Override
    public int moneyOrder(int isToday) {
        return ordersMapper.moneyOrder(isToday);
    }

    @Override
    public List<Orders> allOrders() {
        return ordersMapper.allOrders();
    }

    @Override
    public List<Orders> pageOrders(int num, int pagesize) {
        return ordersMapper.pageOrders(num,pagesize);
    }

    @Override
    public List<Orders> getDayWorkersOrder(String start, String end, String name) {
        return ordersMapper.getDayWorkersOrder(start,end,name);
    }

    @Override
    public List<Orders> getDayOrdersForName(String start, String end, String name) {
        return ordersMapper.getDayOrdersForName(start,end,name);
    }
}
