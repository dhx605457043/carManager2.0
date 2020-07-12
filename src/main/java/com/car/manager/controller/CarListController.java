package com.car.manager.controller;


import com.car.manager.controller.request.*;
import com.car.manager.controller.response.SelectCarResponse;
import com.car.manager.util.core.domain.AjaxResult;
import com.car.manager.util.core.page.TableDataInfo;
import com.car.manager.entity.Ex.CarListEx;
import com.car.manager.service.CarListService;
import com.car.manager.service.CargoListService;
import com.car.manager.service.DriverListService;
import com.car.manager.service.LicensePlateAreaListService;
import com.car.manager.util.BeanCopyUtils;
import com.car.manager.util.QiNiuCloudUtil;
import com.car.manager.util.poi.ExcelUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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
    private CarListService carListService;
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
    public TableDataInfo list(SelectCarRequest request) {
        startPage();
        return getDataTable(carListService.selectAllCar(request));
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
        return toAjax(carListService.insertCar(request));
    }

    @PostMapping("/checkCarNumber")
    @ResponseBody
    public boolean checkCarNumber (SelectCarRequest request) {
        return carListService.selectCarByCarNumber(request);
    }

    /**
     * 修改车辆
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        SelectCarRequest request = new SelectCarRequest();
        request.setId(id);
        model.addAttribute("driverResponses",driverListService.selectAllDriver(new SelectDriverRequest()));
        model.addAttribute("cargoResponses",cargoListService.selectAllCargo());
        model.addAttribute("carResponse",carListService.selectCarById(request));
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
        return toAjax(carListService.updateCar(request));
    }

    /**
     * 删除车辆
     */
//    @Log(title = "车辆", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(int ids) {
        return toAjax(carListService.deleteCarById(ids));
    }
    /**
     * 导出
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SelectCarRequest request) {
        List<CarListEx> list = carListService.selectAllCar(request);
        List<SelectCarResponse> response = (List<SelectCarResponse>) BeanCopyUtils.copyBeanList(list,SelectCarResponse.class);
        ExcelUtil<SelectCarResponse> util = new ExcelUtil<SelectCarResponse>(SelectCarResponse.class);
        return util.exportExcel(response, "车辆列表");
    }

    @PostMapping("/updatePhoto")
    @ResponseBody
    public AjaxResult uploadImg(@RequestParam String file, Model model) throws IOException {

        JSONObject jsonObject = JSONObject.fromObject(file);
        MultipartFile fileModel = (MultipartFile) JSONObject.toBean(jsonObject, MultipartFile.class);
        byte[] bytes = fileModel.getBytes();

        String imageName = fileModel.getOriginalFilename();

        QiNiuCloudUtil qinNiuUtil = new QiNiuCloudUtil();
        try {
            //使用base64方式上传到七牛云

            String url = qinNiuUtil.put64image(bytes, imageName);
            model.addAttribute("imageName",url);
            System.out.println(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.success();
    }
}