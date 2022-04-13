package com.chen.lifaapi.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.chen.lifaapi.entity.Vips;
import com.chen.lifaapi.service.VipsService;
import com.chen.lifaapi.utils.DownloadFile;
import com.chen.lifaapi.utils.StringToUtf8;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.controller
 * @date 2021/11/22 19:37
 * @since 1.0
 */
@Api(description ="会员信息Controller")
@RestController
@RequestMapping("/vips")
public class VipsController {

    @Autowired
    private VipsService vipsService;
    @Autowired
    private StringToUtf8 stu;

    @ApiOperation(value = "获取所有Vip信息")
    @GetMapping("/get")
    public List<Vips> getVipList(){
        return vipsService.getVipList();
    }

    @ApiOperation(value = "分页获取Vip信息")
    @GetMapping("/page")
    public List<Vips> pageVipList(int pagesize,int now){
        int num=(now-1)*pagesize; //分页开始的位置
        // now 为当前页数，pagesize 为每页个数
        return vipsService.pageVipList(num,pagesize);
    }

    @ApiOperation(value = "添加Vips客户")
    @PostMapping("/add")
    public int addVips(Vips vips){
        vips.setVipOpencard(new Timestamp(System.currentTimeMillis()));
        vips.setVipsLast(new Timestamp(System.currentTimeMillis()));
        return vipsService.addVips(vips);
    }

    @ApiOperation(value = "修改会员信息")
    @PostMapping("/up")
    public int updateVips(Vips vips){
        return vipsService.updateVips(vips);
    }

    @ApiOperation(value = "获取会员数量")
    @GetMapping("/index")
    public int indexVips(){
        return vipsService.indexVips();
    }


    @ApiOperation(value = "导出所有会员（excel）")
    @GetMapping("/out")
    public void outAllVips(HttpServletResponse response){
        List<Vips> vips=vipsService.getVipList();

        ExcelWriter writer= ExcelUtil.getWriter();
        writer.addHeaderAlias("vipId", "会员ID");
        writer.addHeaderAlias("typeId", "会员类型");
        writer.addHeaderAlias("vipName", "会员姓名");
        writer.addHeaderAlias("vipPassword", "会员密码");
        writer.addHeaderAlias("vipPhone", "会员电话");
        writer.addHeaderAlias("vipSex", "会员性别");
        writer.addHeaderAlias("vipBirthday", "会员生日");
        writer.addHeaderAlias("vipOpencard", "开卡时间");
        writer.addHeaderAlias("vipsMoney", "会员卡金");
        writer.addHeaderAlias("vipsConsume", "会员消费");
        writer.addHeaderAlias("vipsBonus", "会员奖金");
        writer.addHeaderAlias("vipsLast", "最后消费时间");
        writer.merge(11, "会员信息表");
        writer.write(vips, true);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");

        String name = stu.getUTF8XMLString("理发店会员信息表");

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

    @ApiOperation(value = "获取会员余额")
    @PostMapping("/getmoney")
    public int getNowMoney(String id){
        return vipsService.getNowMoney(id);
    }

    @ApiOperation(value = "根据条件查询会员信息")
    @PostMapping("/getbyevery")
    public List<Vips> getVipsByEvery(Vips vips){
        if (vips.getTypeId()==0){
            vips.setTypeId(null);
        }
        if ("".equals(vips.getVipSex())||"2".equals(vips.getVipSex())){
            vips.setVipSex(null);
        }
        return vipsService.getVipsByEvery(vips);
        // return null;
    }

    @ApiOperation(value = "根据id获取一个会员的信息")
    @PostMapping("/oneforid")
    public Vips getOneVipForId(String id){
        return vipsService.getOneVipForId(id);
    }
}
