package com.car.manager.service;

import com.car.manager.controller.response.selectManagerSystemMenuResponse;

import java.util.List;

/**
 * (ManagerSystemMenu)表服务接口
 *
 * @author makejava
 * @since 2020-06-03 17:14:19
 */
public interface ManagerSystemMenuService {
    List<selectManagerSystemMenuResponse> selectAllManagerSystemMenu ();
}