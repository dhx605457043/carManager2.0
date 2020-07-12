package com.car.manager.service.impl;


import com.car.manager.controller.request.InsertOrderRequest;
import com.car.manager.controller.request.SelectOrderRequest;
import com.car.manager.controller.request.UpdateOrderRequest;
import com.car.manager.controller.response.SelectOrderResponse;
import com.car.manager.dao.OrderListMapper;
import com.car.manager.entity.Ex.OrderListEx;
import com.car.manager.entity.OrderList;
import com.car.manager.service.OrderListService;
import com.car.manager.util.BeanCopyUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OrderList)表服务实现类
 *
 * @author makejava
 * @since 2020-05-15 15:21:43
 */
@Service
public class OrderListServiceImpl implements OrderListService {
    @Resource
    private OrderListMapper orderListMapper;

    @Override
    public List<OrderListEx> selectAllOrder(SelectOrderRequest request) {
        OrderList requestModel = BeanCopyUtils.copyBean(request,new OrderList());
        List<OrderListEx> orders = orderListMapper.selectAllOrder(requestModel);
        return orders;
    }

    @Override
    public int insertOrder(InsertOrderRequest request) {
        OrderList requestModel = BeanCopyUtils.copyBean(request,new OrderList());
        return orderListMapper.insert(requestModel);
    }

    @Override
    public SelectOrderResponse selectOrderById(SelectOrderRequest request) {
        OrderList requestModel = BeanCopyUtils.copyBean(request,new OrderList());
        OrderList responseModel = orderListMapper.selectByPrimaryKey(requestModel);
        SelectOrderResponse response = BeanCopyUtils.copyBean(responseModel,new SelectOrderResponse());
        return response;
    }

    @Override
    public int updateOrder(UpdateOrderRequest request) {
        OrderList requestModel = BeanCopyUtils.copyBean(request,new OrderList());
        return orderListMapper.updateByPrimaryKey(requestModel);
    }

    @Override
    public int deleteOrderById(int id) {
        OrderList requestModel = new OrderList();
        requestModel.setId(id);
        return orderListMapper.deleteByPrimaryKey(requestModel);
    }
}