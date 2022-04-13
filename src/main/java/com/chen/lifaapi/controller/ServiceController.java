package com.chen.lifaapi.controller;

import com.chen.lifaapi.entity.Service;
import com.chen.lifaapi.service.ServiceService;
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
 * @date 2022/1/12 17:10
 * @since 1.0
 */
@RestController
@Api(description="服务控制器")
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping("/all")
    @ApiOperation(value = "获取所有服务内容")
    public List<Service> getAllService(){
        return serviceService.getAllService();
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页获取服务内容")
    public List<Service> pageGetService(int pagesize,int now){
        int num=(now-1)*pagesize; //分页开始的位置
        // now 为当前页数，pagesize 为每页个数
        return serviceService.pageGetService(num,pagesize);
    }
    @PostMapping("/page")
    @ApiOperation(value = "删除服务项目")
    public int delService(int id){
        return serviceService.delService(id);
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加新的服务项目")
    public int addService(String name,String price){
        return serviceService.addService(name,price);
    }
}
