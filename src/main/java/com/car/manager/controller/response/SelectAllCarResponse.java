package com.car.manager.controller.response;

import lombok.Data;

@Data
public class SelectAllCarResponse {
    private Integer id;
    private Integer carDriverId;

    private String vehicleNumber;
    private String driverName;
    private String driverAddress;
    private String driverPhoneNumber;
    private String driverIDCard;


}
