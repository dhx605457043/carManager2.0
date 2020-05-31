package com.car.manager.entity;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.Id;

@Data
/**
 * (ConsignorList)实体类
 *
 * @author makejava
 * @since 2020-05-15 15:22:19
 */
public class ConsignorList implements Serializable {
    private static final long serialVersionUID = -54857093099281033L;
    @Id
    private Integer id;
    
    private String consignorName;

}