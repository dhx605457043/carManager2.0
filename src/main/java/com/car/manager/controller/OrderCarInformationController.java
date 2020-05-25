package com.car.manager.controller;

import com.car.manager.core.page.TableDataInfo;
import com.car.manager.entity.OrderCarInformation;
import com.car.manager.service.OrderCarInformationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (OrderCarInformation)表控制层
 *
 * @author makejava
 * @since 2020-05-25 22:24:55
 */
@RestController
@RequestMapping("orderCarInformation")
public class OrderCarInformationController {
    /**
     * 服务对象
     */
    @Resource
    private OrderCarInformationService orderCarInformationService;


//    @PostMapping("/orderCarInformationList")
//    @ResponseBody
//    public TableDataInfo orderCarInformationList (SelectAllOrderCarInformationRequest request) {
//        return orderListService.selectAllOrderCarInformation(request);
//    }

}