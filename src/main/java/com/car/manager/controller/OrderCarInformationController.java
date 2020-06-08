package com.car.manager.controller;

import com.car.manager.controller.request.*;
import com.car.manager.core.domain.AjaxResult;
import com.car.manager.core.page.TableDataInfo;
import com.car.manager.service.CarListService;
import com.car.manager.service.CargoListService;
import com.car.manager.service.DriverListService;
import com.car.manager.service.OrderCarInformationService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (OrderCarInformation)表控制层
 *
 * @author makejava
 * @since 2020-05-25 22:24:55
 */
@Controller
@RequestMapping("/orderCarInformationManager")
public class OrderCarInformationController extends BaseController{
    private String prefix = "order/orderCarInfromation";
    /**
     * 服务对象
     */
    @Resource
    private OrderCarInformationService orderCarInformationService;
    @Resource
    private CarListService carListService;
    @Resource
    private DriverListService driverListService;
    @Resource
    private CargoListService cargoListService;

    @GetMapping("/orderCarInformationList")
    public String carInformation() {
        return prefix + "/orderCarInformation";
    }

    @PostMapping("/orderCarInformationList")
    @ResponseBody
    public TableDataInfo orderCarInformationList (SelectOrderCarInformationRequest request) {
        startPage();
        return getDataTable(orderCarInformationService.selectAllOrderCarInformation(request));
    }

    /**
     * 新增订单车辆信息
     * @param model
     * @return
     */
    @GetMapping("/toAddOrderCarInformation")
    public String toAdd(Model model) {
        model.addAttribute("driverResponses",driverListService.selectAllDriver(new SelectDriverRequest()));
        model.addAttribute("carResponses",carListService.selectAllCar(new SelectCarRequest()));
        model.addAttribute("cargoResponses",cargoListService.selectAllCargo());

        return prefix + "/orderCarInformationAdd";
    }

    /**
     * 新增订单车辆保存
     * @param request
     * @return
     */
    @PostMapping("/addOrderCarInformation")
    @ResponseBody
    public AjaxResult addOrderCarInformation (InsertOrderCarInformationRequest request) {

        return toAjax(orderCarInformationService.insertOrderCarInformation(request));
    }
    /**
     * 修改订单车辆信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        SelectOrderCarInformationRequest request = new SelectOrderCarInformationRequest();
        request.setId(id);
        model.addAttribute("orderCarInformationResponse",orderCarInformationService.selectOrderCarInformationById(request));;
        model.addAttribute("driverResponses",driverListService.selectAllDriver(new SelectDriverRequest()));
        model.addAttribute("carResponses",carListService.selectAllCar(new SelectCarRequest()));
        model.addAttribute("cargoResponses",cargoListService.selectAllCargo());
        return prefix + "/OrderCarInformationEdit";
    }

    /**
     * 修改保存订单车辆信息
     */
    @PostMapping("/updateOrderCarInformation")
    @ResponseBody
    public AjaxResult editSave(UpdateOrderCarInformationRequest request) {
        return toAjax(orderCarInformationService.updateOrderCarInformation(request));
    }

    /**
     * 删除订单车辆信息
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(int ids) {
        return toAjax(orderCarInformationService.deleteOrderCarInformationById(ids));
    }
}