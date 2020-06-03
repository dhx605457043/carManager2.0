package com.car.manager.controller.response;

import com.car.manager.util.poi.Excel;
import lombok.Data;

@Data
public class SelectCarResponse {

    private Integer id;
    private Integer carDriverId;
    @Excel(name = "车辆号码")
    private String vehicleNumber;
    @Excel(name = "司机姓名")
    private String driverName;
    @Excel(name = "司机地址")
    private String driverAddress;
    @Excel(name = "司机电话")
    private String driverPhoneNumber;
    @Excel(name = "司机身份证")
    private String driverIdCard;
}
