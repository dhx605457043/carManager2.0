package com.car.manager.dao;

import com.car.manager.entity.Ex.OrderListEx;
import com.car.manager.entity.OrderList;
import com.car.manager.entity.PersonalStatement;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;
/**
 * (PersonalStatement)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-02 12:38:12
 */
public interface PersonalStatementMapper extends Mapper<PersonalStatement>, BaseMapper<PersonalStatement> {

    List<PersonalStatement>selectAllPersonalStatement(PersonalStatement personalStatement);

}