package com.jxufe.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jxufe.reggie.common.R;
import com.jxufe.reggie.pojo.User;
import com.jxufe.reggie.service.UserService;
import com.jxufe.reggie.utils.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author Xie
 * @Date 2024/2/13
 * @ClassName UserController
 * @Description: TODO
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @param map
     * @param session
     * @return
     */
    @PostMapping("/login")
    public R<User> login(@RequestBody Map map, HttpSession session) {
        log.info(map.toString());

        //获取手机号
        String phone = map.get("phone").toString();
        //获取验证码
        String code = map.get("code").toString();

        //从Session中获取保存的验证码
        Object codeInsession = session.getAttribute(phone);

        //进行验证码比对(页面提交的验证码和session中保存的验证码比对)
        if (codeInsession != null && codeInsession.equals(code)) {
            //如果能够比对成功,说明登录成功
            //判断当前手机号对应的用户是否为新用户,如果是新用户就自动完成注册
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone, phone);
            User user = userService.getOne(queryWrapper);
            if (user == null) {
                user = new User();
                user.setStatus(1);
                user.setPhone(phone);
                userService.save(user);
            }
            session.setAttribute("user", user.getId());

            return R.success(user);
        }
        return R.error("登录失败");
    }

    /**
     * 用户退出
     *
     * @param request
     * @return
     */
    @PostMapping("/loginout")
    public R<String> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return R.success("退出成功");
    }

    /**
     * 验证码发送
     * @param user
     * @param session
     * @return
     */
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession session){
        //获取手机号
        String phone = user.getPhone();
        if(StringUtils.isNotBlank(phone)){
            //生成随机的4位验证码
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            log.info("code:{}",code);


            //将生成的验证码保存到Session
            session.setAttribute(phone,code);

            return R.success("手机发送验证码成功");
        }

        return R.error("手机发送验证码失败");

    }
}
