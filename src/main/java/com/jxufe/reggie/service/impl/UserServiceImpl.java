package com.jxufe.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxufe.reggie.mapper.UserMapper;
import com.jxufe.reggie.pojo.User;
import com.jxufe.reggie.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author Xie
 * @Date 2024/2/6
 * @ClassName UserServiceImpl
 * @Description: TODO
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
