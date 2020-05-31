package com.car.manager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

/**
 * (OrderCarInformation)实体类
 *
 * @author makejava
 * @since 2020-05-25 22:24:55
 */
@Data
public class OrderCarInformation implements Serializable {
    private static final long serialVersionUID = 270410872438457209L;
    @Id
    private Integer id;
    
    private Integer orderCarId;
    
    private Integer orderDriverId;
    
    private Integer orderCargoId;
    
    private Integer orderTonnage;

    @JsonFormat(pattern = "YYYY-MM-dd")
    private String orderDate;

}