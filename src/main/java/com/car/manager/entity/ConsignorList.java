package com.car.manager.entity;

import java.io.Serializable;
import lombok.Data;
@Data
/**
 * (ConsignorList)实体类
 *
 * @author makejava
 * @since 2020-05-15 15:22:19
 */
public class ConsignorList implements Serializable {
    private static final long serialVersionUID = -54857093099281033L;
    
    private Integer consignorId;
    
    private String consignorName;

}