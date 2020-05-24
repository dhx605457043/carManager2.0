package com.car.manager.controller;


import com.car.manager.controller.request.InsertCarRequest;
import com.car.manager.controller.request.SelectCarRequest;
import com.car.manager.core.domain.AjaxResult;
import com.car.manager.core.page.PageDomain;
import com.car.manager.core.page.TableDataInfo;
import com.car.manager.core.page.TableSupport;
import com.car.manager.dao.CarListMapper;
import com.car.manager.entity.Ex.CarListEx;
import com.car.manager.service.CarListService;
import com.car.manager.service.LicensePlateAreaListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    private CarListMapper carListMapper;

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
//    @ResponseBody
//    public TableDataInfo list(SelectAllCarRequest request, Model model) {
//        startPage();
//        return getDataTable(carlistService.selectAllCars(request));
//    }

    @ResponseBody
    public TableDataInfo list(CarListEx carListEx) {
        List<CarListEx> cars = carListMapper.selectAllCar(carListEx);
        TableDataInfo rspData = new TableDataInfo();
        List<CarListEx> userList = new ArrayList<CarListEx>(Arrays.asList(new CarListEx[cars.size()]));
        Collections.copy(userList, cars);
        PageDomain pageDomain = TableSupport.buildPageRequest();
        if (null == pageDomain.getPageNum() || null == pageDomain.getPageSize())
        {
            rspData.setRows(userList);
            rspData.setTotal(userList.size());
            return rspData;
        }
        Integer pageNum = (pageDomain.getPageNum() - 1) * 25;
        Integer pageSize = pageDomain.getPageNum() * 25;
        if (pageSize > userList.size())
        {
            pageSize = userList.size();
        }
        rspData.setRows(userList.subList(pageNum, pageSize));
        rspData.setTotal(userList.size());
        return rspData;
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
//    @Log(title = "车辆", businessType = BusinessType.INSERT)
    @PostMapping("/addCar")
    @ResponseBody
    public AjaxResult addSave(InsertCarRequest request) {
        return toAjax(carlistService.insertCar(request));
//        return null;
    }

    @PostMapping("/checkCarNumber")
    @ResponseBody
    public boolean checkCarNumber (SelectCarRequest request) {
        return carlistService.selectCarById(request);
    }

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