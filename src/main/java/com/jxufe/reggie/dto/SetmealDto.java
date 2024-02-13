package com.jxufe.reggie.dto;

import com.jxufe.reggie.pojo.Setmeal;
import com.jxufe.reggie.pojo.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName; //套餐名称
}
