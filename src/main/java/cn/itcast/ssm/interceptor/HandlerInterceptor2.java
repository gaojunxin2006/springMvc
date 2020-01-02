package cn.itcast.ssm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 作者：高俊欣
 * 日期：2019/10/22
 * 微信：15000952623
 **/

public class HandlerInterceptor2 implements HandlerInterceptor {


    //handler前执行
    //用于用户认证，权限校验
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        System.out.println("HandlerInterceptor2 preHandle权限拦截器执行了。。。。。");

        return true;
    }




    //handler执行后返回ModelAndView之前执行
    //页面统一展示内容 公用的内容，使用此方法从handler执行返回ModelAndView之前执行入手
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("HandlerInterceptor2 postHandle 页面统一展示内容执行了。。。。。");


    }




    //handler执行之后执行
    //做系统的统一异常处理，进行方法的性能监控
    //实现统一统一日志
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("HandlerInterceptor2 afterCompletion 记录日志执行了。。。。。");


    }






}
