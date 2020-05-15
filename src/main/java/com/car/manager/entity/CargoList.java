package com.car.manager.entity;

import java.io.Serializable;
import lombok.Data;
@Data
/**
 * (CargoList)实体类
 *
 * @author makejava
 * @since 2020-05-15 15:22:19
 */
public class CargoList implements Serializable {
    private static final long serialVersionUID = 721217886093767087L;
    
    private Integer cargoId;
    
    private String cargoName;

}