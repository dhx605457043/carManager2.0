package com.car.manager.controller;


import com.car.manager.controller.request.SelectAllCarRequest;
import com.car.manager.controller.response.SelectAllCarResponse;
import com.car.manager.core.page.TableDataInfo;
import com.car.manager.service.CarListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * (Carlist)表控制层
 *
 * @author makejava
 * @since 2020-05-14 17:58:01
 */
@Controller
@RequestMapping("/carManager")
public class CarListController extends BaseController{

    @Resource
    private CarListService carlistService;

    private String prefix = "car";

    @GetMapping()
    public String car() {
        return prefix + "/carList";
    }

    /**
     * 查询车辆列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SelectAllCarRequest request) {
//        startPage();
        List<SelectAllCarResponse> list = carlistService.selectAllCars(request);
        return getDataTable(list);
    }

    /**
     * 导出车辆列表
     */
//    @Log(title = "车辆", businessType = BusinessType.EXPORT)
//    @PostMapping("/export")
//    @ResponseBody
//    public AjaxResult export(Car car) {
//        List<Car> list = carService.selectCarList(car);
//        ExcelUtil<Car> util = new ExcelUtil<Car>(Car.class);
//        return util.exportExcel(list, "car");
//    }

    /**
     * 新增车辆
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存车辆
     */
//    @Log(title = "车辆", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    public AjaxResult addSave(Car car) {
//        return toAjax(carService.insertCar(car));
//    }

    /**
     * 修改车辆
     */
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") int id, ModelMap mmap) {
//        Car car = carService.selectCarById(id);
//        mmap.put("car", car);
//        return prefix + "/edit";
//    }

    /**
     * 修改保存车辆
     */
//    @Log(title = "import", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    public AjaxResult editSave(Car car) {
//        return toAjax(carService.updateCar(car));
//    }

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