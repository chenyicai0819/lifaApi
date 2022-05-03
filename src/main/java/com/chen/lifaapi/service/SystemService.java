package com.chen.lifaapi.service;

import com.chen.lifaapi.entity.Systems;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.service
 * @date 2022/2/23 21:40
 * @since 1.0
 */
public interface SystemService {
    int upSystem(Systems systems);
    Systems getSystem(String name);

}
