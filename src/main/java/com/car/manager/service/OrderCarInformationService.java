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
}