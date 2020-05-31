package com.car.manager.dao;

import com.car.manager.entity.DriverList;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * (DriverList)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-15 14:21:56
 */
public interface DriverListMapper extends Mapper<DriverList>, BaseMapper<DriverList> {
    List<DriverList> selectAllDriver (DriverList driverList);
    DriverList  selectDriverByIDCard (DriverList driverList);
}