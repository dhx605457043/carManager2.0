package com.car.manager.controller.request;

import lombok.Data;

@Data
public class SelectOrderCarInformationRequest {
    private Integer id;
    private String orderDate;
    private String orderCarNumber;
}
