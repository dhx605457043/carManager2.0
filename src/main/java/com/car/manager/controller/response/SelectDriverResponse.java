package com.car.manager.controller.response;

import com.car.manager.util.poi.Excel;
import lombok.Data;

/**
 * @author Tom
 */
@Data
public class SelectDriverResponse {
    private Integer id;
    @Excel(name = "司机姓名")
    private String driverName;
    @Excel(name = "司机电话")
    private String driverPhoneNumber;
    @Excel(name = "司机住址")
    private String driverAddress;
    @Excel(name = "司机身份证")
    private String driverIdCard;
    private String role;

}
