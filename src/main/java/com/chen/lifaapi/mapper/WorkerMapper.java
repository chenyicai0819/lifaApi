package com.chen.lifaapi.mapper;

import com.chen.lifaapi.entity.Orders;
import com.chen.lifaapi.entity.Worker;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface WorkerMapper {

    List<Worker> getAllWorker();
    int addWorker(Worker worker);
    int addBonus(Map<String,Object> map);
    Long getBonus(String id);
    String getIdForName(String name);
    List<Worker> getWorker(Map<String,Object> map);
    int updateWorker(Worker worker);
    Worker getOneForId(String id);
    List<Worker> getInWorker();
}