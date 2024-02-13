package com.jxufe.reggie.controller;

import com.jxufe.reggie.service.OrderDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Xie
 * @Date 2024/2/8
 * @ClassName OrderDetailController
 * @Description: TODO
 */
@Slf4j
@RestController
@RequestMapping
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;


}
