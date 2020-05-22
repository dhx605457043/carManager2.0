package com.car.manager.controller;


import com.car.manager.controller.request.InsertCarRequest;
import com.car.manager.controller.request.SelectAllCarRequest;
import com.car.manager.core.domain.AjaxResult;
import com.car.manager.core.page.TableDataInfo;
import com.car.manager.entity.CarList;
import com.car.manager.entity.Ex.CarListEx;
import com.car.manager.service.CarListService;
import com.car.manager.service.LicensePlateAreaListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.regex.Pattern;

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
    public TableDataInfo list(SelectAllCarRequest request, Model model) {
        return getDataTable(carlistService.selectAllCars(request));
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
    public boolean checkCarNumber (String carNumber) {
        System.out.println("验证表单carNumber");
        String pattern = "([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼]{1}(([A-HJ-Z]{1}[A-HJ-NP-Z0-9]{5})|([A-HJ-Z]{1}(([DF]{1}[A-HJ-NP-Z0-9]{1}[0-9]{4})|([0-9]{5}[DF]{1})))|([A-HJ-Z]{1}[A-D0-9]{1}[0-9]{3}警)))|([0-9]{6}使)|((([沪粤川云桂鄂陕蒙藏黑辽渝]{1}A)|鲁B|闽D|蒙E|蒙H)[0-9]{4}领)|(WJ[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼·•]{1}[0-9]{4}[TDSHBXJ0-9]{1})|([VKHBSLJNGCE]{1}[A-DJ-PR-TVY]{1}[0-9]{5})";
        boolean isMatch = Pattern.matches(pattern, carNumber);
//        if (isMatch) {
//            boolean code = carListService.selectCarByNumber(carListEntity.getCarNumber());
//            if (code) {
//                carListService.carAdd(carListEntity.getCarNumber(),carListEntity.getCarLicensePlateAreaCode());
//                return "添加成功";
//            } else  {
//                return "车辆存在，请勿重复添加";
//            }
//        } else  {
//            return "请输入正确的车牌号";
//        }
        return true;
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