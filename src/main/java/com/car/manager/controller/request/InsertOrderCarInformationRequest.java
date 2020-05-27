package com.car.manager.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class InsertOrderCarInformationRequest {
    private Integer orderCarId;

    private Integer orderDriverId;

    private Integer orderCargoId;

    private Integer orderTonnage;

//    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date orderDate;
}
