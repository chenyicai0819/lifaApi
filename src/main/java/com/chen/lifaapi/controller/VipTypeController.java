package com.chen.lifaapi.controller;

import com.chen.lifaapi.aop.Log;
import com.chen.lifaapi.entity.Viptypes;
import com.chen.lifaapi.service.ViptypeService;
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
 * @date 2022/1/18 11:29
 * @since 1.0
 */
@Api(description ="会员类型控制器类")
@RestController
@RequestMapping("/viptype")
public class VipTypeController {
    @Autowired
    private ViptypeService vs;

    @ApiOperation(value = "获取所有会员类型")
    @GetMapping("/all")
    public List<Viptypes> allVipType(){
        return vs.allViptype();
    }

    @ApiOperation(value = "删除会员类型")
    @PostMapping("/del")
    @Log(value = "删除会员类型")
    public int delVipType(int id){
        return vs.delVipType(id);
    }

    @ApiOperation(value = "获取会员折扣")
    @PostMapping("/discount")
    public Viptypes getDiscountById(int id){
        return vs.getDiscountById(id);
    }
}
