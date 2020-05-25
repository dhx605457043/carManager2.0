package com.car.manager.entity.Ex;

import com.car.manager.entity.OrderCarInformation;
import lombok.Data;

@Data
public class OrderCarInformationEx extends OrderCarInformation {
    private String carNumber;
    private String driverName;
    private String driverAddress;
    private Integer driverId;
    private String driverPhoneNumber;
    private String driverIDCard;
    private String licensePlateAreaName;
    private Integer licensePlateAreaCode;
}
