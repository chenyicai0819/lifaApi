package com.chen.lifaapi.service;

import com.chen.lifaapi.entity.Wokelevel;

import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service
 * @date 2022/1/19 11:56
 * @since 1.0
 */
public interface WorkerLevelService {
    List<Wokelevel> getAllLevel(); // 获取所有等级
    Wokelevel getLevelForID(String id);
}
