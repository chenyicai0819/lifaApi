package com.chen.lifaapi.mapper;

import com.chen.lifaapi.entity.Systemlog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.mapper
 * @date 2022/5/2 10:18
 * @since 1.0
 */
@Mapper
public interface LogMapper {
    int addSystemLog(Systemlog systemlog);
    List<Systemlog> getSystem();
    Systemlog getLastLogin();
}
