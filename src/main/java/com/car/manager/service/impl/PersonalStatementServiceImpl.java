package com.car.manager.service.impl;

import com.car.manager.controller.request.InsertPersonalStatementRequest;
import com.car.manager.controller.request.SelectPersonalStatementRequest;
import com.car.manager.controller.request.UpdatePersonalStatementRequest;
import com.car.manager.controller.response.SelectPersonalStatementResponse;
import com.car.manager.dao.PersonalStatementMapper;
import com.car.manager.entity.PersonalStatement;
import com.car.manager.service.PersonalStatementService;
import com.car.manager.util.BeanCopyUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
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
    public List<PersonalStatement> selectAllPersonalStatement(SelectPersonalStatementRequest request) {
        PersonalStatement requestModel = BeanCopyUtils.copyBean(request,new PersonalStatement());
//        Example example = new Example(PersonalStatement.class);
//        example.setOrderByClause("statement_type");
        List<PersonalStatement> responseModel = personalStatementMapper.selectAllPersonalStatement(requestModel);
        return responseModel;
    }

    @Override
    public List<PersonalStatement> selectAllPersonalStatementCar() {
        return personalStatementMapper.selectAllPersonalStatementCar();
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