package com.car.manager.entity;

import java.io.Serializable;
import lombok.Data;
@Data
/**
 * (LicensePlateAreaList)实体类
 *
 * @author makejava
 * @since 2020-05-15 15:22:19
 */
public class LicensePlateAreaList implements Serializable {
    private static final long serialVersionUID = -40880977805377393L;
    
    private Integer licensePlateAreaCode;
    
    private String licensePlateAreaName;

}