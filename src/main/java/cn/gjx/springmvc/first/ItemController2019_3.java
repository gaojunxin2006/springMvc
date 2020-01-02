package cn.gjx.springmvc.first;

import cn.gjx.springmvc.po.Items;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 作者：高俊欣
 * 日期：2019/10/16
 * 微信：15000952623
 **/


//入门程序，查询商品列表

    @Controller
public class ItemController2019_3{


    @RequestMapping("/findlist")
    public ModelAndView findItems(){

         //使用静态数据显示在jsp页面
        // 商品列表

        System.out.println("ItemController2019_3 类中的ModelAndView方法执行了。。。。。。。。");

        List<Items> itemsList = new ArrayList<Items>();

        Items items_1 = new Items();
        items_1.setName("联想笔记本");
        items_1.setPrice(6000f);
        items_1.setCreatetime(new Date());
        items_1.setDetail("ThinkPad T430 联想笔记本电脑！");

        Items items_2 = new Items();
        items_2.setName("苹果手机");
        items_2.setPrice(5000f);
        items_2.setDetail("iphone6苹果手机！");

        itemsList.add(items_1);
        itemsList.add(items_2);


        ModelAndView modelAndView=new ModelAndView();

        modelAndView.addObject("list",itemsList);

        modelAndView.setViewName("/itemsList.jsp");


        return modelAndView;

    }





}
