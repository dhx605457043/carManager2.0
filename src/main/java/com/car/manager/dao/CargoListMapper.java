package com.car.manager.dao;

import com.car.manager.entity.CargoList;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * (CargoList)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-15 15:22:19
 */
public interface CargoListMapper extends Mapper<CargoList>, BaseMapper<CargoList> {
    List<CargoList> selectAllCargo ();
}