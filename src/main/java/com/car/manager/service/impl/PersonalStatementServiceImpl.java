package com.car.manager.service.impl;

import com.car.manager.controller.request.InsertPersonalStatementRequest;
import com.car.manager.controller.request.SelectPersonalStatementRequest;
import com.car.manager.controller.request.UpdatePersonalStatementRequest;
import com.car.manager.controller.response.SelectOrderResponse;
import com.car.manager.controller.response.SelectPersonalStatementResponse;
import com.car.manager.core.page.PageDomain;
import com.car.manager.core.page.TableDataInfo;
import com.car.manager.core.page.TableSupport;
import com.car.manager.dao.PersonalStatementMapper;
import com.car.manager.entity.Ex.OrderListEx;
import com.car.manager.entity.OrderList;
import com.car.manager.entity.PersonalStatement;
import com.car.manager.service.PersonalStatementService;
import com.car.manager.util.BeanCopyUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * (PersonalStatement)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 12:38:12
 */
@Service()
public class PersonalStatementServiceImpl implements PersonalStatementService {
    @Resource
    private PersonalStatementMapper personalStatementMapper;

    @Override
    public TableDataInfo selectAllPersonalStatementPage(SelectPersonalStatementRequest request) {
        PersonalStatement requestModel = BeanCopyUtils.copyBean(request,new PersonalStatement());
        List<PersonalStatement> personalStatements = personalStatementMapper.selectAllPersonalStatement(requestModel);
        TableDataInfo rspData = new TableDataInfo();
        List<PersonalStatement> personalStatementList = new ArrayList<PersonalStatement>(Arrays.asList(new PersonalStatement[personalStatements.size()]));
        Collections.copy(personalStatementList, personalStatements);
        PageDomain pageDomain = TableSupport.buildPageRequest();
        if (null == pageDomain.getPageNum() || null == pageDomain.getPageSize()) {
            rspData.setRows(personalStatementList);
            rspData.setTotal(personalStatementList.size());
            return rspData;
        }
        Integer pageNum = (pageDomain.getPageNum() - 1) * pageDomain.getPageSize();
        Integer pageSize = pageDomain.getPageNum() * pageDomain.getPageSize();
        if (pageSize > personalStatementList.size()) {
            pageSize = personalStatementList.size();
        }
        rspData.setRows(personalStatementList.subList(pageNum, pageSize));
        rspData.setTotal(personalStatementList.size());
        return rspData;
    }

    @Override
    public List<SelectPersonalStatementResponse> selectAllPersonalStatement() {
        Example example = new Example(PersonalStatement.class);
//        example.createCriteria().an("id", requestModel.getId());
        example.setOrderByClause("statement_type");
        List<PersonalStatement> responseModel = personalStatementMapper.selectByExample(example);
        List<SelectPersonalStatementResponse> response = (List<SelectPersonalStatementResponse>) BeanCopyUtils.copyBeanList(responseModel,SelectPersonalStatementResponse.class);
        return response;
    }

    @Override
    public int insertPersonalStatement(InsertPersonalStatementRequest request) {
        PersonalStatement requestModel = BeanCopyUtils.copyBean(request,new PersonalStatement());
        return personalStatementMapper.insertSelective(requestModel);
    }

    @Override
    public SelectPersonalStatementResponse selectPersonalStatementById(SelectPersonalStatementRequest request) {
        PersonalStatement requestModel = BeanCopyUtils.copyBean(request,new PersonalStatement());
        PersonalStatement responseModel = personalStatementMapper.selectByPrimaryKey(requestModel);
        SelectPersonalStatementResponse response = BeanCopyUtils.copyBean(responseModel,new SelectPersonalStatementResponse());
        return response;
    }

    @Override
    public int updatePersonalStatement(UpdatePersonalStatementRequest request) {
        PersonalStatement requestModel = BeanCopyUtils.copyBean(request,new PersonalStatement());
        Example example = new Example(PersonalStatement.class);
        example.createCriteria().andEqualTo("id", requestModel.getId());
        return personalStatementMapper.updateByExampleSelective(requestModel,example);
    }

    @Override
    public int deletePersonalStatementById(int id) {
        PersonalStatement requestModel = new PersonalStatement();
        requestModel.setId(id);
        return personalStatementMapper.deleteByPrimaryKey(requestModel);
    }
}