package cn.itcast.ssm.controller;

import cn.itcast.ssm.po.pojo.ItemsCustom;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 作者：高俊欣
 * 日期：2019/10/21
 * 微信：15000952623
 **/


//jason控制器

@Controller
public class JsonTest2019 {


    //请求json响应json，请求商品信息，用json格式.输出商品信息
    @RequestMapping("/requestJson")
    public  @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom) throws Exception{

        System.out.println("JsonTest2019 requestJson执行了。。。。。。。");


        System.out.println("JsonTest2019 requestJson :\t"+itemsCustom);

        return itemsCustom;
    }







    //请求key/value 响应json
    @RequestMapping("/responseJson")
    public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom){

        System.out.println("JsonTest2019 responseJson执行了。。。。。。。");

        System.out.println("JsonTest2019 responseJson执行了。。。。。。。"+itemsCustom);

        return itemsCustom;
    }









}
