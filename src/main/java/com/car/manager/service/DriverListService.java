package com.car.manager.service;

import com.car.manager.controller.request.SelectAllDriverRequest;
import com.car.manager.controller.response.SelectAllDriversResponse;

import java.util.List;

/**
 * (Driverlist)表服务接口
 *
 * @author makejava
 * @since 2020-05-15 14:21:56
 */
public interface DriverListService {
    List<SelectAllDriversResponse> selectAllDrivers (SelectAllDriverRequest request);
}