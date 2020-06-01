package com.car.manager.controller.response;

import lombok.Data;

@Data
public class SelectOrderCarInformationResponse {
    private Integer id;

    private Integer orderCarId;

    private Integer orderDriverId;

    private Integer orderCargoId;

    private Integer orderTonnage;

    private String orderDate;
}
