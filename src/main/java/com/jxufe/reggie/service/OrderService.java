package com.jxufe.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxufe.reggie.pojo.OrderDetail;
import com.jxufe.reggie.pojo.Orders;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author Xie
 * @Date 2024/2/8
 * @ClassName OrderService
 * @Description: TODO
 */
public interface OrderService extends IService<Orders> {

    /**
     * 用户下单
     * @param orders
     */
    public void submit(Orders orders, HttpSession session);

    /**
     * 根据订单id查询订单明细
     * @param orderId
     * @return
     */
    public List<OrderDetail> getOrderDetailListByOrderId(Long orderId);

}
