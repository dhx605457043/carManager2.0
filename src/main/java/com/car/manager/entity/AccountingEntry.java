package com.car.manager.entity;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @description (accounting_entry)表实体类
 *
 * @author Tom_wang
 * @date 2020-07-22 15:31:07
 */
@Data
public class AccountingEntry implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
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
    /**
    * 备注
    */
    private String remark;
    private String statementType;
}
