package com.car.manager.controller.request;

import lombok.Data;

@Data
public class SelectDriverRequest {
    private Integer id;
    private String driverIdCard;
    private String driverPhoneNumber;
    private String driverName;
}
