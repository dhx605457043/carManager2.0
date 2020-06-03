package com.car.manager.controller.request;

import lombok.Data;

@Data
public class UpdatePersonalStatementRequest {
    private Integer id;

    private String statementDate;

    private Integer freight;

    private Integer driverCost;

    private Integer chinaCost;

    private Integer koreaCost;

    private Integer quarantineCost;

    private String statementType;

    private Double profit;

    private Integer orderCarId;

    private Double insurance;

    private Integer carRepair;

    private Integer oilCost;

    private Integer otherCost;
    private String remark;

    private Double textCost;

    private String orderCarNumber;
}
