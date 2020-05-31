package com.car.manager.service.impl;


import com.car.manager.controller.request.InsertOrderRequest;
import com.car.manager.controller.request.SelectAllOrderRequest;
import com.car.manager.controller.request.SelectOrderRequest;
import com.car.manager.controller.request.UpdateOrderRequest;
import com.car.manager.controller.response.SelectOrderResponse;
import com.car.manager.core.page.PageDomain;
import com.car.manager.core.page.TableDataInfo;
import com.car.manager.core.page.TableSupport;
import com.car.manager.dao.OrderListMapper;
import com.car.manager.entity.DriverList;
import com.car.manager.entity.Ex.OrderListEx;
import com.car.manager.entity.OrderList;
import com.car.manager.service.OrderListService;
import com.car.manager.util.BeanCopyUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    public TableDataInfo selectAllOrderPage(SelectAllOrderRequest request) {

        OrderList requestModel = BeanCopyUtils.copyBean(request,new OrderList());
        List<OrderListEx> orders = orderListMapper.selectAllOrder(requestModel);
        TableDataInfo rspData = new TableDataInfo();
        List<OrderListEx> orderLists = new ArrayList<OrderListEx>(Arrays.asList(new OrderListEx[orders.size()]));
        Collections.copy(orderLists, orders);
        PageDomain pageDomain = TableSupport.buildPageRequest();
        if (null == pageDomain.getPageNum() || null == pageDomain.getPageSize()) {
            rspData.setRows(orderLists);
            rspData.setTotal(orderLists.size());
            return rspData;
        }
        Integer pageNum = (pageDomain.getPageNum() - 1) * pageDomain.getPageSize();
        Integer pageSize = pageDomain.getPageNum() * pageDomain.getPageSize();
        if (pageSize > orderLists.size()) {
            pageSize = orderLists.size();
        }
        rspData.setRows(orderLists.subList(pageNum, pageSize));
        rspData.setTotal(orderLists.size());
        return rspData;
    }

//    @Override
//    public List<SelectOrderResponse> selectAllOrder() {
//        return null;
//    }

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