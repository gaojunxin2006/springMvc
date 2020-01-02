package cn.itcast.ssm.controller;

import cn.itcast.ssm.po.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 作者：高俊欣
 * 日期：2019/10/22
 * 微信：15000952623
 **/


//用户的登陆和退出
@Controller
public class LoginController {

    //用户登陆提交方法

    @RequestMapping("/login")
    public String login(HttpSession session, String usercode, String password) throws Exception{

        System.out.println("LoginController login执行了。。。。。"+usercode);
        //调用service校验账号密码正确性





        //校验通过，将用户身份记录到session
        session.setAttribute("usercode", usercode);

        return "redirect:/item/findItems.do";

    }






    //用户退出
    @RequestMapping("/logout")
    public String logout(HttpSession session){

        System.out.println("LoginController logout执行了。。。。。");

        //session过期
        session.invalidate();

        return "index.jsp";

    }







}
