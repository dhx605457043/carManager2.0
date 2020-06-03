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
@RequestMapping("managerSystemMenu")
public class ManagerSystemMenuController {
    /**
     * 服务对象
     */
    @Resource
    private ManagerSystemMenuService managerSystemMenuService;

}