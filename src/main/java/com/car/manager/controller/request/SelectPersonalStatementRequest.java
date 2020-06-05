package com.car.manager.controller.request;

import lombok.Data;

@Data
public class SelectPersonalStatementRequest {
    private Integer id;
    private String statementDate;
    private String orderCarNumber;
}
