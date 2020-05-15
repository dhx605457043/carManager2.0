package com.car.manager.controller.response;

import lombok.Data;

@Data
public class SelectAllDriversResponse {
    private Integer driverId;

    private String driverName;
    private String driverPhoneNumber;
    private String driverAddress;
    private String driverIDCard;
}
