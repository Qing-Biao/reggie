package com.jxufe.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxufe.reggie.dto.SetmealDto;
import com.jxufe.reggie.pojo.Setmeal;
import java.util.List;

/**
 * @Author Xie
 * @Date 2024/2/5
 * @ClassName SetmealService
 * @Description: TODO
 */
public interface SetmealService extends IService<Setmeal> {

    /**
     * 新增套餐，同时需要保存套餐和菜品的关联关系
     */
    public void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐，同时需要删除套餐和菜品的关联数据
     * @param ids
     */
    public void removeWithDish(List<Long> ids);

    /**
     * 根据id查找套餐
     */
    public SetmealDto getByIdWithDishes(Long id);

    /**
     * 修改套餐
     * @param setmealDto
     */
    void updateWithDishes(SetmealDto setmealDto);
}
