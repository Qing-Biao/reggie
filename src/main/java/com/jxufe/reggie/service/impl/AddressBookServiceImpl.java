package com.jxufe.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxufe.reggie.mapper.AddressBookMapper;
import com.jxufe.reggie.pojo.AddressBook;
import com.jxufe.reggie.service.AddressBookService;
import org.springframework.stereotype.Service;

/**
 * @Author Xie
 * @Date 2024/2/8
 * @ClassName AddressBookService
 * @Description: TODO
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {
}
