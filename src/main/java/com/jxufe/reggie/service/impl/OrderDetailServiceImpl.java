package com.jxufe.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxufe.reggie.mapper.OrderDetailMapper;
import com.jxufe.reggie.pojo.OrderDetail;
import com.jxufe.reggie.service.OrderDetailService;
import org.springframework.stereotype.Service;

/**
 * @Author Xie
 * @Date 2024/2/8
 * @ClassName OrderDetailServiceImpl
 * @Description: TODO
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
