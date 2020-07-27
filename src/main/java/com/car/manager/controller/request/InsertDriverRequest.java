package com.car.manager.controller.request;

import lombok.Data;

@Data
public class InsertDriverRequest {
    private Integer id;
    private String driverName;
    private String driverPhoneNumber;
    private String driverAddress;
    private String driverIdCard;
    private String role;
}
