package com.car.manager.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class UpdateOrderRequest {
    private Integer id;

    private Integer consignorId;

    private Integer cargoId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private String orderDate;

    private Integer driverCost;

    private Integer chinaCost;

    private Integer koreaCost;

    private Integer freight;

    private Integer orderCarId;

    private Integer profit;

    private Integer orderType;

    private Integer quarantineCost;

    private String orderCarNumber;
}
