package com.car.manager.controller.response;

import com.car.manager.util.poi.Excel;
import lombok.Data;

@Data
public class SelectPersonalStatementResponse {
    private Integer id;

    @Excel(name = "账单日期")
    private String statementDate;

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


    @Excel(name = "保险费")
    private Double insurance;

    @Excel(name = "修车费")
    private Integer carRepair;

    @Excel(name = "油费")
    private Integer oilCost;

    @Excel(name = "检测费")
    private Double textCost;

    @Excel(name = "其他费用")
    private Integer otherCost;

    @Excel(name = "备注")
    private String remark;

    @Excel(name = "利润")
    private Double profit;

    @Excel(name = "结账状态")
    private Integer statementType;

    private Integer orderCarId;

    private String orderCarNumber;
}
