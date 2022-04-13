package com.chen.lifaapi.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * wokelevel
 * @author 
 */
@Data
public class Wokelevel implements Serializable {
    private String levelId;

    private String levelName;

    private Long levelCommission;

    private static final long serialVersionUID = 1L;
}