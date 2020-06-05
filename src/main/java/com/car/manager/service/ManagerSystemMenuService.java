package com.car.manager.service;

import com.car.manager.controller.request.InsertManagerSystemMenuRequest;
import com.car.manager.controller.request.SelectCarRequest;
import com.car.manager.controller.request.SelectManagerSystemMenuRequest;
import com.car.manager.controller.request.UpdateManagerSystemMenuRequest;
import com.car.manager.controller.response.SelectManagerSystemMenuResponse;
import com.car.manager.entity.Ztree;

import java.util.List;

/**
 * (ManagerSystemMenu)表服务接口
 *
 * @author makejava
 * @since 2020-06-03 17:14:19
 */
public interface ManagerSystemMenuService {
    List<SelectManagerSystemMenuResponse> selectAllManagerSystemMenu ();
    /**
     * 查询系统菜单列表
     *
     * @param request 菜单信息
     * @return 菜单列表
     */
    public List<SelectManagerSystemMenuResponse> selectMenuList(SelectManagerSystemMenuRequest request);
    /**
     * 根据菜单ID查询信息
     *
     * @param id 菜单ID
     * @return 菜单信息
     */
    public SelectManagerSystemMenuResponse selectMenuById(Integer id);

    /**
     * 校验菜单名称是否唯一
     *
     * @param request 菜单信息
     * @return 结果
     */
    boolean selectManagerSystemMenuByMenuName (SelectManagerSystemMenuRequest request);
    /**
     * 新增保存菜单信息
     *
     * @param request 菜单信息
     * @return 结果
     */
    public int insertMenu(InsertManagerSystemMenuRequest request);

    /**
     * 修改保存菜单信息
     *
     * @param request 菜单信息
     * @return 结果
     */
    public int updateMenu(UpdateManagerSystemMenuRequest request);
    /**
     * 删除菜单管理信息
     *
     * @param id 菜单ID
     * @return 结果
     */
    public int deleteMenuById(Integer id);
    /**
     * 查询所有菜单信息
     *
     * @return 菜单列表
     */
    public List<Ztree> menuTreeData();
}