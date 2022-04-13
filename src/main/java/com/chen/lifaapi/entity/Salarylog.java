package com.chen.lifaapi.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * salarylog
 * @author 
 */
@Data
public class Salarylog implements Serializable {
    private Integer saId;

    private String saWorkId;

    private Long saMoney;

    private Date saDate;

    private Long saBonus;

    private static final long serialVersionUID = 1L;
}