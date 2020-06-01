package com.car.manager.service;

import com.car.manager.controller.request.*;
import com.car.manager.controller.response.SelectOrderCarInformationResponse;
import com.car.manager.core.page.TableDataInfo;

/**
 * (OrderCarInformation)表服务接口
 *
 * @author makejava
 * @since 2020-05-25 22:24:55
 */
public interface OrderCarInformationService {
    TableDataInfo selectAllOrderCarInformationPage (SelectOrderCarInformationRequest request);
    int insertOrderCarInformation (InsertOrderCarInformationRequest request);
    SelectOrderCarInformationResponse selectOrderCarInformationById (SelectOrderCarInformationRequest request);
    int updateOrderCarInformation (UpdateOrderCarInformationRequest request);
    int deleteOrderCarInformationById (int id);
}