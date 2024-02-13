package com.jxufe.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxufe.reggie.mapper.EmployeeMapper;
import com.jxufe.reggie.pojo.Employee;
import com.jxufe.reggie.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @Author Xie
 * @Date 2024/2/1
 * @ClassName EmployeeServiceImpl
 * @Description: TODO
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}

