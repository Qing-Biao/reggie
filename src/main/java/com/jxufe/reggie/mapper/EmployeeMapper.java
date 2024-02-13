package com.jxufe.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxufe.reggie.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Xie
 * @Date 2024/2/1
 * @ClassName EmployeeMapper
 * @Description: TODO
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
