package com.chen.lifaapi.mapper;

import com.chen.lifaapi.entity.Systems;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.mapper
 * @date 2022/2/23 21:41
 * @since 1.0
 */
@Mapper
public interface SystemMapper {
    int upSystem(Systems systems);
    Systems getSystem(String name);
}
