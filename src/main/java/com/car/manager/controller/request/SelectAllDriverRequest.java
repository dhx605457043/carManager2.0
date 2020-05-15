package com.car.manager.controller.request;

import lombok.Data;

@Data
public class SelectAllDriverRequest {
    private Integer pageNum;
    private Integer pageSize;
}
