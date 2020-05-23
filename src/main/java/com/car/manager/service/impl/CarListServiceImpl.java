package com.car.manager.service.impl;

import com.car.manager.controller.request.InsertCarRequest;
import com.car.manager.controller.request.SelectAllCarRequest;
import com.car.manager.controller.response.SelectAllCarResponse;
import com.car.manager.dao.CarListMapper;
import com.car.manager.entity.CarList;
import com.car.manager.entity.Ex.CarListEx;
import com.car.manager.service.CarListService;
import com.car.manager.util.BeanCopyUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CarList)表服务实现类
 *
 * @author makejava
 * @since 2020-05-14 17:58:00
 */
@Service()
public class CarListServiceImpl implements CarListService {

    @Resource
    private CarListMapper carlistMapper;

    @Override
    public List<SelectAllCarResponse> selectAllCars(SelectAllCarRequest request) {
        CarListEx requestModel = BeanCopyUtils.copyBean(request,new CarListEx());
        List<CarListEx> carListExes = carlistMapper.selectAllCar(requestModel);
        List<SelectAllCarResponse> response = (List<SelectAllCarResponse>) BeanCopyUtils.copyBeanList(carListExes,SelectAllCarResponse.class);
        return response;
    }



    @Override
    public int insertCar(InsertCarRequest request) {
        CarList requestModel = BeanCopyUtils.copyBean(request,new CarList());
        requestModel.setCarNumber(requestModel.getCarNumber().toUpperCase());
        return carlistMapper.carAdd(requestModel);
    }
}