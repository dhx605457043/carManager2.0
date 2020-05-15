package com.car.manager.controller;

import com.car.manager.entity.LicensePlateAreaList;
import com.car.manager.service.LicensePlateAreaListService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Licenseplatearealist)表控制层
 *
 * @author makejava
 * @since 2020-05-15 15:22:19
 */
@RestController
@RequestMapping("licensePlateAreaManager")
public class LicensePlateAreaListController {
    /**
     * 服务对象
     */
    @Resource
    private LicensePlateAreaListService licenseplatearealistService;

}