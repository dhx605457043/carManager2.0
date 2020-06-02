package com.car.manager.controller;

import com.car.manager.controller.request.*;
import com.car.manager.core.domain.AjaxResult;
import com.car.manager.core.page.TableDataInfo;
import com.car.manager.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    @Resource
    private CargoListService cargoListService;
    @Resource
    private ConsignorListService consignorListService;
    @Resource
    private CarListService carListService;

    private String prefix = "order";

    @GetMapping("/orderList")
    public String car() {
        return prefix + "/orderList";
    }
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SelectOrderRequest request) {
        return orderListService.selectAllOrderPage(request);
    }
    /**
     * 新增订单
     */
    @GetMapping("/toAddOrder")
    public String toAdd(Model model) {
        model.addAttribute("cargoResponses",cargoListService.selectAllCargo());
        model.addAttribute("carResponses",carListService.selectAllCar(new SelectCarRequest()));
        model.addAttribute("consignorResponses",consignorListService.selectAllConsignor());
        return prefix + "/orderAdd";
    }

    /**
     * 新增保存订单
     */
    @PostMapping("/addOrder")
    @ResponseBody
    public AjaxResult addSave(InsertOrderRequest request) {

        return toAjax(orderListService.insertOrder(request));
    }

    /**
     * 修改订单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        SelectOrderRequest request = new SelectOrderRequest();
        request.setId(id);
        model.addAttribute("orderResponse",orderListService.selectOrderById(request));
        model.addAttribute("cargoResponses",cargoListService.selectAllCargo());
        model.addAttribute("carResponses",carListService.selectAllCar(new SelectCarRequest()));
        model.addAttribute("consignorResponses",consignorListService.selectAllConsignor());
        return prefix + "/orderEdit";
    }

    /**
     * 修改保存订单
     */
    @PostMapping("/updateOrder")
    @ResponseBody
    public AjaxResult editSave(UpdateOrderRequest request) {
        return toAjax(orderListService.updateOrder(request));
    }

    /**
     * 删除订单
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(int ids) {
        return toAjax(orderListService.deleteOrderById(ids));
    }
}