package com.chen.lifaapi.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.chen.lifaapi.entity.Salarylog;
import com.chen.lifaapi.entity.Worker;
import com.chen.lifaapi.service.WorkerLevelService;
import com.chen.lifaapi.service.WorkerService;
import com.chen.lifaapi.utils.StringToUtf8;
import com.sun.corba.se.spi.orbutil.threadpool.Work;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.controller
 * @date 2022/1/12 16:15
 * @since 1.0
 */
@RestController
@Api(description="员工控制器")
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    private WorkerService workerService;
    @Autowired
    private WorkerLevelService wls;
    @Autowired
    private StringToUtf8 stu;

    @GetMapping("/all")
    @ApiOperation(value = "获取所有员工")
    public List<Worker> getAllWorker(){
        return workerService.getAllWorker();
    }

    @GetMapping("/get")
    @ApiOperation(value = "根据条件获取员工信息")
    public List<Worker> getWorker(String state,String level){
        int state2=0;
        if (state!=""){
            state2= Integer.parseInt(state);
        }
        return workerService.getWorker(state2,level);
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加新员工")
    public int addWorker(Worker worker){
        String level=worker.getLevelId();
        worker.setBaseSalary(wls.getLevelForID(level).getLevelCommission());
        return workerService.addWorker(worker);
    }

    @PostMapping("/oneforid")
    @ApiOperation(value = "根据id获取员工信息")
    public Worker getOneForId(String id){
        return workerService.getOneForId(id);
    }

    @PostMapping("/pay")
    @ApiOperation(value = "发放员工工资")
    public int payRoll(Salarylog salarylog){
        salarylog.setSaDate(new Date());
        return workerService.payRoll(salarylog);
    }

    @PostMapping("/bonus")
    @ApiOperation(value = "更新员工信息")
    public int upBounsWorker(Worker worker){
        return workerService.addBonus(worker.getWorkId(),worker.getBonus());
    }

    @PostMapping("/up")
    @ApiOperation(value = "更新员工信息")
    public int updateWorker(Worker worker){
        return workerService.updateWorker(worker);
    }

    @GetMapping("/outmoneytable")
    @ApiOperation(value = "导出工资表")
    public void outMoneyTable(HttpServletResponse response){
        List<Map<String,String>> salarylogs=workerService.getAllMoney();

        ExcelWriter writer= ExcelUtil.getWriter();
        writer.addHeaderAlias("saWorkId", "员工ID");
        writer.addHeaderAlias("workName", "员工姓名");
        writer.addHeaderAlias("saMoney", "基本工资");
        writer.addHeaderAlias("saBonus", "奖金");
        writer.addHeaderAlias("allMoney", "总工资");
        writer.addHeaderAlias("saDate", "日期");

        writer.merge(5, "员工工资信息表");
        writer.write(salarylogs, true);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");

        String name = stu.getUTF8XMLString("理发店员工工资信息表");

        response.setHeader("Content-Disposition", "attachment;filename=" +name+ ".xls");
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
