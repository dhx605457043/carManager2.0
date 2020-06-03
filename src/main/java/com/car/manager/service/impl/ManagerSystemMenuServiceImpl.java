package com.car.manager.service.impl;

import com.car.manager.controller.response.selectManagerSystemMenuResponse;
import com.car.manager.dao.ManagerSystemMenuMapper;
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
        List<ManagerSystemMenu> responseModel = managerSystemMenuMapper.selectMenuAll();
        List<selectManagerSystemMenuResponse> response = (List<selectManagerSystemMenuResponse>) BeanCopyUtils.copyBeanList(responseModel,selectManagerSystemMenuResponse.class);
        return response;
    }
}