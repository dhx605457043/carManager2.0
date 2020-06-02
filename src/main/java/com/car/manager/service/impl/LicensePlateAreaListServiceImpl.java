package com.car.manager.service.impl;

import com.car.manager.controller.response.SelectCarLicenseResponse;
import com.car.manager.dao.LicensePlateAreaListMapper;
import com.car.manager.entity.LicensePlateAreaList;
import com.car.manager.service.LicensePlateAreaListService;
import com.car.manager.util.BeanCopyUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (LicensePlateAreaListList)表服务实现类
 *
 * @author makejava
 * @since 2020-05-15 15:22:19
 */
@Service
public class LicensePlateAreaListServiceImpl implements LicensePlateAreaListService {
    @Resource
    private LicensePlateAreaListMapper licensePlateAreaListMapper;

    @Override
    public List<SelectCarLicenseResponse> selectAllCarLicense() {
        List<LicensePlateAreaList> licensePlateAreaLists = licensePlateAreaListMapper.selectAll();
        List<SelectCarLicenseResponse> responses = (List<SelectCarLicenseResponse>) BeanCopyUtils.copyBeanList(licensePlateAreaLists, SelectCarLicenseResponse.class);
        return responses;

    }
}