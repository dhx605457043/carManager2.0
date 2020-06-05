package com.car.manager.dao;

import com.car.manager.entity.CarList;
import com.car.manager.entity.Ex.ManagerSystemMenuEx;
import com.car.manager.entity.ManagerSystemMenu;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.Mapper;
/**
 * (ManagerSystemMenu)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-03 17:14:19
 */
public interface ManagerSystemMenuMapper extends Mapper<ManagerSystemMenu>, BaseMapper<ManagerSystemMenu> {
    /**
     * 查询系统所有菜单（含按钮）
     *
     * @return 菜单列表
     */
    public List<ManagerSystemMenuEx> selectMenuAll();

    /**
     * 根据菜单ID查询信息
     *
     * @param id 菜单ID
     * @return 菜单信息
     */
    public ManagerSystemMenuEx selectMenuById(Integer id);

    String selectManagerSystemMenuByMenuName (ManagerSystemMenu menu);















    /**
     * 根据用户ID查询菜单
     *
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<ManagerSystemMenu> selectMenuAllByUserId(Long userId);

    /**
     * 查询系统正常显示菜单（不含按钮）
     *
     * @return 菜单列表
     */
    public List<ManagerSystemMenu> selectMenuNormalAll();

    /**
     * 根据用户ID查询菜单
     *
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<ManagerSystemMenu> selectMenusByUserId(Long userId);

    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    public List<String> selectPermsByUserId(Long userId);

    /**
     * 根据角色ID查询菜单
     *
     * @param roleId 角色ID
     * @return 菜单列表
     */
    public List<String> selectMenuTree(Long roleId);

    /**
     * 查询系统菜单列表
     *
     * @param menu 菜单信息
     * @return 菜单列表
     */
    public List<ManagerSystemMenu> selectMenuList(ManagerSystemMenu menu);

    /**
     * 查询系统菜单列表
     *
     * @param menu 菜单信息
     * @return 菜单列表
     */
    public List<ManagerSystemMenu> selectMenuListByUserId(ManagerSystemMenu menu);

    /**
     * 删除菜单管理信息
     *
     * @param id 菜单ID
     * @return 结果
     */
    public int deleteMenuById(Integer id);


    /**
     * 查询菜单数量
     *
     * @param parentId 菜单父ID
     * @return 结果
     */
    public int selectCountMenuByParentId(Long parentId);

    /**
     * 新增菜单信息
     *
     * @param menu 菜单信息
     * @return 结果
     */
    public int insertMenu(ManagerSystemMenu menu);

    /**
     * 修改菜单信息
     *
     * @param menu 菜单信息
     * @return 结果
     */
    public int updateMenu(ManagerSystemMenu menu);

    /**
     * 校验菜单名称是否唯一
     *
     * @param menuName 菜单名称
     * @param parentId 父菜单ID
     * @return 结果
     */
    public ManagerSystemMenu checkMenuNameUnique(@Param("menuName") String menuName, @Param("parentId") int parentId);

}