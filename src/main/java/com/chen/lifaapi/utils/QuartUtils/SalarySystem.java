package com.chen.lifaapi.utils.QuartUtils;

import org.springframework.stereotype.Component;

/**
 * @author George
 * @project lifaApi
 * @package com.chen.lifaapi.utils.QuartUtils
 * @date 2022/4/15 0:26
 * @since 1.0
 */

@Component
public class SalarySystem {

    /**
     * 更新工资发放情况
     * @return
     */
    public int salaryForMonth(){
        // 返回0表示更新工资为未发放，每个月一次
        return 0;
    }
}
