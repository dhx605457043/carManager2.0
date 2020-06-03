package com.car.manager.entity.Ex;

import com.car.manager.entity.CarList;
import com.car.manager.util.poi.Excel;
import lombok.Data;

@Data
public class CarListEx extends CarList {

//    private String carNumber;

//    @Excel(name = "司机姓名")
    private String driverName;
//    @Excel(name = "司机住址")
    private String driverAddress;
    private Integer carDriverId;
    private Integer driverId;
//    @Excel(name = "司机电话")
    private String driverPhoneNumber;
//    @Excel(name = "司机身份证")
    private String driverIdCard;
    private String licensePlateAreaName;
    private Integer licensePlateAreaCode;

}

