package com.chen.lifaapi.service;

import com.chen.lifaapi.entity.Commodity;
import com.chen.lifaapi.entity.Vips;

import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service
 * @date 2022/1/12 20:18
 * @since 1.0
 */
public interface CommService {
    List<Commodity> getAllComm();
    List<Commodity> pageVipList(int num, int pagesize);
    int priceComm();
    int addComm(Commodity commodity);
    int upComm(Commodity commodity);
    int delComm(int id);
    List<Commodity> getSomeComm(String type);
}
