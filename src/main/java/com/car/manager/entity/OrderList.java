package com.car.manager.entity;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
@Data
/**
 * (OrderList)实体类
 *
 * @author makejava
 * @since 2020-05-15 15:21:43
 */
public class OrderList implements Serializable {
    private static final long serialVersionUID = -70482371480244817L;
    
    private Integer orderId;
    
    private Integer ownerOfCargo;
    
    private Integer goodsName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;
    
    private Integer driverCost;
    
    private Integer chinaCost;
    
    private Integer koreaCost;
    
    private Integer freight;
    
    private Integer orderCar;
    
    private Integer profit;
    
    private Integer orderType;
    
    private Integer quarantineCost;
    
    private String orderCarNumber;

}