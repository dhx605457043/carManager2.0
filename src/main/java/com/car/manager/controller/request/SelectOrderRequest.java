package com.car.manager.controller.request;

import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class SelectOrderRequest {
    private Integer id;
    private String orderDate;
    private String orderCarNumber;
}
