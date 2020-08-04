package com.car.manager.service.impl;

import com.car.manager.controller.request.InsertAccountingEntryRequest;
import com.car.manager.controller.request.SelectAccountingEntryRequest;
import com.car.manager.controller.request.UpdateAccountingEntryRequest;
import com.car.manager.controller.response.SelectAccountingEntryResponse;
import com.car.manager.entity.AccountingEntry;
import com.car.manager.dao.AccountingEntryDao;
import com.car.manager.entity.Ex.AccountingEntryEx;
import com.car.manager.service.AccountingEntryService;
import com.car.manager.util.BeanCopyUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AccountingEntry)表服务实现类
 *
 * @author Tom_wang
 * @since 2020-07-22 15:31:07
 */
@Service
public class AccountingEntryServiceImpl implements AccountingEntryService {
    @Resource
    private AccountingEntryDao accountingEntryDao;

    @Override
    public SelectAccountingEntryResponse selectOne(SelectAccountingEntryRequest request) {
        AccountingEntryEx responseModel = accountingEntryDao.queryById(request.getId());
        SelectAccountingEntryResponse response = BeanCopyUtils.copyBean(responseModel,new SelectAccountingEntryResponse());
        return response;
    }

    @Override
    public List<AccountingEntryEx> selectAllAccountingEntry(SelectAccountingEntryRequest request) {
        AccountingEntry requestModel = BeanCopyUtils.copyBean(request,new AccountingEntry());
        List<AccountingEntryEx> response = accountingEntryDao.queryAll(requestModel);
        return response;
    }

    @Override
    public int insertAccountingEntry(InsertAccountingEntryRequest request) {
        AccountingEntry requestModel = BeanCopyUtils.copyBean(request,new AccountingEntry());

        return accountingEntryDao.insertSelective(requestModel);
    }

    @Override
    public int updateAccountingEntry(UpdateAccountingEntryRequest request) {
        AccountingEntry requestModel = BeanCopyUtils.copyBean(request,new AccountingEntry());

        return accountingEntryDao.updateByPrimaryKeySelective(requestModel);
    }

    @Override
    public int deleteAccountingEntryById(int ids) {
        Example example = new Example(AccountingEntry.class);
        example.createCriteria().andEqualTo("id",ids);
        return accountingEntryDao.deleteByExample(example);
    }
}
