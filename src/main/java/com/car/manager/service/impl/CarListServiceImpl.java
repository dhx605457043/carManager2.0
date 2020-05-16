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
@Service("CarListService")
public class CarListServiceImpl implements CarListService {

    @Resource
    private CarListMapper carlistMapper;

    @Override
    public List<SelectAllCarResponse> selectAllCars(SelectAllCarRequest request) {
        CarListEx requestModel = BeanCopyUtils.copyBean(request,new CarListEx());
        PageHelper.startPage(requestModel.getPageNum(),requestModel.getPageSize());
        List<CarListEx> carListExes = carlistMapper.selectAllCar(requestModel);
        PageInfo<CarListEx> carListExPageInfo = new PageInfo<>(carListExes);
        List<SelectAllCarResponse> responseModel = (List<SelectAllCarResponse>) BeanCopyUtils.copyBeanList(carListExPageInfo.getList(),SelectAllCarResponse.class);
        return responseModel;
    }

    @Override
    public int insertCar(InsertCarRequest request) {
        CarList requestModel = BeanCopyUtils.copyBean(request,new CarList());
        return carlistMapper.carAdd(requestModel);
    }
}