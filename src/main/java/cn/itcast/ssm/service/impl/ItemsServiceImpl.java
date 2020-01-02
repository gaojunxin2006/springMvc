package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.exception.CustomException;
import cn.itcast.ssm.mapper.ItemsMapper;
import cn.itcast.ssm.mapper.ItemsMapperCustom;
import cn.itcast.ssm.po.pojo.ItemsCustom;
import cn.itcast.ssm.po.pojo.ItemsQueryVo;
import cn.itcast.ssm.po.pojo.Items;
import cn.itcast.ssm.service.ItemsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 作者：高俊欣
 * 日期：2019/10/16
 * 微信：15000952623
 **/

public class ItemsServiceImpl implements ItemsService {

    //注入mapper

    @Autowired
    private ItemsMapperCustom itemsMapperCustom;


    @Autowired
    private ItemsMapper itemsMapper;




    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {

        System.out.println("ItemsServiceImpl 已执行...........");

        List<ItemsCustom> list = itemsMapperCustom.findItemsList(itemsQueryVo);

        System.out.println("ItemsServiceImpl 已执行，返回集合对象是：\t"+list);


        return list;

    }




    public ItemsCustom findItemsById(Integer id) throws Exception {

        Items items = itemsMapper.selectByPrimaryKey(id);

        //测试统一抛出异常
        if (items==null){

            throw new CustomException("修改信息不存在");

        }


        ItemsCustom itemsCustom= new ItemsCustom();

        //将items的属性拷贝到itemsCustom,使用BeanUtils 这个工具
        BeanUtils.copyProperties(items, itemsCustom);

        System.out.println("ItemsServiceImpl 类执行了。。：\t"+itemsCustom);

        return itemsCustom;

    }






    /*
       id 修改商品的id
       itemsCustom 修改商品的信息
     */

    public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception {

        //写业务代码




        //对于关键业务数据进行非空校验
        if (id==null){

            //抛出异常，提示调用接口的用户id不能为空
            System.out.println("ItemsServiceImpl 类执行了。。：updateItems方法出错了！，暂时这样写，以后要抛出异常！\t");

        }


//        itemsMapper.updateByPrimaryKey(itemsCustom);

        itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);



    }










}
