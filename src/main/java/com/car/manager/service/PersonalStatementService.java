package com.car.manager.service;

import com.car.manager.controller.request.InsertPersonalStatementRequest;
import com.car.manager.controller.request.SelectPersonalStatementRequest;
import com.car.manager.controller.request.UpdatePersonalStatementRequest;
import com.car.manager.controller.response.SelectPersonalStatementResponse;
import com.car.manager.core.page.TableDataInfo;
import com.car.manager.entity.PersonalStatement;

import java.util.List;

/**
 * (PersonalStatement)表服务接口
 *
 * @author makejava
 * @since 2020-06-02 12:38:12
 */
public interface PersonalStatementService {
//    TableDataInfo selectAllPersonalStatementPage(SelectPersonalStatementRequest request);
    List<PersonalStatement> selectAllPersonalStatement (SelectPersonalStatementRequest request);
    List<PersonalStatement> selectAllPersonalStatementCar ();
    int insertPersonalStatement (InsertPersonalStatementRequest request);
    SelectPersonalStatementResponse selectPersonalStatementById (SelectPersonalStatementRequest request);
    int updatePersonalStatement (UpdatePersonalStatementRequest request);
    int deletePersonalStatementById (int id);
}