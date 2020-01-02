package cn.itcast.ssm.po.pojo;

import cn.itcast.ssm.po.pojo.Items;

import java.util.List;

/**
 * 作者：高俊欣
 * 日期：2019/10/16
 * 微信：15000952623
 **/



//商品包装类

public class ItemsQueryVo extends Items {

    //包装items
   private ItemsCustom itemsCustom;


   //定义一个list，接收商品
    private List<ItemsCustom> itemsList;



    public ItemsCustom getItemsCustom() {
        return itemsCustom;
    }

    public void setItemsCustom(ItemsCustom itemsCustom) {
        this.itemsCustom = itemsCustom;
    }


    public List<ItemsCustom> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<ItemsCustom> itemsList) {
        this.itemsList = itemsList;
    }


    @Override
    public String toString() {
        return "ItemsQueryVo{" +
                "itemsCustom=" + itemsCustom +
                ", itemsList=" + itemsList +
                '}';
    }



}
