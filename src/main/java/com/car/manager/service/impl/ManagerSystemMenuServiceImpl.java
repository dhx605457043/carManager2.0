package com.car.manager.service.impl;

import com.car.manager.controller.response.selectManagerSystemMenuResponse;
import com.car.manager.dao.ManagerSystemMenuMapper;
import com.car.manager.entity.Ex.ManagerSystemMenuEx;
import com.car.manager.entity.ManagerSystemMenu;
import com.car.manager.service.ManagerSystemMenuService;
import com.car.manager.util.BeanCopyUtils;
import org.springframework.stereotype.Service;

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
    public List<selectManagerSystemMenuResponse> selectAllManagerSystemMenu() {
        List<ManagerSystemMenuEx> responseModel = managerSystemMenuMapper.selectMenuAll();
        List<ManagerSystemMenuEx> models = getChildPerms(responseModel,0);
        List<selectManagerSystemMenuResponse> response = (List<selectManagerSystemMenuResponse>) BeanCopyUtils.copyBeanList(models,selectManagerSystemMenuResponse.class);
        return response;
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