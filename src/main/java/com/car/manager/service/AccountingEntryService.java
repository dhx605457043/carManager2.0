package com.car.manager.service;

import com.car.manager.controller.request.InsertAccountingEntryRequest;
import com.car.manager.controller.request.SelectAccountingEntryRequest;
import com.car.manager.controller.request.UpdateAccountingEntryRequest;
import com.car.manager.controller.response.SelectAccountingEntryResponse;
import com.car.manager.entity.AccountingEntry;
import java.util.List;

/**
 * (AccountingEntry)表服务接口
 *
 * @author Tom_wang
 * @since 2020-07-22 15:31:07
 */
public interface AccountingEntryService {

    SelectAccountingEntryResponse selectOne (SelectAccountingEntryRequest request);
    List<SelectAccountingEntryResponse> selectAllAccountingEntry(SelectAccountingEntryRequest request);

    int insertAccountingEntry(InsertAccountingEntryRequest request);

    int updateAccountingEntry(UpdateAccountingEntryRequest request);

    int deleteAccountingEntryById(int ids);
}
