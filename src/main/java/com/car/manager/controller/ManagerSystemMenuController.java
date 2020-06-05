package com.car.manager.controller;

import com.car.manager.controller.request.InsertManagerSystemMenuRequest;
import com.car.manager.controller.request.SelectManagerSystemMenuRequest;
import com.car.manager.controller.request.UpdateManagerSystemMenuRequest;
import com.car.manager.controller.response.SelectManagerSystemMenuResponse;
import com.car.manager.core.domain.AjaxResult;
import com.car.manager.entity.Ztree;
import com.car.manager.service.ManagerSystemMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ManagerSystemMenu)表控制层
 *
 * @author makejava
 * @since 2020-06-03 17:14:19
 */
@Controller
@RequestMapping("/managerSystemMenuManager")
public class ManagerSystemMenuController extends BaseController{
    private String prefix = "system/menu";
    /**
     * 服务对象
     */
    @Resource
    private ManagerSystemMenuService managerSystemMenuService;

    @GetMapping("/menuList")
    public String menu () {

        return prefix + "/menu";
    }
    @PostMapping("/list")
    @ResponseBody
    public List<SelectManagerSystemMenuResponse> list(SelectManagerSystemMenuRequest request) {
        List<SelectManagerSystemMenuResponse> menuList = managerSystemMenuService.selectMenuList(request);
        return menuList;
    }
    /**
     * 新增
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId") Integer parentId, ModelMap mmap) {
        SelectManagerSystemMenuResponse menu = null;
        if (0L != parentId) {
            menu = managerSystemMenuService.selectMenuById(parentId);
        } else {
            menu = new SelectManagerSystemMenuResponse();
            menu.setId(0);
            menu.setMenuName("主目录");
        }
        mmap.put("menu", menu);
        return prefix + "/add";
    }

    @PostMapping("/checkMenuName")
    @ResponseBody
    public boolean checkMenuName (SelectManagerSystemMenuRequest request) {
        return managerSystemMenuService.selectManagerSystemMenuByMenuName(request);
    }
    /**
     * 新增保存菜单
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(InsertManagerSystemMenuRequest request) {
        return toAjax(managerSystemMenuService.insertMenu(request));
    }
    /**
     * 修改菜单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        mmap.put("menu", managerSystemMenuService.selectMenuById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存菜单
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated UpdateManagerSystemMenuRequest request) {
        return toAjax(managerSystemMenuService.updateMenu(request));
    }

    /**
     * 删除菜单
     */
    @GetMapping( "/remove/{id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("id") Integer ids) {
        return toAjax(managerSystemMenuService.deleteMenuById(ids));
    }
    /**
     * 加载所有菜单列表树
     */
    @GetMapping("/menuTreeData")
    @ResponseBody
    public List<Ztree> menuTreeData() {
        List<Ztree> ztrees = managerSystemMenuService.menuTreeData();
        return ztrees;
    }
    /**
     * 选择菜单树
     */
    @GetMapping("/selectMenuTree/{id}")
    public String selectMenuTree(@PathVariable("id") Integer id, ModelMap mmap) {
        mmap.put("menu", managerSystemMenuService.selectMenuById(id));
        return prefix + "/tree";
    }
}