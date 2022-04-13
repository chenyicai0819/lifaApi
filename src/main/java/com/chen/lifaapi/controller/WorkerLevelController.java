package com.chen.lifaapi.controller;

import com.chen.lifaapi.entity.Wokelevel;
import com.chen.lifaapi.entity.Worker;
import com.chen.lifaapi.service.WorkerLevelService;
import com.chen.lifaapi.service.WorkerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.controller
 * @date 2022/1/19 11:55
 * @since 1.0
 */
@RestController
@Api(description="员工等级控制器")
@RequestMapping("/workerlevel")
public class WorkerLevelController {
    @Autowired
    private WorkerLevelService wls;

    @GetMapping("/all")
    @ApiOperation(value = "获取所有员工等级")
    public List<Wokelevel> getAllWorker(){
        return wls.getAllLevel();
    }
}
