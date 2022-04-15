package com.chen.lifaapi.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.chen.lifaapi.entity.Orders;
import com.chen.lifaapi.entity.Vips;
import com.chen.lifaapi.service.OrderService;
import com.chen.lifaapi.service.VipsService;
import com.chen.lifaapi.service.WorkerService;
import com.chen.lifaapi.utils.StringToUtf8;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.controller
 * @date 2021/11/22 20:11
 * @since 1.0
 */

@Api(description ="订单Controller")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private WorkerService workerService;
    @Autowired
    private VipsService vipsService;
    @Autowired
    private StringToUtf8 stu;

    @ApiOperation(value = "添加订单记录")
    @PostMapping("/add")
    public int addOrder(String orderId,Long orderPrice, String orderText,
                        String orderMan,String orderPhone, String orderSex,
                        String payType,Long orderMoney,String orderWorker,
                        String orderOrderWorker,String orderCome,String orderRemake,
                        double bonus1,double bonus2){
        Orders orders=new Orders();
        orders.setOrderId(orderId);
        orders.setOrderPrice(orderPrice);
        orders.setOrderDate(new Date());
        orders.setOrderText(orderText);
        orders.setOrderMan(orderMan);
        orders.setOrderPhone(orderPhone);
        orders.setOrderSex(orderSex);
        orders.setPayType(payType);
        orders.setOrderMoney(orderMoney);
        orders.setOrderWorker(orderWorker);
        orders.setOrderOrderWorker(orderOrderWorker);
        orders.setOrderCome(orderCome);
        orders.setOrderRemake(orderRemake);
        // 判断是否是会员
        int isVip=vipsService.getVipNumForPhone(orderPhone);
        if (isVip==1){
            // 如果是会员，而且选择免单，就执行查询余额
            Vips vips=vipsService.getVipForPhone(orderPhone);
            // System.out.println(vips.getVipName());
            if (vips.getVipsMoney()>=orderMoney && Objects.equals(payType, "免单")){
                System.out.println("会员卡抵扣");
                // 如果余额充足，则自动扣除
                vips.setVipsMoney(vips.getVipsMoney()-orderMoney);
                vips.setVipsConsume(vips.getVipsConsume()+orderMoney);
                // 更新会员信息
                vipsService.updateVips(vips);
            }
        }
        return orderService.addOrder(orders,bonus1,bonus2);
    }

    @ApiOperation(value = "获取今日的订单")
    @GetMapping("/today")
    public List<Orders> getTodayOrders(){
        System.out.println("今日订单");
        return orderService.getTodayOrder();
    }

    @ApiOperation(value = "更新订单信息")
    @PostMapping("/update")
    public int upOrders(Orders orders){
        return orderService.upOrder(orders);
    }

    @ApiOperation(value = "获取订单数量")
    @GetMapping("/number")
    public int numberOrders(int isToday){
        return orderService.numberOrder(isToday);
    }

    @ApiOperation(value = "获取收银数量")
    @GetMapping("/money")
    public int moneyOrders(int isToday){
        return orderService.moneyOrder(isToday);
    }
    @ApiOperation(value = "获取所有订单")
    @GetMapping("/all")
    public List<Orders> allOrders(){
        return orderService.allOrders();
    }

    @ApiOperation(value = "分页获取订单信息")
    @GetMapping("/page")
    public List<Orders> pageOrders(int pagesize,int now){
        int num=(now-1)*pagesize; //分页开始的位置
        // now 为当前页数，pagesize 为每页个数
        return orderService.pageOrders(num,pagesize);
    }



    @ApiOperation(value = "导出营业记录")
    @GetMapping("/out")
    public void outAllOrders(HttpServletResponse response){
        List<Orders> orders=orderService.allOrders();
        ExcelWriter writer= ExcelUtil.getWriter();
        writer.addHeaderAlias("orderId", "编号");
        writer.addHeaderAlias("orderPrice", "价格");
        writer.addHeaderAlias("orderDate", "日期");
        writer.addHeaderAlias("orderText", "账单内容");
        writer.addHeaderAlias("orderMan", "客户姓名");
        writer.addHeaderAlias("orderPhone", "客户联系方式");
        writer.addHeaderAlias("orderSex", "客户性别");
        writer.addHeaderAlias("payType", "支付方式");
        writer.addHeaderAlias("orderMoney", "实付金额");
        writer.addHeaderAlias("orderWorker", "发型师");
        writer.addHeaderAlias("orderOrderWorker", "中工");
        writer.addHeaderAlias("orderCome", "客户来源");
        writer.addHeaderAlias("orderRemake", "账单备注");
        writer.merge(12, "营业记录表");
        writer.write(orders, true);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");

        String name = stu.getUTF8XMLString("理发店营业记录表");

        response.setHeader("Content-Disposition", "attachment;filename=" + name + ".xls");
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            writer.flush(out, true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
        IoUtil.close(out);
    }
}
