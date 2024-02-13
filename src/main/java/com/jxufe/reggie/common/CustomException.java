package com.jxufe.reggie.common;

/**
 * @Author Xie
 * @Date 2024/2/5
 * @ClassName CustomException
 * @Description: 自定义异常类
 */
public class CustomException extends  RuntimeException{
    public CustomException(String message){
        super(message);
    }
}
