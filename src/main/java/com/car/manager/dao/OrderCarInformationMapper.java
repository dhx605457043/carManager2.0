package com.car.manager.dao;

import com.car.manager.entity.Ex.OrderCarInformationEx;
import com.car.manager.entity.OrderCarInformation;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (OrderCarInformation)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-25 22:24:55
 */
public interface OrderCarInformationMapper {
List<OrderCarInformationEx> selectAllOrderCarInformation (OrderCarInformationEx orderCarInformationEx);
//    /**
//     * 通过ID查询单条数据
//     *
//     * @param id 主键
//     * @return 实例对象
//     */
//    OrderCarInformation queryById(Integer id);
//
//    /**
//     * 查询指定行数据
//     *
//     * @param offset 查询起始位置
//     * @param limit 查询条数
//     * @return 对象列表
//     */
//    List<OrderCarInformation> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);
//
//
//    /**
//     * 通过实体作为筛选条件查询
//     *
//     * @param orderCarInformation 实例对象
//     * @return 对象列表
//     */
//    List<OrderCarInformation> queryAll(OrderCarInformation orderCarInformation);
//
//    /**
//     * 新增数据
//     *
//     * @param orderCarInformation 实例对象
//     * @return 影响行数
//     */
//    int insert(OrderCarInformation orderCarInformation);
//
//    /**
//     * 修改数据
//     *
//     * @param orderCarInformation 实例对象
//     * @return 影响行数
//     */
//    int update(OrderCarInformation orderCarInformation);
//
//    /**
//     * 通过主键删除数据
//     *
//     * @param id 主键
//     * @return 影响行数
//     */
//    int deleteById(Integer id);

}