package com.car.manager.service.impl;

import com.car.manager.dao.LicensePlateAreaListMapper;
import com.car.manager.entity.LicensePlateAreaList;
import com.car.manager.service.LicensePlateAreaListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (LicensePlateAreaListList)表服务实现类
 *
 * @author makejava
 * @since 2020-05-15 15:22:19
 */
@Service("LicensePlateAreaListService")
public class LicensePlateAreaListServiceImpl implements LicensePlateAreaListService {
    @Resource
    private LicensePlateAreaListMapper licensePlateAreaListMapper;

}