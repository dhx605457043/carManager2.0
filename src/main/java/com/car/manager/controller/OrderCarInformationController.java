package com.car.manager.controller;

import com.car.manager.controller.request.InsertOrderCarInformationRequest;
import com.car.manager.controller.request.SelectAllCarRequest;
import com.car.manager.controller.request.SelectAllDriverRequest;
import com.car.manager.controller.request.SelectAllOrderCarInformationRequest;
import com.car.manager.core.domain.AjaxResult;
import com.car.manager.core.page.TableDataInfo;
import com.car.manager.service.CarListService;
import com.car.manager.service.CargoListService;
import com.car.manager.service.DriverListService;
import com.car.manager.service.OrderCarInformationService;
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
    private String prefix = "order";
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
    public TableDataInfo orderCarInformationList (SelectAllOrderCarInformationRequest request) {
        return orderCarInformationService.selectAllOrderCarInformation(request);
    }

    @GetMapping("/toAddOrderCarInformation")
    public String toAdd(Model model) {
        model.addAttribute("driverResponses",driverListService.selectAllDriver(new SelectAllDriverRequest()));
        model.addAttribute("carResponses",carListService.selectAllCar(new SelectAllCarRequest()));
        model.addAttribute("cargoResponses",cargoListService.selectAllCargo());

        return prefix + "/orderCarInformationAdd";
    }
    @PostMapping("/addOrderCarInformation")
    @ResponseBody
    public AjaxResult addOrderCarInformation (InsertOrderCarInformationRequest request) {

        return toAjax(orderCarInformationService.insertOrderCarInformation(request));
    }
}