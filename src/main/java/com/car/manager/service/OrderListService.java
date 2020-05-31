package com.car.manager.service;

import com.car.manager.controller.request.*;
import com.car.manager.controller.response.SelectOrderResponse;
import com.car.manager.core.page.TableDataInfo;

import java.util.List;

/**
 * (OrderList)表服务接口
 *
 * @author makejava
 * @since 2020-05-15 15:21:43
 */
public interface OrderListService {
    TableDataInfo selectAllOrderPage(SelectOrderRequest request);
    int insertOrder (InsertOrderRequest request);
    SelectOrderResponse selectOrderById (SelectOrderRequest request);
    int updateOrder (UpdateOrderRequest request);
    int deleteOrderById (int id);
}