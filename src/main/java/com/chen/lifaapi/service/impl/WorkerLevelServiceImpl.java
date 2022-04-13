package com.chen.lifaapi.service.impl;

import com.chen.lifaapi.entity.Wokelevel;
import com.chen.lifaapi.mapper.WokelevelMapper;
import com.chen.lifaapi.service.WorkerLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service.impl
 * @date 2022/1/19 11:58
 * @since 1.0
 */
@Service
public class WorkerLevelServiceImpl implements WorkerLevelService {
    @Autowired
    private WokelevelMapper wm;
    @Override
    public List<Wokelevel> getAllLevel() {
        return wm.getAllLevel();
    }

    @Override
    public Wokelevel getLevelForID(String id) {
        return wm.getLevelForID(id);
    }
}
