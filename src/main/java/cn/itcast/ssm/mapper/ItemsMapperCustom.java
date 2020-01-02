package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.pojo.ItemsCustom;
import cn.itcast.ssm.po.pojo.ItemsQueryVo;

import java.util.List;

/**
 * 作者：高俊欣
 * 日期：2019/10/16
 * 微信：15000952623
 **/

public interface ItemsMapperCustom {



    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;




}
