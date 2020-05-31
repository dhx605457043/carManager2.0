package com.car.manager.entity.Ex;

import com.car.manager.entity.OrderCarInformation;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class OrderCarInformationEx extends OrderCarInformation {
    private String driverName;
    private String driverAddress;
    private String driverPhoneNumber;
    private String driverIdCard;
    private String orderCargoName;
    private String vehicleNumber;

}
