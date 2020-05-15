package com.car.manager.controller.response;

import lombok.Data;

@Data
public class SelectAllCarResponse {
    private Integer carId;
    private Integer driverId;

    private String carNumber;
    private String driverName;
    private String driverAddress;
    private String driverPhoneNumber;
    private String driverIDCard;


}
