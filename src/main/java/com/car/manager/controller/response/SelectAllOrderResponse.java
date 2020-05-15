package com.car.manager.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SelectAllOrderResponse {
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
    private String cargoName;
    private String consignorName;
}
