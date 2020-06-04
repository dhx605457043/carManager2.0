package com.car.manager.entity.Ex;

import com.car.manager.entity.ManagerSystemMenu;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ManagerSystemMenuEx extends ManagerSystemMenu {
    private List<ManagerSystemMenuEx> children = new ArrayList<ManagerSystemMenuEx>();
}
