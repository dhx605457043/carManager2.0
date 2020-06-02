package com.car.manager.service.impl;

import com.car.manager.controller.response.SelectConsignorResponse;
import com.car.manager.dao.ConsignorListMapper;
import com.car.manager.entity.ConsignorList;
import com.car.manager.service.ConsignorListService;
import com.car.manager.util.BeanCopyUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ConsignorList)表服务实现类
 *
 * @author makejava
 * @since 2020-05-15 15:22:19
 */
@Service
public class ConsignorListServiceImpl implements ConsignorListService {
    @Resource
    private ConsignorListMapper consignorListMapper;

    @Override
    public List<SelectConsignorResponse> selectAllConsignor() {
        List<ConsignorList> responseModel = consignorListMapper.selectAll();
        List<SelectConsignorResponse> response = (List<SelectConsignorResponse>) BeanCopyUtils.copyBeanList(responseModel, SelectConsignorResponse.class);
        return response;
    }
}