package com.car.manager.controller;

import com.car.manager.controller.request.InsertPersonalStatementRequest;
import com.car.manager.controller.request.SelectPersonalStatementRequest;
import com.car.manager.controller.request.UpdatePersonalStatementRequest;
import com.car.manager.core.domain.AjaxResult;
import com.car.manager.core.page.TableDataInfo;
import com.car.manager.service.PersonalStatementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    private String prefix = "order/personalBill";

    @GetMapping("/personalStatementList")
    public String car() {
        return prefix + "/personalBill";
    }
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SelectPersonalStatementRequest request) {
        return personalStatementService.selectAllPersonalStatementPage(request);
    }
    /**
     * 新增订单
     */
    @GetMapping("/toAddPersonalStatement")
    public String toAdd(Model model) {
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

}