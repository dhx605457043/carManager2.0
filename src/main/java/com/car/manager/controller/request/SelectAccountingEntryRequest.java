package com.car.manager.controller.request;

import lombok.Data;

/**
 * @Author Tom_wang
 * @create 2020/7/22 3:52 下午
 */
@Data
public class SelectAccountingEntryRequest {
    private Integer id;

    /**
     * 记账人id
     */
    private Integer accountingEntryUserId;
    /**
     * 金额
     */
    private Double money;
    /**
     * 记账日期
     */
    private String billDate;
    /**
     * 支出者id
     */
    private Integer payUserId;
    private String statementType;

}
