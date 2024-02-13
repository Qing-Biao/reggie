/*
package com.jxufe.test;

import com.jxufe.reggie.utils.TxSmsTemplate;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

*/
/**
 * @Author Xie
 * @Date 2024/2/5
 * @ClassName UploadFileTest
 * @Description: TODO
 *//*

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSms {

    @Autowired
    private TxSmsTemplate txSmsTemplate;

    */
/**
     * 腾讯云发送短信测试
     *//*

    @Test
    public void TxSmsTest() {
        // 参数1: 手机号(正文模板中的参数{1})
        // 参数2: 验证码(正文模板中的参数{2})
        boolean Msg = txSmsTemplate.sendMsgCode("用户手机号码", "验证码");
        System.out.println(Msg);
    }
}


*/
