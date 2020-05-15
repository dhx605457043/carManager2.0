package com.car.manager.service.impl;

import com.car.manager.controller.request.SelectAllDriverRequest;
import com.car.manager.controller.response.SelectAllDriversResponse;
import com.car.manager.dao.DriverListMapper;

import com.car.manager.entity.DriverList;
import com.car.manager.service.DriverListService;
import com.car.manager.util.BeanCopyUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Driverlist)表服务实现类
 *
 * @author makejava
 * @since 2020-05-15 14:21:56
 */
@Service("driverlistService")
public class DriverListServiceImpl implements DriverListService {
    @Resource
    private DriverListMapper driverlistMapper;

    @Override
    public List<SelectAllDriversResponse> selectAllDrivers(SelectAllDriverRequest request) {
        DriverList requestModel = BeanCopyUtils.copyBean(request,new DriverList());
        List<DriverList> driverLists = driverlistMapper.selectAllDriver(requestModel);
        List<SelectAllDriversResponse> responseModel = (List<SelectAllDriversResponse>) BeanCopyUtils.copyBeanList(driverLists, SelectAllDriversResponse.class);
        return responseModel;
    }
}