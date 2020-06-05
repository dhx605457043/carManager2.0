package com.car.manager.service.impl;

import com.car.manager.controller.request.InsertManagerSystemMenuRequest;
import com.car.manager.controller.request.SelectManagerSystemMenuRequest;
import com.car.manager.controller.request.UpdateManagerSystemMenuRequest;
import com.car.manager.controller.response.SelectManagerSystemMenuResponse;
import com.car.manager.dao.ManagerSystemMenuMapper;
import com.car.manager.entity.Ex.ManagerSystemMenuEx;
import com.car.manager.entity.ManagerSystemMenu;
import com.car.manager.entity.PersonalStatement;
import com.car.manager.entity.Ztree;
import com.car.manager.service.ManagerSystemMenuService;
import com.car.manager.util.BeanCopyUtils;
import com.car.manager.util.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.*;

/**
 * (ManagerSystemMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-06-03 17:14:19
 */
@Service
public class ManagerSystemMenuServiceImpl implements ManagerSystemMenuService {
    @Resource
    private ManagerSystemMenuMapper managerSystemMenuMapper;

    @Override
    public List<SelectManagerSystemMenuResponse> selectAllManagerSystemMenu() {
        List<ManagerSystemMenuEx> responseModel = managerSystemMenuMapper.selectMenuAll();
        List<ManagerSystemMenuEx> models = getChildPerms(responseModel,0);
        List<SelectManagerSystemMenuResponse> response = (List<SelectManagerSystemMenuResponse>) BeanCopyUtils.copyBeanList(models, SelectManagerSystemMenuResponse.class);
        return response;
    }
    /**
     * 查询菜单集合
     *
     * @return 所有菜单信息
     */
    @Override
    public List<SelectManagerSystemMenuResponse> selectMenuList(SelectManagerSystemMenuRequest request) {
        List<ManagerSystemMenuEx> responseModel = managerSystemMenuMapper.selectMenuAll();
        List<SelectManagerSystemMenuResponse> responses = (List<SelectManagerSystemMenuResponse>) BeanCopyUtils.copyBeanList(responseModel,SelectManagerSystemMenuResponse.class);
        return responses;
    }
    /**
     * 根据菜单ID查询信息
     *
     * @param id 菜单ID
     * @return 菜单信息
     */
    @Override
    public SelectManagerSystemMenuResponse selectMenuById(Integer id) {
        ManagerSystemMenuEx responseModel = managerSystemMenuMapper.selectMenuById(id);
        SelectManagerSystemMenuResponse response = BeanCopyUtils.copyBean(responseModel,new SelectManagerSystemMenuResponse());
        return response;
    }

//    @Override
//    public boolean selectManagerSystemMenuByMenuName(SelectManagerSystemMenuRequest request) {
//        ManagerSystemMenu requestModel = BeanCopyUtils.copyBean(request,new ManagerSystemMenu());
//        String code = managerSystemMenuMapper.selectManagerSystemMenuByMenuName(requestModel);
//        return code == null ? true : false;
//    }
    /**
     * 校验菜单名称是否唯一
     *
     * @param request 菜单信息
     * @return 结果
     */
    @Override
    public boolean selectManagerSystemMenuByMenuName(SelectManagerSystemMenuRequest request) {
        ManagerSystemMenu requestModel = BeanCopyUtils.copyBean(request,new ManagerSystemMenu());
        Integer id = StringUtils.isNull(requestModel.getId()) ? -1 : requestModel.getId();
        ManagerSystemMenu info = managerSystemMenuMapper.checkMenuNameUnique(requestModel.getMenuName(), requestModel.getParentId());
        if (StringUtils.isNotNull(info) && info.getId() != id) {
            return false;
        }
        return true;
    }
    /**
     * 新增保存菜单信息
     *
     * @param request 菜单信息
     * @return 结果
     */
    @Override
    public int insertMenu(InsertManagerSystemMenuRequest request) {
        ManagerSystemMenu requestModel = BeanCopyUtils.copyBean(request,new ManagerSystemMenu());
        return managerSystemMenuMapper.insertMenu(requestModel);
    }

    /**
     * 修改保存菜单信息
     *
     * @param request 菜单信息
     * @return 结果
     */
    @Override
    public int updateMenu(UpdateManagerSystemMenuRequest request) {
        ManagerSystemMenu requestModel = BeanCopyUtils.copyBean(request,new ManagerSystemMenu());
        Example example = new Example(ManagerSystemMenu.class);
        example.createCriteria().andEqualTo("id", requestModel.getId());
        return managerSystemMenuMapper.updateByExampleSelective(requestModel,example);
    }

    /**
     * 删除菜单管理信息
     *
     * @param id 菜单ID
     * @return 结果
     */
    @Override
    public int deleteMenuById(Integer id) {
        return managerSystemMenuMapper.deleteMenuById(id);
    }

    /**
     * 查询所有菜单
     *
     * @return 菜单列表
     */
    @Override
    public List<Ztree> menuTreeData() {
        List<ManagerSystemMenuEx> menuList = managerSystemMenuMapper.selectMenuAll();
        List<Ztree> ztrees = initZtree(menuList);
        return ztrees;
    }
    /**
     * 对象转菜单树
     *
     * @param menuList 菜单列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<ManagerSystemMenuEx> menuList) {
        return initZtree(menuList, null, false);
    }
    /**
     * 对象转菜单树
     *
     * @param menuList 菜单列表
     * @param roleMenuList 角色已存在菜单列表
     * @param permsFlag 是否需要显示权限标识
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<ManagerSystemMenuEx> menuList, List<String> roleMenuList, boolean permsFlag) {
        List<Ztree> ztrees = new ArrayList<Ztree>();
        boolean isCheck = StringUtils.isNotNull(roleMenuList);
        for (ManagerSystemMenuEx menu : menuList) {
            Ztree ztree = new Ztree();
            ztree.setId(menu.getId());
            ztree.setpId(menu.getParentId());
            ztree.setName(transMenuName(menu, permsFlag));
            ztree.setTitle(menu.getMenuName());
            if (isCheck) {
                ztree.setChecked(roleMenuList.contains(menu.getId()));
            }
            ztrees.add(ztree);
        }
        return ztrees;
    }
    public String transMenuName(ManagerSystemMenuEx menu, boolean permsFlag) {
        StringBuffer sb = new StringBuffer();
        sb.append(menu.getMenuName());
        return sb.toString();
    }














    /**
     * 根据父节点的ID获取所有子节点
     *
     * @param list 分类表
     * @param parentId 传入的父节点ID
     * @return String
     */
    public List<ManagerSystemMenuEx> getChildPerms(List<ManagerSystemMenuEx> list, int parentId) {
        List<ManagerSystemMenuEx> returnList = new ArrayList<ManagerSystemMenuEx>();
        for (Iterator<ManagerSystemMenuEx> iterator = list.iterator(); iterator.hasNext();) {
            ManagerSystemMenuEx t = (ManagerSystemMenuEx) iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (t.getParentId() == parentId) {
                recursionFn(list, t);
                returnList.add(t);
            }
        }
        return returnList;
    }
    /**
     * 递归列表
     *
     * @param list
     * @param t
     */
    private void recursionFn(List<ManagerSystemMenuEx> list, ManagerSystemMenuEx t) {
        // 得到子节点列表
        List<ManagerSystemMenuEx> childList = getChildList(list, t);
        t.setChildren(childList);
        for (ManagerSystemMenuEx tChild : childList) {
            if (hasChild(list, tChild)) {
                // 判断是否有子节点
                Iterator<ManagerSystemMenuEx> it = childList.iterator();
                while (it.hasNext()) {
                    ManagerSystemMenuEx n = (ManagerSystemMenuEx) it.next();
                    recursionFn(list, n);
                }
            }
        }
    }
    /**
     * 得到子节点列表
     */
    private List<ManagerSystemMenuEx> getChildList(List<ManagerSystemMenuEx> list, ManagerSystemMenuEx t) {
        List<ManagerSystemMenuEx> tlist = new ArrayList<ManagerSystemMenuEx>();
        Iterator<ManagerSystemMenuEx> it = list.iterator();
        while (it.hasNext()) {
            ManagerSystemMenuEx n = (ManagerSystemMenuEx) it.next();
            if (n.getParentId() == t.getId()) {
                tlist.add(n);
            }
        }
        return tlist;
    }
    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<ManagerSystemMenuEx> list, ManagerSystemMenuEx t) {
        return getChildList(list, t).size() > 0 ? true : false;
    }
}