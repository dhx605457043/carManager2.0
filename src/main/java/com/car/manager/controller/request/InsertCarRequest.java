package com.car.manager.controller.request;

import lombok.Data;

@Data
public class InsertCarRequest {

    private String carNumber;
    private Integer carLicensePlateAreaCode;

}
