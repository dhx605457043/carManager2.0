package com.car.manager.service.impl;

import com.car.manager.controller.request.*;
import com.car.manager.controller.response.SelectCarResponse;
import com.car.manager.core.page.PageDomain;
import com.car.manager.core.page.TableDataInfo;
import com.car.manager.core.page.TableSupport;
import com.car.manager.dao.CarListMapper;
import com.car.manager.entity.CarList;
import com.car.manager.entity.Ex.CarListEx;
import com.car.manager.service.CarListService;
import com.car.manager.util.BeanCopyUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * (CarList)表服务实现类
 *
 * @author makejava
 * @since 2020-05-14 17:58:00
 */
@Service
public class CarListServiceImpl implements CarListService {

    @Resource
    private CarListMapper carListMapper;

    @Override
    public TableDataInfo selectAllCarPage(SelectCarRequest request) {
        CarListEx requestModel = BeanCopyUtils.copyBean(request,new CarListEx());
        List<CarListEx> cars = carListMapper.selectAllCar(requestModel);
        TableDataInfo rspData = new TableDataInfo();
        List<CarListEx> userList = new ArrayList<CarListEx>(Arrays.asList(new CarListEx[cars.size()]));
        Collections.copy(userList, cars);
        PageDomain pageDomain = TableSupport.buildPageRequest();
        if (null == pageDomain.getPageNum() || null == pageDomain.getPageSize()) {
            rspData.setRows(userList);
            rspData.setTotal(userList.size());
            return rspData;
        }
        Integer pageNum = (pageDomain.getPageNum() - 1) * pageDomain.getPageSize();
        Integer pageSize = pageDomain.getPageNum() * pageDomain.getPageSize();
        if (pageSize > userList.size()) {
            pageSize = userList.size();
        }
        rspData.setRows(userList.subList(pageNum, pageSize));
        rspData.setTotal(userList.size());
        return rspData;
    }

    @Override
    public List<SelectCarResponse> selectAllCar(SelectCarRequest request) {
        CarListEx requestModel = BeanCopyUtils.copyBean(request,new CarListEx());
        List<CarListEx> cars = carListMapper.selectAllCar(requestModel);
        return (List<SelectCarResponse>) BeanCopyUtils.copyBeanList(cars, SelectCarResponse.class);
    }

    @Override
    public int insertCar(InsertCarRequest request) {
        CarList requestModel = BeanCopyUtils.copyBean(request,new CarList());
        requestModel.setCarNumber(requestModel.getCarNumber().toUpperCase());
        return carListMapper.carAdd(requestModel);
    }

    @Override
    public boolean selectCarByCarNumber(SelectCarRequest request) {
        CarList requestModel = BeanCopyUtils.copyBean(request,new CarList());
        CarList code = carListMapper.selectCarByCarNumber(requestModel);
        return code == null ? true: false;
    }


    @Override
    public SelectCarResponse selectCarById(SelectCarRequest request) {
        CarList requestModel = BeanCopyUtils.copyBean(request, new CarList());
        CarList responseModel = carListMapper.selectCarById(requestModel);
        SelectCarResponse response = BeanCopyUtils.copyBean(responseModel,new SelectCarResponse());
        return response;
    }

    @Override
    public int updateCar(UpdateCarRequest request) {
        CarList requestModel = BeanCopyUtils.copyBean(request,new CarList());
        requestModel.setCarNumber(requestModel.getCarNumber().toUpperCase());
        return carListMapper.updateByPrimaryKey(requestModel);
    }

    @Override
    public int deleteCarById(int id) {
        CarList requestModel = new CarList();
        requestModel.setId(id);
        return carListMapper.deleteByPrimaryKey(requestModel);
    }
}