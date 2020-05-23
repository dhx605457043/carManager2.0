package com.car.manager.service.impl;

import com.car.manager.controller.request.SelectAllOrderRequest;
import com.car.manager.controller.response.SelectAllDriversResponse;
import com.car.manager.controller.response.SelectAllOrderResponse;
import com.car.manager.dao.OrderListMapper;
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
@Service()
public class OrderListServiceImpl implements OrderListService {
    @Resource
    private OrderListMapper orderListMapper;

    @Override
    public List<SelectAllOrderResponse> selectAllOrder(SelectAllOrderRequest request) {
        OrderList requestModel = BeanCopyUtils.copyBean(request,new OrderList());
        List<OrderList> orderLists = orderListMapper.selectAllOrder(requestModel);
        List<SelectAllOrderResponse> responses = (List<SelectAllOrderResponse>) BeanCopyUtils.copyBeanList(orderLists, SelectAllOrderResponse.class);
        return responses;
    }
}