package com.car.manager.service;

import com.car.manager.controller.request.InsertCarRequest;
import com.car.manager.controller.request.SelectAllCarRequest;
import com.car.manager.controller.request.SelectCarRequest;
import com.car.manager.controller.response.SelectAllCarResponse;

import java.util.List;

/**
 * (CarList)表服务接口
 *
 * @author makejava
 * @since 2020-05-14 17:58:00
 */
public interface CarListService {
    List<SelectAllCarResponse> selectAllCars (SelectAllCarRequest request);
    int insertCar (InsertCarRequest request);
    boolean selectCarById (SelectCarRequest request);
}