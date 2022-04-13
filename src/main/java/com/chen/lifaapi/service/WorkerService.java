package com.chen.lifaapi.service;

import com.chen.lifaapi.entity.Salarylog;
import com.chen.lifaapi.entity.Worker;

import java.util.List;
import java.util.Map;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service
 * @date 2022/1/12 16:16
 * @since 1.0
 */
public interface WorkerService {
    // 获取所有员工
    List<Worker> getAllWorker();
    //添加新员工
    int addWorker(Worker worker);
    // 添加员工奖金
    int addBonus(String id,Long bonus);
    Long getBonus(String id); // 查询奖金
    List<Worker> getWorker(int state,String level);
    int payRoll(Salarylog salarylog);
    int updateWorker(Worker worker);
    List<Map<String,String>> getAllMoney();
    Worker getOneForId(String id);
}
