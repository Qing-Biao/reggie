package com.jxufe.reggie.dto;

import com.jxufe.reggie.pojo.OrderDetail;
import com.jxufe.reggie.pojo.Orders;
import lombok.Data;
import java.util.List;

/**
 * @Author Xie
 * @Date 2024/2/13
 * @ClassName OrderDto
 * @Description: TODO
 */
@Data
public class OrderDto extends Orders {
    private List<OrderDetail> orderDetails;
}

