package com.car.manager.controller;

import com.car.manager.controller.request.SelectAllDriverRequest;
import com.car.manager.controller.response.SelectAllDriversResponse;
import com.car.manager.core.page.TableDataInfo;
import com.car.manager.service.DriverListService;
import org.springframework.stereotype.Controller;
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

    @GetMapping()
    public String car() {
        return prefix + "/driverList";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SelectAllDriverRequest request) {
        startPage();
        List<SelectAllDriversResponse> list = driverListService.selectAllDrivers(request);
        return getDataTable(list);
    }

}