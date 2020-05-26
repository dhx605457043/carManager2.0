package com.car.manager.service.impl;

import com.car.manager.controller.request.InsertOrderCarInformationRequest;
import com.car.manager.controller.request.SelectAllOrderCarInformationRequest;
import com.car.manager.controller.response.SelectAllOrderCarInformationResponse;
import com.car.manager.core.page.PageDomain;
import com.car.manager.core.page.TableDataInfo;
import com.car.manager.core.page.TableSupport;
import com.car.manager.entity.CarList;
import com.car.manager.entity.Ex.OrderCarInformationEx;
import com.car.manager.dao.OrderCarInformationMapper;
import com.car.manager.entity.OrderCarInformation;
import com.car.manager.service.OrderCarInformationService;
import com.car.manager.util.BeanCopyUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OrderCarInformation)表服务实现类
 *
 * @author makejava
 * @since 2020-05-25 22:24:55
 */
@Service
public class OrderCarInformationServiceImpl implements OrderCarInformationService {
    @Resource
    private OrderCarInformationMapper orderCarInformationMapper;

    @Override
    public TableDataInfo selectAllOrderCarInformation(SelectAllOrderCarInformationRequest request) {
        OrderCarInformationEx requestModel = BeanCopyUtils.copyBean(request,new OrderCarInformationEx());
        List<OrderCarInformationEx> responseModel = orderCarInformationMapper.selectAllOrderCarInformation(requestModel);
        List<SelectAllOrderCarInformationResponse> responses = (List<SelectAllOrderCarInformationResponse>) BeanCopyUtils.copyBeanList(responseModel,SelectAllOrderCarInformationResponse.class);
//        return responses;
        TableDataInfo rspData = new TableDataInfo();
//        List<SelectAllOrderCarInformationResponse> orderCarInformationResponseList = new ArrayList<SelectAllOrderCarInformationResponse>(Arrays.asList(new CarListEx[cars.size()]));
//        Collections.copy(userList, cars);
        PageDomain pageDomain = TableSupport.buildPageRequest();
        if (null == pageDomain.getPageNum() || null == pageDomain.getPageSize()) {
            rspData.setRows(responses);
            rspData.setTotal(responses.size());
            return rspData;
        }
        Integer pageNum = (pageDomain.getPageNum() - 1) * pageDomain.getPageSize();
        Integer pageSize = pageDomain.getPageNum() * pageDomain.getPageSize();
        if (pageSize > responses.size()) {
            pageSize = responses.size();
        }
        rspData.setRows(responses.subList(pageNum, pageSize));
        rspData.setTotal(responses.size());
        return rspData;
    }

    @Override
    public int insertOrderCarInformation(InsertOrderCarInformationRequest request) {
        OrderCarInformation requestModel = BeanCopyUtils.copyBean(request,new OrderCarInformation());
//        requestModel.setCarNumber(requestModel.getCarNumber().toUpperCase());
        return orderCarInformationMapper.insertOrderCarInformation(requestModel);
    }

    //    /**
//     * 通过ID查询单条数据
//     *
//     * @param id 主键
//     * @return 实例对象
//     */
//    @Override
//    public OrderCarInformation queryById(Integer id) {
//        return this.orderCarInformationDao.queryById(id);
//    }
//
//    /**
//     * 查询多条数据
//     *
//     * @param offset 查询起始位置
//     * @param limit 查询条数
//     * @return 对象列表
//     */
//    @Override
//    public List<OrderCarInformation> queryAllByLimit(int offset, int limit) {
//        return this.orderCarInformationDao.queryAllByLimit(offset, limit);
//    }
//
//    /**
//     * 新增数据
//     *
//     * @param orderCarInformation 实例对象
//     * @return 实例对象
//     */
//    @Override
//    public OrderCarInformation insert(OrderCarInformation orderCarInformation) {
//        this.orderCarInformationDao.insert(orderCarInformation);
//        return orderCarInformation;
//    }
//
//    /**
//     * 修改数据
//     *
//     * @param orderCarInformation 实例对象
//     * @return 实例对象
//     */
//    @Override
//    public OrderCarInformation update(OrderCarInformation orderCarInformation) {
//        this.orderCarInformationDao.update(orderCarInformation);
//        return this.queryById(orderCarInformation.getId());
//    }
//
//    /**
//     * 通过主键删除数据
//     *
//     * @param id 主键
//     * @return 是否成功
//     */
//    @Override
//    public boolean deleteById(Integer id) {
//        return this.orderCarInformationDao.deleteById(id) > 0;
//    }
}