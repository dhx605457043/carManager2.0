package com.car.manager.controller.response;

import lombok.Data;

@Data
public class SelectCarResponse {
    private Integer id;

    private String carNumber;

    private Integer carDriverId;

    private Integer carLicensePlateAreaCode;
    private String vehicleNumber;
}
