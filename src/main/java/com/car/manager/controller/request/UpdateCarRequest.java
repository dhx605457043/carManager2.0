package com.car.manager.controller.request;

import lombok.Data;

@Data
public class UpdateCarRequest {
    private Integer id;

    private String carNumber;
    private Integer carLicensePlateAreaCode;
    private Integer carDriverId;
    private String vehicleNumber;
}
