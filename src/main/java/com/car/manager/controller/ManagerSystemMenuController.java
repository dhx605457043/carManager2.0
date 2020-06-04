package com.car.manager.controller;

import com.car.manager.service.ManagerSystemMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ManagerSystemMenu)表控制层
 *
 * @author makejava
 * @since 2020-06-03 17:14:19
 */
@Controller
@RequestMapping("/managerSystemMenuManager")
public class ManagerSystemMenuController {
    private String prefix = "system";
    /**
     * 服务对象
     */
    @Resource
    private ManagerSystemMenuService managerSystemMenuService;

    @GetMapping("/menuList")
    public String menu () {

        return prefix + "/menu";
    }

}