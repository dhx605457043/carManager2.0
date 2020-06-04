package com.car.manager.controller.response;

import com.car.manager.entity.Ex.ManagerSystemMenuEx;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class selectManagerSystemMenuResponse {
    private int id;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 父菜单ID
     */
    private int parentId;
    /**
     * 显示顺序
     */
    private int orderNum;
    /**
     * 请求地址
     */
    private String url;
    /**
     * 打开方式（menuItem页签 menuBlank新窗口）
     */
    private String target;
    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    private String menuType;
    /**
     * 菜单状态（0显示 1隐藏）
     */
    private String visible;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 备注
     */
    private String remark;

    private List<ManagerSystemMenuEx> children = new ArrayList<ManagerSystemMenuEx>();
}
