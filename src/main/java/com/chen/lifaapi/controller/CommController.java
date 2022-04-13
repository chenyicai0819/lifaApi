package com.chen.lifaapi.controller;

import com.chen.lifaapi.entity.Commodity;
import com.chen.lifaapi.service.CommService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.controller
 * @date 2022/1/12 20:16
 * @since 1.0
 */

@RestController
@Api(description ="商品控制器")
@RequestMapping("/comm")
public class CommController {
    @Autowired
    private CommService commService;


    @ApiOperation(value = "获取所有商品")
    @GetMapping("/all")
    public List<Commodity> getAllComm(){
        return commService.getAllComm();
    }

    @ApiOperation(value = "分页获取商品")
    @GetMapping("/page")
    public List<Commodity> pageGetComm(int pagesize,int now){
        int num=(now-1)*pagesize; //分页开始的位置
        // now 为当前页数，pagesize 为每页个数
        return commService.pageVipList(num,pagesize);
    }

    @ApiOperation(value = "获取商品总价")
    @GetMapping("/price")
    public int priceComm(){
        return commService.priceComm();
    }

    @ApiOperation(value = "添加商品")
    @PostMapping("/add")
    public int addComm(Commodity commodity){
        return commService.addComm(commodity);
    }

    @ApiOperation(value = "修改商品")
    @PostMapping("/up")
    public int upComm(Commodity commodity){
        return commService.upComm(commodity);
    }

    @ApiOperation(value = "删除商品")
    @PostMapping("/del")
    public int delComm(int id){
        return commService.delComm(id);
    }
}
