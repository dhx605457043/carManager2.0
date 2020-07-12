package com.car.manager.service.impl;

import com.car.manager.controller.request.InsertOrderCarInformationRequest;
import com.car.manager.controller.request.SelectOrderCarInformationRequest;
import com.car.manager.controller.request.UpdateOrderCarInformationRequest;
import com.car.manager.controller.response.SelectOrderCarInformationResponse;
import com.car.manager.entity.Ex.OrderCarInformationEx;
import com.car.manager.dao.OrderCarInformationMapper;
import com.car.manager.entity.OrderCarInformation;
import com.car.manager.service.OrderCarInformationService;
import com.car.manager.util.BeanCopyUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OrderCarInformation)表服务实现类
 *
 * @author makejava
 * @since 2020-05-25 22:24:55
 */
@Service
public class OrderCarInformationServiceImpl implements OrderCarInformationService {
    @Resource
    private OrderCarInformationMapper orderCarInformationMapper;

    @Override
    public List<OrderCarInformationEx> selectAllOrderCarInformation(SelectOrderCarInformationRequest request) {
        OrderCarInformationEx requestModel = BeanCopyUtils.copyBean(request,new OrderCarInformationEx());
        List<OrderCarInformationEx> responseModel = orderCarInformationMapper.selectAllOrderCarInformation(requestModel);
        return responseModel;
    }

    @Override
    public int insertOrderCarInformation(InsertOrderCarInformationRequest request) {
        OrderCarInformation requestModel = BeanCopyUtils.copyBean(request,new OrderCarInformation());
        return orderCarInformationMapper.insert(requestModel);
    }

    @Override
    public SelectOrderCarInformationResponse selectOrderCarInformationById(SelectOrderCarInformationRequest request) {
        OrderCarInformation requestModel = BeanCopyUtils.copyBean(request,new OrderCarInformation());
        OrderCarInformation responseModel = orderCarInformationMapper.selectByPrimaryKey(requestModel);
        SelectOrderCarInformationResponse response = BeanCopyUtils.copyBean(responseModel,new SelectOrderCarInformationResponse());
        return response;
    }

    @Override
    public int updateOrderCarInformation(UpdateOrderCarInformationRequest request) {
        OrderCarInformation requestModel = BeanCopyUtils.copyBean(request,new OrderCarInformation());
        return orderCarInformationMapper.updateByPrimaryKey(requestModel);
    }

    @Override
    public int deleteOrderCarInformationById(int id) {
        OrderCarInformation requestModel = new OrderCarInformation();
        requestModel.setId(id);
        return orderCarInformationMapper.deleteByPrimaryKey(requestModel);
    }
}