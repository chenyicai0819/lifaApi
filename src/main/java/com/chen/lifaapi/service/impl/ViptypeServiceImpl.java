package com.chen.lifaapi.service.impl;

import com.chen.lifaapi.entity.Viptypes;
import com.chen.lifaapi.mapper.ViptypesMapper;
import com.chen.lifaapi.service.ViptypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service.impl
 * @date 2022/1/18 11:34
 * @since 1.0
 */
@Service
public class ViptypeServiceImpl implements ViptypeService {

    @Autowired
    private ViptypesMapper vm;
    @Override
    public List<Viptypes> allViptype() {
        return vm.allViptype();
    }

    @Override
    public int delVipType(int id) {
        return vm.delVipType(id);
    }

    @Override
    public Viptypes getDiscountById(int id) {
        return vm.getDiscountById(id);
    }
}
