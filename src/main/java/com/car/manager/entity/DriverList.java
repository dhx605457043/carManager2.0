package com.car.manager.entity;

import java.io.Serializable;
import lombok.Data;
@Data
/**
 * (DriverList)实体类
 *
 * @author makejava
 * @since 2020-05-15 14:21:56
 */
public class DriverList implements Serializable {
    private static final long serialVersionUID = 356289893271296608L;
    
    private Integer driverId;
    
    private String driverName;
    private String driverPhoneNumber;
    private String driverAddress;
    private String driverIDCard;

}