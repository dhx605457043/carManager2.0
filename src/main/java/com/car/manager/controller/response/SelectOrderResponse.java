package com.car.manager.controller.response;

import com.car.manager.util.poi.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


@Data
public class SelectOrderResponse {
    private Integer id;

    @Excel(name = "订单日期")
    private String orderDate;

    @Excel(name = "订单车辆")
    private String orderCarNumber;

    @Excel(name = "货主")
    private String cargoName;

    @Excel(name = "货品")
    private String consignorName;

    @Excel(name = "运费")
    private Integer freight;

    @Excel(name = "司机费用")
    private Integer driverCost;

    @Excel(name = "中国费用")
    private Integer chinaCost;

    @Excel(name = "朝鲜费用")
    private Integer koreaCost;

    @Excel(name = "隔离费用")
    private Integer quarantineCost;

    @Excel(name = "利润")
    private Integer profit;

    @Excel(name = "结账状态")
    private Integer orderType;

    private Integer consignorId;

    private Integer cargoId;

    private Integer orderCarId;



}
