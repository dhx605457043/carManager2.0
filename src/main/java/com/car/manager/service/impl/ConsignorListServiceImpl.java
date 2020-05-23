package com.car.manager.service.impl;

import com.car.manager.dao.ConsignorListMapper;
import com.car.manager.service.ConsignorListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (ConsignorList)表服务实现类
 *
 * @author makejava
 * @since 2020-05-15 15:22:19
 */
@Service()
public class ConsignorListServiceImpl implements ConsignorListService {
    @Resource
    private ConsignorListMapper consignorListMapper;
}