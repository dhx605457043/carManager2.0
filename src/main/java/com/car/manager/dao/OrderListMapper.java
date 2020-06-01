package com.car.manager.dao;

import com.car.manager.entity.Ex.OrderListEx;
import com.car.manager.entity.OrderList;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * (OrderList)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-15 15:21:43
 */
public interface OrderListMapper extends Mapper<OrderList>, BaseMapper<OrderList> {
    List<OrderListEx>selectAllOrder(OrderList orderList);
//    OrderList selectOrderById (OrderList driverList);
}