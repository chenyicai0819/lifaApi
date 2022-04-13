package com.chen.lifaapi.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * pending
 * @author 
 */
@Data
public class Pending implements Serializable {
    private String penid;

    private String penname;

    private Long penprice;

    private String pentext;

    private Long penmoney;

    private String penworker;

    private String penremark;

    private static final long serialVersionUID = 1L;
}