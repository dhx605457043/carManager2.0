package com.car.manager.controller.request;

import lombok.Data;

@Data
public class SelectCarRequest {
    private Integer id;
    private String carNumber;
    private String vehicleNumber;
}
