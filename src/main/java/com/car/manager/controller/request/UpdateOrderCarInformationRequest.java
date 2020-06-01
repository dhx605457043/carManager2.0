package com.car.manager.controller.request;

import lombok.Data;

@Data
public class UpdateOrderCarInformationRequest {
    private Integer id;
    private Integer orderDriverId;
    private Integer orderCarId;
    private Integer orderCargoId;
    private Integer orderTonnage;
    private String orderDate;
}
