package com.jxufe.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxufe.reggie.pojo.Category;

/**
 * @Author Xie
 * @Date 2024/2/5
 * @ClassName CategoryService
 * @Description: TODO
 */
public interface CategoryService extends IService<Category> {

    public void remove(Long ids);
}
