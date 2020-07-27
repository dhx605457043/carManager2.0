package com.car.manager.entity.Ex;

import com.car.manager.entity.AccountingEntry;
import lombok.Data;

/**
 * @Author Tom_wang
 * @create 2020/7/22 6:31 下午
 */
@Data
public class AccountingEntryEx extends AccountingEntry {
    private String accountingEntryUserName;
    private String payUserName;
}
