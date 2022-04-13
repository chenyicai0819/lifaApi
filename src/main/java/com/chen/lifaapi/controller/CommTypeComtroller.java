package com.chen.lifaapi.controller;

import com.chen.lifaapi.entity.Commoditytype;
import com.chen.lifaapi.service.CommTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.comments.CommentType;

import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.controller
 * @date 2022/2/15 22:09
 * @since 1.0
 */
@RestController
@Api(description ="商品类别控制器")
@RequestMapping("/commtype")
public class CommTypeComtroller {

    @Autowired
    private CommTypeService cts;

    @ApiOperation(value = "获取所有商品类别")
    @GetMapping("/all")
    public List<Commoditytype> getAllType(){
        return cts.getAllType();
    }
}
