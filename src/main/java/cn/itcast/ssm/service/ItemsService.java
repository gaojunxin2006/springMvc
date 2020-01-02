package cn.itcast.ssm.service;

import cn.itcast.ssm.po.pojo.ItemsCustom;
import cn.itcast.ssm.po.pojo.ItemsQueryVo;

import java.util.List;

/**
 * 作者：高俊欣
 * 日期：2019/10/16
 * 微信：15000952623
 **/

//商品服务service接口

public interface ItemsService {



    //商品查询列表
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;



    //根据商品id查询商品信息
    public ItemsCustom findItemsById(Integer id) throws Exception;


    //更新商品信息
    public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;








}
