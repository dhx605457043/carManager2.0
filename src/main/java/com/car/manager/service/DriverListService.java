package com.car.manager.service;



import com.car.manager.controller.request.InsertDriverRequest;
import com.car.manager.controller.request.SelectDriverRequest;
import com.car.manager.controller.request.UpdateDriverRequest;
import com.car.manager.controller.response.SelectDriverResponse;
import com.car.manager.core.page.TableDataInfo;

import java.util.List;

/**
 * (DriverList)表服务接口
 *
 * @author makejava
 * @since 2020-05-15 14:21:56
 */
public interface DriverListService {
    TableDataInfo selectAllDriverPage (SelectDriverRequest request);
    List<SelectDriverResponse> selectAllDriver ();
    int insertDriver (InsertDriverRequest request);
    boolean selectDriverByIDCard (SelectDriverRequest request);
    SelectDriverResponse selectDriverById (SelectDriverRequest request);
    int updateDriver (UpdateDriverRequest request);
    int deleteDriverById (int id);
}