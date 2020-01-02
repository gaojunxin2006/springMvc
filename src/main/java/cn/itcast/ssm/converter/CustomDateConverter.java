package cn.itcast.ssm.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 作者：高俊欣
 * 日期：2019/10/18
 * 微信：15000952623
 **/

public class CustomDateConverter implements Converter<String, Date> {


    //自定义转换器

    public Date convert(String s) {


        try {

           return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s);



        }catch (Exception e){


            System.out.println("CustomDateConverter 自定义转换器出错。。。。。。。。。");

            e.printStackTrace();


        }




        return null;
    }






}
