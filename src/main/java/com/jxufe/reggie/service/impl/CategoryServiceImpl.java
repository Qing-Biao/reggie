package com.jxufe.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxufe.reggie.common.CustomException;
import com.jxufe.reggie.mapper.CategoryMapper;
import com.jxufe.reggie.pojo.Category;
import com.jxufe.reggie.pojo.Dish;
import com.jxufe.reggie.pojo.Setmeal;
import com.jxufe.reggie.service.CategoryService;
import com.jxufe.reggie.service.DishService;
import com.jxufe.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Xie
 * @Date 2024/2/5
 * @ClassName CategoryServiceimpl
 * @Description: TODO
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    /**
     * 根据id进行删除分类，删除之前需要进行判断
     *
     * @param ids
     */
    @Override
    public void remove(Long ids) {

        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据分类if进行查询
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, ids);
        int count1 = dishService.count(dishLambdaQueryWrapper);

        //查询当前分类是否关联了菜品，如果已经关联，抛出一个业务异常
        if (count1 > 0) {
            //已经关联了菜品，抛出一个业务异常
            throw new CustomException("当前分类项关联了菜品，不能删除");
        }

        //查询当前分类是否关联了套餐，如果已经关联，抛出一个业务异常
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, ids);
        int count2 = setmealService.count(setmealLambdaQueryWrapper);
        if (count2 > 0) {
            //已经关联了套餐，抛出一个业务异常
            throw new CustomException("当前分类项关联了套餐，不能删除");
        }
        //正常删除分类
        super.removeById(ids);
    }
}
