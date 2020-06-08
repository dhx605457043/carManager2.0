package com.car.manager.controller;

import com.car.manager.controller.request.InsertPersonalStatementRequest;
import com.car.manager.controller.request.SelectCarRequest;
import com.car.manager.controller.request.SelectPersonalStatementRequest;
import com.car.manager.controller.request.UpdatePersonalStatementRequest;
import com.car.manager.controller.response.SelectDriverResponse;
import com.car.manager.controller.response.SelectOrderResponse;
import com.car.manager.controller.response.SelectPersonalStatementResponse;
import com.car.manager.core.domain.AjaxResult;
import com.car.manager.core.page.TableDataInfo;
import com.car.manager.entity.CarList;
import com.car.manager.entity.PersonalStatement;
import com.car.manager.service.CarListService;
import com.car.manager.service.CargoListService;
import com.car.manager.service.PersonalStatementService;
import com.car.manager.util.BeanCopyUtils;
import com.car.manager.util.poi.ExcelUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PersonalStatement)表控制层
 *
 * @author makejava
 * @since 2020-06-02 12:38:12
 */
@Controller
@RequestMapping("/personalStatementManager")
public class PersonalStatementController extends BaseController{
    /**
     * 服务对象
     */
    @Resource
    private PersonalStatementService personalStatementService;
    @Resource
    private CarListService carListService;
    private String prefix = "order/personalBill";

    @GetMapping("/personalStatementList")
    public String car(Model model) {
        model.addAttribute("personalStatementCars",personalStatementService.selectAllPersonalStatementCar());
        return prefix + "/personalBill";
    }
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SelectPersonalStatementRequest request) {
        startPage();
        return getDataTable(personalStatementService.selectAllPersonalStatement(request));
    }

    /**
     * 新增订单
     */
    @GetMapping("/toAddPersonalStatement")
    public String toAdd(Model model) {
        model.addAttribute("carResponses",carListService.selectAllCar(new SelectCarRequest()));

        return prefix + "/personalBillAdd";
    }

    /**
     * 新增保存订单
     */
    @PostMapping("/addPersonalStatement")
    @ResponseBody
    public AjaxResult addSave(InsertPersonalStatementRequest request) {
        return toAjax(personalStatementService.insertPersonalStatement(request));
    }

    /**
     * 修改订单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        SelectPersonalStatementRequest request = new SelectPersonalStatementRequest();
        request.setId(id);
        model.addAttribute("personalStatementResponse",personalStatementService.selectPersonalStatementById(request));
        model.addAttribute("carResponses",carListService.selectAllCar(new SelectCarRequest()));
        return prefix + "/personalBillEdit";
    }

    /**
     * 修改保存订单
     */
    @PostMapping("/updatePersonalStatement")
    @ResponseBody
    public AjaxResult editSave(UpdatePersonalStatementRequest request) {
        return toAjax(personalStatementService.updatePersonalStatement(request));
    }

    /**
     * 删除订单
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(int ids) {
        return toAjax(personalStatementService.deletePersonalStatementById(ids));
    }
    /**
     * 导出
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export() {
        List<PersonalStatement> list = personalStatementService.selectAllPersonalStatement(new SelectPersonalStatementRequest());
        List<SelectPersonalStatementResponse> response = (List<SelectPersonalStatementResponse>) BeanCopyUtils.copyBeanList(list,SelectPersonalStatementResponse.class);
        ExcelUtil<SelectPersonalStatementResponse> util = new ExcelUtil<SelectPersonalStatementResponse>(SelectPersonalStatementResponse.class);
        return util.exportExcel(response, "个人对账单");
    }
}