package com.car.manager.service;

import com.car.manager.controller.response.SelectAllCargoResponse;
import com.car.manager.entity.CargoList;

import java.util.List;

/**
 * (Cargolist)表服务接口
 *
 * @author makejava
 * @since 2020-05-15 15:22:19
 */
public interface CargoListService {
    List<SelectAllCargoResponse> selectAllCargo ();
}