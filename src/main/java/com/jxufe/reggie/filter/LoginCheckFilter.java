package com.jxufe.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.jxufe.reggie.common.BaseContext;
import com.jxufe.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Xie
 * @Date 2024/2/3
 * @ClassName LoginCheckFilter
 * @Description: 过滤器（检查用户是否已经完成登录）,过滤是过滤自己需要的
 */
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    //路由匹配器，支持通配符
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //1.获取本次请求的URI
        String requestURI = request.getRequestURI();//backend/index.html


        log.info("拦截到请求：{}", requestURI);
        //定义不需要处理的请求路径
        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/user/sendMsg",
                "/user/login"
        };

        //2.判断本次请求是否需要处理
        boolean check = check(urls, requestURI);

        //3.如果不需要处理，则直接放行
        if (check) {
            log.info("本次请求：{}不需要处理", requestURI);
            filterChain.doFilter(request, response);//过滤器中放行请求的方法调用
            return;
        }


        //4-1.判断登录状态，如果已登录，则直接放行
        if (request.getSession().getAttribute("employee") != null) {
            Long empId = (Long) request.getSession().getAttribute("employee");
            log.info("用户已登录，用户id为：{}", empId);
            long id = Thread.currentThread().getId();
            BaseContext.setCurrentId(empId);
            filterChain.doFilter(request, response);//过滤器中放行请求的方法调用
            return;
        }

        //4-2.判断登录状态，如果已登录，则直接放行
        if (request.getSession().getAttribute("user") != null) {
            Long userId = (Long) request.getSession().getAttribute("user");
            log.info("用户已登录，用户id为：{}", userId);
            long id = Thread.currentThread().getId();
            BaseContext.setCurrentId(userId);
            filterChain.doFilter(request, response);//过滤器中放行请求的方法调用
            return;
        }

        log.info("用户未登录");
        //5.如果未登录则返回未登录结果,根据前端响应拦截器，通过输出流方式向客户端页面响应
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));

    }

    /**
     * 路径匹配，检查本请求是否需要放行
     *
     * @param urls
     * @param requestURI
     * @return
     */
    public boolean check(String[] urls, String requestURI) {
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match) {
                return true;
            }
        }
        return false;
    }
}
