package com.car.manager.service.impl;

import com.car.manager.entity.OrderCarInformation;
import com.car.manager.dao.OrderCarInformationMapper;
import com.car.manager.service.OrderCarInformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OrderCarInformation)表服务实现类
 *
 * @author makejava
 * @since 2020-05-25 22:24:55
 */
@Service("orderCarInformationService")
public class OrderCarInformationServiceImpl implements OrderCarInformationService {
    @Resource
    private OrderCarInformationMapper orderCarInformationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OrderCarInformation queryById(Integer id) {
        return this.orderCarInformationDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<OrderCarInformation> queryAllByLimit(int offset, int limit) {
        return this.orderCarInformationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param orderCarInformation 实例对象
     * @return 实例对象
     */
    @Override
    public OrderCarInformation insert(OrderCarInformation orderCarInformation) {
        this.orderCarInformationDao.insert(orderCarInformation);
        return orderCarInformation;
    }

    /**
     * 修改数据
     *
     * @param orderCarInformation 实例对象
     * @return 实例对象
     */
    @Override
    public OrderCarInformation update(OrderCarInformation orderCarInformation) {
        this.orderCarInformationDao.update(orderCarInformation);
        return this.queryById(orderCarInformation.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.orderCarInformationDao.deleteById(id) > 0;
    }
}