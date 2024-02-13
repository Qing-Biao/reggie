package com.jxufe.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxufe.reggie.common.BaseContext;
import com.jxufe.reggie.mapper.ShoppingCartMapper;
import com.jxufe.reggie.pojo.ShoppingCart;
import com.jxufe.reggie.service.ShoppingCartService;
import org.springframework.stereotype.Service;

/**
 * @Author Xie
 * @Date 2024/2/8
 * @ClassName ShoppingCartServiceImpl
 * @Description: TODO
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {

    /**
     * 清空购物车
     */
    @Override
    public void clean() {
        LambdaQueryWrapper<ShoppingCart> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId,BaseContext.getCurrentId());
        this.remove(queryWrapper);
    }


}
