package com.car.manager.dao;

import com.car.manager.entity.AccountingEntry;
import com.car.manager.entity.Ex.AccountingEntryEx;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * (AccountingEntry)表数据库访问层
 *
 * @author Tom_wang
 * @since 2020-07-22 15:31:07
 */
public interface AccountingEntryDao extends Mapper<AccountingEntry> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AccountingEntryEx queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AccountingEntryEx> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param accountingEntry 实例对象
     * @return 对象列表
     */
    List<AccountingEntryEx> queryAll(AccountingEntry accountingEntry);


    /**
     * 修改数据
     *
     * @param accountingEntry 实例对象
     * @return 影响行数
     */
    int update(AccountingEntry accountingEntry);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}
