package com.car.manager.controller;

import com.car.manager.entity.ConsignorList;
import com.car.manager.service.ConsignorListService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Consignorlist)表控制层
 *
 * @author makejava
 * @since 2020-05-15 15:22:19
 */
@RestController
@RequestMapping("consignorManager")
public class ConsignorListController {
    /**
     * 服务对象
     */
    @Resource
    private ConsignorListService consignorlistService;
}