package com.car.manager.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SelectAllOrderCarInformationResponse {
    private String driverName;
    private String driverAddress;
    private Integer orderCarId;
    private Integer orderDriverId;

    private Integer id;
    private Integer driverId;
    private Integer carDriverId;

    private String driverPhoneNumber;
    private String driverIdCard;
    private String orderCargoName;
    private Integer orderTonnage;
    private String vehicleNumber;
    private String orderDate;
}
