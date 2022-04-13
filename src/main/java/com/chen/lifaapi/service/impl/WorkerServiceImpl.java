package com.chen.lifaapi.service.impl;

import com.chen.lifaapi.entity.Salarylog;
import com.chen.lifaapi.entity.Worker;
import com.chen.lifaapi.mapper.SalarylogMapper;
import com.chen.lifaapi.mapper.WorkerMapper;
import com.chen.lifaapi.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service.impl
 * @date 2022/1/12 16:17
 * @since 1.0
 */
@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerMapper workerMapper;
    @Autowired
    private SalarylogMapper salarylogMapper;

    @Override
    public List<Worker> getAllWorker() {
        return workerMapper.getAllWorker();
    }

    @Override
    public int addWorker(Worker worker) {
        return workerMapper.addWorker(worker);
    }

    @Override
    public int addBonus(String id,Long bonus) {
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        map.put("bonus",bonus);
        return workerMapper.addBonus(map);
    }

    @Override
    public Long getBonus(String id) {
        return workerMapper.getBonus(id);
    }

    @Override
    public List<Worker> getWorker(int state, String level) {
        Map<String,Object> map=new HashMap<>();
        map.put("state",state);
        map.put("level",level);
        return workerMapper.getWorker(map);
    }

    @Override
    public int payRoll(Salarylog salarylog) {
        return salarylogMapper.payRoll(salarylog);
    }

    @Override
    public int updateWorker(Worker worker) {
        return workerMapper.updateWorker(worker);
    }

    @Override
    public List<Map<String,String>> getAllMoney() {
        return salarylogMapper.getAllMoney();
    }

    @Override
    public Worker getOneForId(String id) {
        return workerMapper.getOneForId(id);
    }
}
