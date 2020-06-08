package com.car.manager.entity;

import java.io.Serializable;

import com.car.manager.util.poi.Excel;
import lombok.Data;

import javax.persistence.Id;

@Data
/**
 * (PersonalStatement)实体类
 *
 * @author makejava
 * @since 2020-06-02 12:38:12
 */
public class PersonalStatement implements Serializable {
    private static final long serialVersionUID = -70197763103216842L;

    @Id
    private Integer id;
    /**
    * 订单日期
    */
    private String statementDate;
    /**
    * 运费
    */
    private Integer freight;
    /**
    * 司机费用
    */
    private Integer driverCost;
    /**
    * 中国费用
    */
    private Integer chinaCost;
    /**
    * 朝鲜费用
    */
    private Integer koreaCost;
    /**
    * 隔离费
    */
    private Integer quarantineCost;
    /**
    * 保险金额
    */
    private Double insurance;
    /**
    * 修车金额
    */
    private Integer carRepair;
    /**
    * 油费
    */
    private Integer oilCost;
    /**
    * 其他费用
    */
    private Integer otherCost;
    /**
     * 备注
     */
    private String remark;
    /**
    * 检测费用
    */
    private Double textCost;
    /**
    * 利润
    */
    private Double profit;
    /**
    * 订单结算类型
    */
    private String statementType;
    /**
    * 订单车辆id
    */
//    @Excel(name = "车辆号码")
    private int orderCarId;
    /**
    * 订单车辆号码
    */
//    @Excel(name = "车辆号码")
    private String orderCarNumber;

}