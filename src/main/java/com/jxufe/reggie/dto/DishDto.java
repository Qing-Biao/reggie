package com.jxufe.reggie.dto;

import com.jxufe.reggie.pojo.Dish;
import com.jxufe.reggie.pojo.DishFlavor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class DishDto extends Dish {

    //菜品对应的口味数据
    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;//菜品名称

    private Integer copies;
}
