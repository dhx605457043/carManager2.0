package com.car.manager.controller;

import com.car.manager.controller.request.*;
import com.car.manager.controller.response.SelectAccountingEntryResponse;
import com.car.manager.controller.response.SelectPersonalStatementResponse;
import com.car.manager.entity.AccountingEntry;
import com.car.manager.entity.PersonalStatement;
import com.car.manager.service.AccountingEntryService;
import com.car.manager.service.DriverListService;
import com.car.manager.util.BeanCopyUtils;
import com.car.manager.util.core.domain.AjaxResult;
import com.car.manager.util.core.page.TableDataInfo;
import com.car.manager.util.poi.ExcelUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AccountingEntry)表控制层
 *
 * @author Tom_wang
 * @since 2020-07-22 15:31:07
 */
@Controller
@RequestMapping("/accountingEntryManager")
public class AccountingEntryController extends BaseController{
    /**
     * 服务对象
     */
    @Resource
    private AccountingEntryService accountingEntryService;
    @Resource
    private DriverListService driverListService;

    private String prefix = "order/accountingEntry";

    @GetMapping("/accountingEntryList")
    public String car() {
        return prefix + "/accountingEntryList";
    }
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SelectAccountingEntryRequest request) {
        startPage();
        return getDataTable(accountingEntryService.selectAllAccountingEntry(request));
    }

    /**
     * 新增订单
     */
    @GetMapping("/toAddAccountingEntry")
    public String toAdd(Model model) {
        SelectDriverRequest request = new SelectDriverRequest();
        request.setRole("1");
        model.addAttribute("users",driverListService.selectAllDriver(request));
        return prefix + "/accountingEntryAdd";
    }

    /**
     * 新增保存订单
     */
    @PostMapping("/addAccountingEntry")
    @ResponseBody
    public AjaxResult addSave(InsertAccountingEntryRequest request) {
        return toAjax(accountingEntryService.insertAccountingEntry(request));
    }

    /**
     * 修改订单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        SelectAccountingEntryRequest request = new SelectAccountingEntryRequest();
        request.setId(id);
        model.addAttribute("accountingEntryResponse",accountingEntryService.selectOne(request));
        SelectDriverRequest requestDriver = new SelectDriverRequest();
        requestDriver.setRole("1");
        model.addAttribute("users",driverListService.selectAllDriver(requestDriver));
        return prefix + "/accountingEntryEdit";
    }

    /**
     * 修改保存订单
     */
    @PostMapping("/updateAccountingEntry")
    @ResponseBody
    public AjaxResult editSave(UpdateAccountingEntryRequest request) {
        return toAjax(accountingEntryService.updateAccountingEntry(request));
    }

    /**
     * 删除订单
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(int ids) {
        return toAjax(accountingEntryService.deleteAccountingEntryById(ids));
    }
    /**
     * 导出
     */
//    @PostMapping("/export")
//    @ResponseBody
//    public AjaxResult export() {
//        List<AccountingEntry> list = accountingEntryService.selectAllAccountingEntry(new SelectAccountingEntryRequest());
//        List<SelectPersonalStatementResponse> response = (List<SelectPersonalStatementResponse>) BeanCopyUtils.copyBeanList(list,SelectPersonalStatementResponse.class);
//        ExcelUtil<SelectPersonalStatementResponse> util = new ExcelUtil<SelectPersonalStatementResponse>(SelectPersonalStatementResponse.class);
//        return util.exportExcel(response, "个人对账单");
//    }

}
