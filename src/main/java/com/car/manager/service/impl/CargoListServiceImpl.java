package com.car.manager.service.impl;

import com.car.manager.dao.CargoListMapper;
import com.car.manager.service.CargoListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (CargoList)表服务实现类
 *
 * @author makejava
 * @since 2020-05-15 15:22:19
 */
@Service("CargoListService")
public class CargoListServiceImpl implements CargoListService {
    @Resource
    private CargoListMapper cargoListMapper;
}