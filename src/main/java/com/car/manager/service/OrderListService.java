package com.car.manager.service;

import com.car.manager.controller.request.SelectAllOrderRequest;
import com.car.manager.controller.response.SelectAllOrderResponse;

import java.util.List;

/**
 * (OrderList)表服务接口
 *
 * @author makejava
 * @since 2020-05-15 15:21:43
 */
public interface OrderListService {
    List<SelectAllOrderResponse>selectAllOrder(SelectAllOrderRequest request);
}