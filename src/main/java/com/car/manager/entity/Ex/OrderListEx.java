package com.car.manager.entity.Ex;

import com.car.manager.entity.OrderList;
import lombok.Data;

@Data
public class OrderListEx extends OrderList {
    private String cargoName;
    private String consignorName;

}
