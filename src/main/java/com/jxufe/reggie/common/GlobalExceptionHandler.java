package com.jxufe.reggie.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Conditional;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Xie
 * @Date 2024/2/4
 * @ClassName GlobalExcptionHandler
 * @Description: 全局异常处理
 */
@ControllerAdvice(annotations = {RestController.class, Conditional.class})
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 异常处理方法
     * @param ex
     * @return
     */
    //@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ExceptionHandler(DuplicateKeyException.class)
    //@ExceptionHandler(Exception.class)
    public R<String> exceptionHandler(Exception ex) {
        log.error(ex.getMessage());

        if(ex.getMessage().contains("Duplicate entry")){
           //4 String[] split = ex.getMessage().split(" ");
            //String msg = split[2]+"已存在";
            String msg ="xxx已存在";
            return R.error(msg);
        }
        return R.error("未知错误");
    }

    /**
     * 异常处理方法
     * @param customException
     * @return
     */

    @ExceptionHandler(CustomException.class)
    public R<String> exceptionHandler(CustomException customException) {
        log.error(customException.getMessage());
        return R.error(customException.getMessage());
    }
}
