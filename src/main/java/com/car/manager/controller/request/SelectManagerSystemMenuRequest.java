package com.car.manager.controller.request;

import lombok.Data;


@Data
public class SelectManagerSystemMenuRequest {
    private String menuName;
    private int parentId;
    private Integer id;

}
