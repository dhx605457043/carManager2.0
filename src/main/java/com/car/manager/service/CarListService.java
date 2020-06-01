package com.car.manager.service;

import com.car.manager.controller.request.*;
import com.car.manager.controller.response.SelectAllCarResponse;
import com.car.manager.controller.response.SelectCarResponse;
import com.car.manager.core.page.TableDataInfo;

import java.util.List;

/**
 * (CarList)表服务接口
 *
 * @author makejava
 * @since 2020-05-14 17:58:00
 */
public interface CarListService {
    List<SelectAllCarResponse> selectAllCar (SelectCarRequest request);
    TableDataInfo selectAllCarPage (SelectCarRequest request);
    int insertCar (InsertCarRequest request);
    boolean selectCarByCarNumber (SelectCarRequest request);
    SelectCarResponse selectCarById (SelectCarRequest request);
    int updateCar (UpdateCarRequest request);
    int deleteCarById (int id);
}