package com.car.manager.controller;


import com.car.manager.controller.request.*;
import com.car.manager.controller.response.SelectCarResponse;
import com.car.manager.core.domain.AjaxResult;
import com.car.manager.core.page.TableDataInfo;
import com.car.manager.service.CarListService;
import com.car.manager.service.CargoListService;
import com.car.manager.service.DriverListService;
import com.car.manager.service.LicensePlateAreaListService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * (CarList)表控制层
 *
 * @author makejava
 * @since 2020-05-14 17:58:01
 */
@Controller
@RequestMapping("/carManager")
public class CarListController extends BaseController{

    @Resource
    private CarListService carlistService;
    @Resource
    private DriverListService driverListService;
    @Resource
    private CargoListService cargoListService;

    @Resource
    private LicensePlateAreaListService licensePlateAreaListService;

    private String prefix = "car";

    @GetMapping("/carList")
    public String car() {
        return prefix + "/carList";
    }

    /**
     * 查询车辆列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SelectAllCarRequest request) {
        return carlistService.selectAllCarPage(request);
    }

    /**
     * 新增车辆
     */
    @GetMapping("/toAddCar")
    public String toAdd(Model model) {
        model.addAttribute("licenseResponses",licensePlateAreaListService.selectAllCarLicense());
        return prefix + "/carAdd";
    }

    /**
     * 新增保存车辆
     */
    @PostMapping("/addCar")
    @ResponseBody
    public AjaxResult addSave(InsertCarRequest request) {
        return toAjax(carlistService.insertCar(request));
    }

    @PostMapping("/checkCarNumber")
    @ResponseBody
    public boolean checkCarNumber (SelectCarRequest request) {
        return carlistService.selectCarByCarNumber(request);
    }

    /**
     * 修改车辆
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        SelectCarRequest request = new SelectCarRequest();
        request.setId(id);
        model.addAttribute("driverResponses",driverListService.selectAllDriver(new SelectAllDriverRequest()));
        model.addAttribute("cargoResponses",cargoListService.selectAllCargo());
        model.addAttribute("carResponse",carlistService.selectCarById(request));
        model.addAttribute("licenseResponses",licensePlateAreaListService.selectAllCarLicense());

        return prefix + "/carEdit";
    }

    /**
     * 修改保存车辆
     */
//    @Log(title = "import", businessType = BusinessType.UPDATE)
    @PostMapping("/updateCar")
    @ResponseBody
    public AjaxResult editSave(UpdateCarRequest request) {
        return toAjax(carlistService.updateCar(request));
    }

    /**
     * 删除车辆
     */
//    @Log(title = "车辆", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    public AjaxResult remove(String ids) {
//        return toAjax(carService.deleteCarByIds(ids));
//    }



}