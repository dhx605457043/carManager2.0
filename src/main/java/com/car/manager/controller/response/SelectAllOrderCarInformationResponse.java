package com.car.manager.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SelectAllOrderCarInformationResponse {
    private String driverName;
    private String driverAddress;
    private Integer driverId;
    private String driverPhoneNumber;
    private String driverIDCard;
    private String orderCargoName;
    private Integer orderTonnage;
    private String vehicleNumber;
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date orderDate;
}
