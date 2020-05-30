package com.car.manager.entity;

import java.io.Serializable;
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

    private Integer carDriverId;

    private Integer carLicensePlateAreaCode;
    private String vehicleNumber;


}