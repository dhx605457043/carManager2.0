package com.car.manager.controller.response;

import lombok.Data;

/**
 * @Author Tom_wang
 * @create 2020/7/22 4:14 下午
 */
@Data
public class SelectAccountingEntryResponse {
    private Integer id;
    /**
     * 记账人id
     */
    private Integer accountingEntryUserId;
    private String accountingEntryUserName;
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
    private String payUserName;
    /**
     * 备注
     */
    private String remark;
    private String statementType;

}
