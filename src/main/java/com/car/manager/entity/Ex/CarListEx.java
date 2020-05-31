package com.car.manager.entity.Ex;

import com.car.manager.entity.CarList;
import lombok.Data;

@Data
public class CarListEx extends CarList {
    private String carNumber;
    private String driverName;
    private String driverAddress;
    private Integer carDriverId;
    private Integer driverId;
    private String driverPhoneNumber;
    private String driverIdCard;
    private String licensePlateAreaName;
    private Integer licensePlateAreaCode;

}

