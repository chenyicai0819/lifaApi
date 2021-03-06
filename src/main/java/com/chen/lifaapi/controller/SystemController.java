package com.chen.lifaapi.controller;

import com.chen.lifaapi.aop.Log;
import com.chen.lifaapi.entity.Systemlog;
import com.chen.lifaapi.entity.Systems;
import com.chen.lifaapi.service.LogService;
import com.chen.lifaapi.service.SystemService;
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
 * @date 2022/2/23 21:38
 * @since 1.0
 */
@RestController
@Api(description="开店设置项目")
@RequestMapping("/systems")
public class SystemController {
    @Autowired
    private SystemService systemService;
    @Autowired
    private LogService ls;

    @PostMapping("/up")
    @ApiOperation(value = "修改设置")
    @Log(value = "修改设置")
    public int upSystem(Systems systems){
        return systemService.upSystem(systems);
    }

    @PostMapping("/get")
    @ApiOperation(value = "获取设置内容")
    public Systems getSystem(String name){
        return systemService.getSystem(name);
    }

    @GetMapping("/log/all")
    @ApiOperation(value = "获取所有日志记录")
    public List<Systemlog> getAllLog(){
        return ls.getSystem();
    }
}
