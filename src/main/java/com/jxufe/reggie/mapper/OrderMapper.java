package com.jxufe.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxufe.reggie.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Xie
 * @Date 2024/2/8
 * @ClassName OrderMapper
 * @Description: TODO
 */
@Mapper
public interface OrderMapper extends BaseMapper<Orders> {
}
