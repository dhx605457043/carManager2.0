package com.car.manager.service.impl;

import com.car.manager.controller.response.SelectAllCargoResponse;
import com.car.manager.dao.CargoListMapper;
import com.car.manager.entity.CargoList;
import com.car.manager.service.CargoListService;
import com.car.manager.util.BeanCopyUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CargoList)表服务实现类
 *
 * @author makejava
 * @since 2020-05-15 15:22:19
 */
@Service
public class CargoListServiceImpl implements CargoListService {
    @Resource
    private CargoListMapper cargoListMapper;

    @Override
    public List<SelectAllCargoResponse> selectAllCargo() {
        List<CargoList> responseModel = cargoListMapper.selectAllCargo();
        return (List<SelectAllCargoResponse>) BeanCopyUtils.copyBeanList(responseModel,SelectAllCargoResponse.class);
    }
}