package com.chen.lifaapi.service.impl;

import com.chen.lifaapi.entity.Commoditytype;
import com.chen.lifaapi.mapper.CommoditytypeMapper;
import com.chen.lifaapi.service.CommTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.comments.CommentType;

import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service.impl
 * @date 2022/2/15 22:13
 * @since 1.0
 */
@Service
public class CommTypeServiceImpl implements CommTypeService {

    @Autowired
    private CommoditytypeMapper ctm;
    @Override
    public List<Commoditytype> getAllType() {
        return ctm.getAllType();
    }

}
