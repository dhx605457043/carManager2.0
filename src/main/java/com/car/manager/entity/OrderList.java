package com.car.manager.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import sun.util.calendar.BaseCalendar;
import sun.util.calendar.LocalGregorianCalendar;

import javax.persistence.Id;

@Data
/**
 * (OrderList)实体类
 *
 * @author makejava
 * @since 2020-05-15 15:21:43
 */
public class OrderList implements Serializable {
    private static final long serialVersionUID = -70482371480244817L;

    @Id
    private Integer id;
    
    private Integer consignorId;
    
    private Integer cargoId;


    private String orderDate;
    
    private Integer driverCost;
    
    private Integer chinaCost;
    
    private Integer koreaCost;
    
    private Integer freight;
    
    private Integer orderCarId;
    
    private Integer profit;
    
    private String orderType;
    
    private Integer quarantineCost;
    
    private String orderCarNumber;

}