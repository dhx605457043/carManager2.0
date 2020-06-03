package com.car.manager.controller;

import com.car.manager.service.ManagerSystemMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class MainController extends BaseController{
    @Resource
    ManagerSystemMenuService managerSystemMenuService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute(managerSystemMenuService.selectAllManagerSystemMenu());
        return "index";
    }
}
