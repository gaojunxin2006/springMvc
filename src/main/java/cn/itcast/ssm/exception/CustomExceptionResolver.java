package cn.itcast.ssm.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作者：高俊欣
 * 日期：2019/10/21
 * 微信：15000952623
 **/

public class CustomExceptionResolver implements HandlerExceptionResolver {




    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception e) {


        System.out.println("CustomExceptionResolver 统一异常处理器运行。。。。。。。");


        //输出异常
        e.printStackTrace();

        //异常信息
        String message=null;
        CustomException customException=null;


        if (e instanceof CustomException){
            customException= (CustomException) e;

        }else {

            customException= new CustomException("未知错误");

        }

        //错误信息
        message=customException.getMessage();

        request.setAttribute("message", message);


        //统一的异常处理代码
        try {
            //跳转到错误页面
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        return new ModelAndView();


    }





}
