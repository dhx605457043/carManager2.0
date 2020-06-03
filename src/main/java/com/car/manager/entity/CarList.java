package com.car.manager.entity;

import java.io.Serializable;

import com.car.manager.util.poi.Excel;
import lombok.Data;

import javax.persistence.Id;

@Data
/**
 * (CarList)实体类
 *
 * @author makejava
 * @since 2020-05-14 17:57:58
 */
public class CarList implements Serializable {
    private static final long serialVersionUID = -82997136110213858L;

    @Id
    private Integer id;

    private String carNumber;

//    @Excel(name = "车辆号码")
    private String vehicleNumber;

    private Integer carDriverId;

    private Integer carLicensePlateAreaCode;



}