package com.car.manager.controller.response;

import lombok.Data;

@Data
public class SelectDriverResponse {
    private Integer id;
    private String driverName;
    private String driverPhoneNumber;
    private String driverAddress;
    private String driverIdCard;
}
