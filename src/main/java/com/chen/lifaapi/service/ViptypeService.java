package com.chen.lifaapi.service;

import com.chen.lifaapi.entity.Viptypes;

import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service
 * @date 2022/1/18 11:34
 * @since 1.0
 */
public interface ViptypeService {

    List<Viptypes> allViptype();
    int delVipType(int id);
    Viptypes getDiscountById(int id);
}
