package com.chen.lifaapi.service.impl;

import com.chen.lifaapi.entity.Commodity;
import com.chen.lifaapi.entity.Vips;
import com.chen.lifaapi.mapper.CommodityMapper;
import com.chen.lifaapi.service.CommService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service.impl
 * @date 2022/1/12 20:18
 * @since 1.0
 */

@Service
public class CommServiceImpl implements CommService {
    @Autowired
    private CommodityMapper cm;

    @Override
    public List<Commodity> pageVipList(int num, int pagesize) {
        return cm.pageVipList(num,pagesize);
    }

    @Override
    public int priceComm() {
        return cm.priceComm();
    }

    @Override
    public int addComm(Commodity commodity) {
        return cm.insert(commodity);
    }

    @Override
    public int upComm(Commodity commodity) {
        return cm.upComm(commodity);
    }

    @Override
    public int delComm(int id) {
        return cm.delComm(id);
    }

    @Override
    public List<Commodity> getAllComm() {
        return cm.getAllComm();
    }
}
