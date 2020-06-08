package com.car.manager.controller;

import com.car.manager.controller.request.*;
import com.car.manager.controller.response.SelectCarResponse;
import com.car.manager.controller.response.SelectDriverResponse;
import com.car.manager.core.domain.AjaxResult;
import com.car.manager.core.page.TableDataInfo;
import com.car.manager.entity.DriverList;
import com.car.manager.service.DriverListService;
import com.car.manager.util.BeanCopyUtils;
import com.car.manager.util.poi.ExcelUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DriverList)表控制层
 *
 * @author makejava
 * @since 2020-05-15 14:21:56
 */
@Controller
@RequestMapping("driverManager")
public class DriverListController extends BaseController{
    /**
     * 服务对象
     */
    @Resource
    private DriverListService driverListService;

    private String prefix = "driver";

    @GetMapping("/driverList")
    public String car() {
        return prefix + "/driverList";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SelectDriverRequest request) {
        startPage();
        return getDataTable(driverListService.selectAllDriver(request));
    }
    /**
     * 新增司机
     */
    @GetMapping("/toAddDriver")
    public String toAdd() {
        return prefix + "/driverAdd";
    }

    /**
     * 新增保存司机
     */
    @PostMapping("/addDriver")
    @ResponseBody
    public AjaxResult addSave(InsertDriverRequest request) {
        return toAjax(driverListService.insertDriver(request));
    }

    @PostMapping("/checkDriverIdCard")
    @ResponseBody
    public boolean checkCarNumber (SelectDriverRequest request) {
        return driverListService.selectDriverByIDCard(request);
    }

    /**
     * 修改司机
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id,Model model) {
        SelectDriverRequest request = new SelectDriverRequest();
        request.setId(id);
        model.addAttribute("driverResponse",driverListService.selectDriverById(request));
        return prefix + "/driverEdit";
    }

    /**
     * 修改保存司机
     */
//    @Log(title = "import", businessType = BusinessType.UPDATE)
    @PostMapping("/updateDriver")
    @ResponseBody
    public AjaxResult editSave(UpdateDriverRequest request) {
        return toAjax(driverListService.updateDriver(request));
    }

    /**
     * 删除司机
     */
//    @Log(title = "车辆", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(int ids) {
        return toAjax(driverListService.deleteDriverById(ids));
    }
    /**
     * 导出
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export() {
        List<DriverList> list = driverListService.selectAllDriver(new SelectDriverRequest());
        List<SelectDriverResponse> response = (List<SelectDriverResponse>) BeanCopyUtils.copyBeanList(list,SelectDriverResponse.class);
        ExcelUtil<SelectDriverResponse> util = new ExcelUtil<SelectDriverResponse>(SelectDriverResponse.class);
        return util.exportExcel(response, "司机列表");
    }
}