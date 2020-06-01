package com.car.manager.dao;

import com.car.manager.entity.Ex.OrderCarInformationEx;
import com.car.manager.entity.OrderCarInformation;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * (OrderCarInformation)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-25 22:24:55
 */
public interface OrderCarInformationMapper extends Mapper<OrderCarInformation>, BaseMapper<OrderCarInformation> {
    List<OrderCarInformationEx> selectAllOrderCarInformation (OrderCarInformationEx orderCarInformationEx);
    OrderCarInformation selectOrderCarInformationById (OrderCarInformation orderCarInformation);
}