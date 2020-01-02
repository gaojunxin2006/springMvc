package cn.itcast.ssm.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 作者：高俊欣
 * 日期：2019/10/18
 * 微信：15000952623
 **/

public class StringTrimConverter implements Converter<String, String> {


    //自定义转换器

    public String convert(String source) {

        //去掉字符串两边的空格

        try {

            if(source!=null){
                source=source.trim();
                if (source.equals("")){
                    return null;
                }

            }


        }catch (Exception e){


            System.out.println("CustomDateConverter 字符串去除空格转换器出错。。。。。。。。。");

            e.printStackTrace();


        }




        return source;
    }






}
