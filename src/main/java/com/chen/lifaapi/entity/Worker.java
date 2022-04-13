package com.chen.lifaapi.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import lombok.Data;

/**
 * worker
 * @author 
 */
@Data
public class Worker implements Serializable {
    private String workId;

    private String levelId;

    private String workName;

    private String workSex;

    private String workPhone;

    private Integer workState;

    private Timestamp workDate;

    private Timestamp workBirthday;

    private String workIDcard;

    private String workBank;

    private Long baseSalary;

    private Long bonus;

    private static final long serialVersionUID = 1L;
}