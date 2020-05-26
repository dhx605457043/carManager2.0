package com.car.manager.controller.request;

import lombok.Data;

@Data
public class SelectAllOrderRequest {
    private Integer pageNum;
    private Integer pageSize;
}
