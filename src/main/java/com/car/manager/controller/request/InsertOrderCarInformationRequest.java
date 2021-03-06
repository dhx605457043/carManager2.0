package com.car.manager.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class InsertOrderCarInformationRequest {
    private Integer id;

    private Integer orderDriverId;
    private Integer orderCarId;
    private Integer orderCargoId;

    private Integer orderTonnage;
    private String orderDate;
}
