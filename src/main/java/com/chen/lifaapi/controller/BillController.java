package com.chen.lifaapi.controller;

import com.chen.lifaapi.aop.Log;
import com.chen.lifaapi.entity.Bill;
import com.chen.lifaapi.service.BillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.controller
 * @date 2022/1/12 20:53
 * @since 1.0
 */
@RestController
@RequestMapping("/bill")
@Api(description = "账单控制器类")
public class BillController {
    @Autowired
    private BillService billService;

    @PostMapping("/add" )
    @Log(value = "添加账单")
    @ApiOperation(value = "添加新账单")
    public void addBill(String billNo,Integer billType,Long billMoney,
                        String billText,String billWorker,String billOrderWorkers,
                        String billRemark,String payType){
        Bill bill=new Bill();
        bill.setBillNo(billNo);
        bill.setBillTime(new Date());
        bill.setBillType(billType);
        bill.setBillText(billText);
        bill.setBillMoney(billMoney);
        bill.setBillWorker(billWorker);
        bill.setBillOrderWorkers(billOrderWorkers);
        bill.setBillRemark(billRemark);
        bill.setPayType(payType);
        billService.addBill(bill);
    }

    @GetMapping("/today")
    @ApiOperation(value = "获取日常收支")
    public List<Bill> getTodayBill(){
        return billService.getTodayBill();
    }

    @GetMapping("/open")
    @ApiOperation(value = "获取开卡充值金额")
    public int getOpenBill(int isToday){
        return billService.getOpenBill(isToday);
    }

    @GetMapping("/all")
    @ApiOperation(value = "获取所有收支")
    public List<Bill> allBill(){
        return billService.allBill();
    }

    @ApiOperation(value = "分页获取开卡充值记录信息")
    @GetMapping("/page")
    public List<Bill> pageBill(int pagesize,int now){
        int num=(now-1)*pagesize; //分页开始的位置
        // now 为当前页数，pagesize 为每页个数
        return billService.pageBills(num,pagesize);
    }

    @GetMapping("/day")
    @ApiOperation(value = "根据日期获取收支")
    public List<Bill> getDayBill(String start,String end,int id){
        return billService.getDayBill(start,end,id);
    }
}
