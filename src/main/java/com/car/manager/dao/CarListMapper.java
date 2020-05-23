package com.car.manager.dao;

import com.car.manager.entity.CarList;

import com.car.manager.entity.Ex.CarListEx;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * (CarList)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-14 17:57:59
 */
public interface CarListMapper extends Mapper<CarList>, BaseMapper<CarList> {
    List<CarListEx>selectAllCar(CarListEx carListEx);
    int carAdd (CarList carList);
    boolean selectCarById ();

}