package com.car.manager.controller;

import com.car.manager.controller.request.SelectAllOrderRequest;
import com.car.manager.core.page.TableDataInfo;
import com.car.manager.service.OrderListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Orderlist)表控制层
 *
 * @author makejava
 * @since 2020-05-15 15:21:43
 */
@Controller
@RequestMapping("/orderManager")
public class OrderListController extends BaseController{
    /**
     * 服务对象
     */
    @Resource
    private OrderListService orderListService;

    private String prefix = "order";

    @GetMapping("/orderList")
    public String car() {
        return prefix + "/orderList";
    }
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SelectAllOrderRequest request) {
//        startPage();
        return getDataTable(orderListService.selectAllOrder(request));
    }

}