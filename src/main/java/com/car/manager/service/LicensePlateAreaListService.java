package com.car.manager.service;

import com.car.manager.controller.response.SelectAllCarLicenseResponse;
import java.util.List;

/**
 * (Licenseplatearealist)表服务接口
 *
 * @author makejava
 * @since 2020-05-15 15:22:19
 */
public interface LicensePlateAreaListService {
    List<SelectAllCarLicenseResponse> selectAllCarLicense ();

}