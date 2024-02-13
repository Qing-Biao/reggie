package com.jxufe.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxufe.reggie.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Xie
 * @Date 2024/2/6
 * @ClassName UserMapper
 * @Description: TODO
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
