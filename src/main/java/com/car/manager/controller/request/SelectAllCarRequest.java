package com.car.manager.controller.request;

import lombok.Data;

@Data
public class SelectAllCarRequest {
    private Integer pageNum;
    private Integer pageSize;
}
