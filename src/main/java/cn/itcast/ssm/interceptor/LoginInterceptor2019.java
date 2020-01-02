package cn.itcast.ssm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 作者：高俊欣
 * 日期：2019/10/22
 * 微信：15000952623
 **/


//身份认证拦截器

public class LoginInterceptor2019 implements HandlerInterceptor {


    //handler前执行
    //用于用户认证，权限校验
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {


        System.out.println("LoginInterceptor2019 preHandle权限拦截器执行了。。。。。");


        //得到请求url
        String url = request.getRequestURI();

        //是否是公开地址
        if(url.indexOf("login.action")>=0){

            return true;

        }


        //用户身份在session中是否存在
        HttpSession session=request.getSession();

        String usercode = (String) session.getAttribute("usercode");

        System.out.println("LoginInterceptor2019 preHandle session:\t"+usercode);

        //判断是否在session中存在
        if(usercode!=null){

            return true;
        }

        //执行到这里拦截，跳转登陆页面，用户进行身份认证
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);

        //返回false不继续拦截，true标识放行
        return false;
    }







    //handler执行返回ModelAndView之前执行
    //页面统一展示内容 公用的内容，使用此方法从handler执行返回ModelAndView之前执行入手
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("HandlerInterceptor1 postHandle 页面统一展示内容执行了。。。。。");


    }







    //handler执行之后执行
    //做系统的统一异常处理，进行方法的性能监控
    //实现统一统一日志
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex) throws Exception {


        System.out.println("HandlerInterceptor1 afterCompletion 记录日志执行了。。。。。");

    }






}
