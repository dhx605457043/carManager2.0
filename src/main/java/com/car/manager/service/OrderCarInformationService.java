package com.car.manager.service;

import com.car.manager.controller.request.InsertOrderCarInformationRequest;
import com.car.manager.controller.request.SelectAllOrderCarInformationRequest;
import com.car.manager.core.page.TableDataInfo;

/**
 * (OrderCarInformation)表服务接口
 *
 * @author makejava
 * @since 2020-05-25 22:24:55
 */
public interface OrderCarInformationService {
    TableDataInfo selectAllOrderCarInformation (SelectAllOrderCarInformationRequest request);
    int insertOrderCarInformation (InsertOrderCarInformationRequest request);
//    /**
//     * 通过ID查询单条数据
//     *
//     * @param id 主键
//     * @return 实例对象
//     */
//    OrderCarInformation queryById(Integer id);
//
//    /**
//     * 查询多条数据
//     *
//     * @param offset 查询起始位置
//     * @param limit 查询条数
//     * @return 对象列表
//     */
//    List<OrderCarInformation> queryAllByLimit(int offset, int limit);
//
//    /**
//     * 新增数据
//     *
//     * @param orderCarInformation 实例对象
//     * @return 实例对象
//     */
//    OrderCarInformation insert(OrderCarInformation orderCarInformation);
//
//    /**
//     * 修改数据
//     *
//     * @param orderCarInformation 实例对象
//     * @return 实例对象
//     */
//    OrderCarInformation update(OrderCarInformation orderCarInformation);
//
//    /**
//     * 通过主键删除数据
//     *
//     * @param id 主键
//     * @return 是否成功
//     */
//    boolean deleteById(Integer id);

}