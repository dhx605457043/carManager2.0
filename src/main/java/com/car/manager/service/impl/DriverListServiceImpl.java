package com.car.manager.service.impl;

import com.car.manager.controller.request.InsertDriverRequest;
import com.car.manager.controller.request.SelectDriverRequest;
import com.car.manager.controller.request.UpdateDriverRequest;
import com.car.manager.controller.response.SelectDriverResponse;
import com.car.manager.core.page.PageDomain;
import com.car.manager.core.page.TableDataInfo;
import com.car.manager.core.page.TableSupport;
import com.car.manager.dao.DriverListMapper;

import com.car.manager.entity.DriverList;
import com.car.manager.service.DriverListService;
import com.car.manager.util.BeanCopyUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * (DriverList)表服务实现类
 *
 * @author makejava
 * @since 2020-05-15 14:21:56
 */
@Service
public class DriverListServiceImpl implements DriverListService {
    @Resource
    private DriverListMapper driverlistMapper;

    @Override
    public TableDataInfo selectAllDriverPage(SelectDriverRequest request) {

        DriverList requestModel = BeanCopyUtils.copyBean(request,new DriverList());
        List<DriverList> drivers = driverlistMapper.selectAllDriver(requestModel);
        TableDataInfo rspData = new TableDataInfo();
        List<DriverList> driverList = new ArrayList<DriverList>(Arrays.asList(new DriverList[drivers.size()]));
        Collections.copy(driverList, drivers);
        PageDomain pageDomain = TableSupport.buildPageRequest();
        if (null == pageDomain.getPageNum() || null == pageDomain.getPageSize()) {
            rspData.setRows(driverList);
            rspData.setTotal(driverList.size());
            return rspData;
        }
        Integer pageNum = (pageDomain.getPageNum() - 1) * pageDomain.getPageSize();
        Integer pageSize = pageDomain.getPageNum() * pageDomain.getPageSize();
        if (pageSize > driverList.size()) {
            pageSize = driverList.size();
        }
        rspData.setRows(driverList.subList(pageNum, pageSize));
        rspData.setTotal(driverList.size());
        return rspData;
    }

    @Override
    public List<SelectDriverResponse> selectAllDriver() {
        List<DriverList> drivers = driverlistMapper.selectAll();
        return (List<SelectDriverResponse>) BeanCopyUtils.copyBeanList(drivers, SelectDriverResponse.class);
    }

    @Override
    public int insertDriver(InsertDriverRequest request) {
        DriverList requestModel = BeanCopyUtils.copyBean(request,new DriverList());
        return driverlistMapper.insert(requestModel);
    }

    @Override
    public boolean selectDriverByIDCard(SelectDriverRequest request) {
        DriverList requestModel = BeanCopyUtils.copyBean(request,new DriverList());
        DriverList code = driverlistMapper.selectDriverByIDCard(requestModel);
        return code == null ? true: false;
    }

    @Override
    public SelectDriverResponse selectDriverById(SelectDriverRequest request) {
        DriverList requestModel = BeanCopyUtils.copyBean(request,new DriverList());
        DriverList responseModel = driverlistMapper.selectByPrimaryKey(requestModel);
        SelectDriverResponse response = BeanCopyUtils.copyBean(responseModel,new SelectDriverResponse());
        return response;
    }

    @Override
    public int updateDriver(UpdateDriverRequest request) {
        DriverList requestModel = BeanCopyUtils.copyBean(request,new DriverList());
        return driverlistMapper.updateByPrimaryKey(requestModel);
    }

    @Override
    public int deleteDriverById(int id) {
        DriverList requestModel = new DriverList();
        requestModel.setId(id);

        return driverlistMapper.deleteByPrimaryKey(requestModel);
    }
}