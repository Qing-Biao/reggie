package com.jxufe.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxufe.reggie.pojo.ShoppingCart;

/**
 * @Author Xie
 * @Date 2024/2/8
 * @ClassName ShoppingCartService
 * @Description: TODO
 */

public interface ShoppingCartService extends IService<ShoppingCart> {
    void clean();
}
