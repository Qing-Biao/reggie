/*
package com.jxufe.reggie.utils;

import com.alibaba.fastjson.JSONException;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
//import com.jxufe.reggie.config.TxProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

*/
/**
 * @Author Xie
 * @Date 2024/2/13
 * @ClassName TxSmsTemplate
 * @Description: 腾讯云发送短信模板对象,封装了发送短信的api
 *//*



@Slf4j
@Component
public class TxSmsTemplate {

    private TxProperties txProperties;

    public TxSmsTemplate(TxProperties txProperties) {
        this.txProperties = txProperties;
    }

    */
/**
     * 发送取件码
     * @param phoneNumber 手机号
     * @param code 取件码
     * @return
     *//*

    public boolean sendMsgCode(String phoneNumber,String code) {
        try {
            // 接收生成的验证码，设置5分钟内填写
            String[] params = {code, "5"};

            // 构建短信发送器
            SmsSingleSender ssender = new SmsSingleSender(txProperties.getAppId(), txProperties.getAppKey());
            //sendWithParm:     传入国家码 电话号码 模板id 模板参数 签名 扩展码为空 返回参数为空
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumber,
                    txProperties.getTemplateId1(), params, txProperties.getSignName(), "", ""); // 签名参数未提供或者为空时，会使用默认签名发送短信

            if(result.result==0){
                return true;
            }else{
                System.out.println("短信发送失败，原因："+result.errMsg);
            }
        } catch (HTTPException e) {
            // HTTP响应码错误
            log.info("短信发送失败,HTTP响应码错误!");
            // e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            log.info("短信发送失败,json解析错误!");
            //e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            log.info("短信发送失败,网络IO错误!");
            // e.printStackTrace();
        }
        return false;
    }


    */
/**
     * 登陆、注册验证
     * @param phoneNumber 手机号
     * @param code 验证码
     * @return
     *//*

    public boolean loginSmsSend(String phoneNumber,String code){
        try {
            // 接收生成的验证码，设置5分钟内填写
            String[] params = {code, "5"};

            // 构建短信发送器
            SmsSingleSender ssender = new SmsSingleSender(txProperties.getAppId(), txProperties.getAppKey());
            //sendWithParm:     传入国家码 电话号码 模板id 模板参数 签名 扩展码为空 返回参数为空
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumber,
                    txProperties.getTemplateId2(), params, txProperties.getSignName(), "", ""); // 签名参数未提供或者为空时，会使用默认签名发送短信

            if(result.result==0){
                return true;
            }else{
                System.out.println("短信发送失败，原因："+result.errMsg);
            }
        } catch (HTTPException e) {
            // HTTP响应码错误
            log.info("短信发送失败,HTTP响应码错误!");
            // e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            log.info("短信发送失败,json解析错误!");
            //e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            log.info("短信发送失败,网络IO错误!");
            // e.printStackTrace();
        }
        return false;
    }
}


*/
