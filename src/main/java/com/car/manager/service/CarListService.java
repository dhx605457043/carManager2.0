package com.car.manager.service;

import com.car.manager.controller.request.SelectAllCarRequest;
import com.car.manager.controller.response.SelectAllCarResponse;

import java.util.List;

/**
 * (Carlist)表服务接口
 *
 * @author makejava
 * @since 2020-05-14 17:58:00
 */
public interface CarListService {
    List<SelectAllCarResponse> selectAllCars (SelectAllCarRequest request);
}