package com.chen.lifaapi.service.impl;

import com.chen.lifaapi.entity.Vips;
import com.chen.lifaapi.mapper.VipsMapper;
import com.chen.lifaapi.service.VipsService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service.impl
 * @date 2021/11/22 19:41
 * @since 1.0
 */
@Service
public class VipsServiceImpl implements VipsService {

    @Autowired
    private VipsMapper vipsMapper;

    @Override
    public List<Vips> getVipList() {
        return vipsMapper.getVipList();
    }

    @Override
    public List<Vips> pageVipList(int num, int pagesize) {
        return vipsMapper.pageVipList(num,pagesize);
    }

    @Override
    public int addVips(Vips vips) {
        return vipsMapper.insert(vips);
    }

    @Override
    public int updateVips(Vips vips) {
        return vipsMapper.updateByPrimaryKeySelective(vips);
    }

    @Override
    public int indexVips() {
        return vipsMapper.indexVips();
    }

    @Override
    public int getVipNumForPhone(String phone) {
        return vipsMapper.getVipNumForPhone(phone);
    }

    @Override
    public Vips getVipForPhone(String phone) {
        return vipsMapper.getVipForPhone(phone);
    }

    @Override
    public int getNowMoney(String id) {
        return vipsMapper.getNowMoney(id);
    }

    @Override
    public List<Vips> getVipsByEvery(Vips vips) {
        return vipsMapper.getVipsByEvery(vips);
    }

    @Override
    public Vips getOneVipForId(String id) {
        return vipsMapper.getOneVipForId(id);
    }

    @Override
    public int insertVipBatch(List<Vips> vipDataList) {
        return vipsMapper.insertVipBatch(vipDataList);
    }


}
