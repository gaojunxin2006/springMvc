package cn.itcast.ssm.controller;

import cn.itcast.ssm.exception.CustomException;
import cn.itcast.ssm.po.pojo.Items;
import cn.itcast.ssm.po.pojo.ItemsCustom;
import cn.itcast.ssm.po.pojo.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;
import cn.itcast.ssm.validation.ValidGroup1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 作者：高俊欣
 * 日期：2019/10/16
 * 微信：15000952623
 **/


//商品的控制器

@Controller
//定义url的根路径，访问时加上方法的url
@RequestMapping("/item")
public class ItemsController {


    //注入service
    @Autowired
    private ItemsService itemsService;




    //=========================================================================================================

    //单独将商品类型的方法提炼出来，将方法返回值填充到request，在页面显示

    @ModelAttribute("itemsType")
    public Map<String,String> getItemsType() throws Exception{

        HashMap<String,String> itemsType=new HashMap<String, String>();
        itemsType.put("1", "数码产品");
        itemsType.put("2", "家有电器");
        itemsType.put("3", "书籍");
        itemsType.put("4", "生活用品");





        return itemsType;

    }









    //=========================================================================================================





    //根据条件查询商品
    @RequestMapping("/findItems")
    public ModelAndView findItems() throws Exception {

        System.out.println("ItemsController 这个Controller已经执行。。。。。");

        ItemsQueryVo itemsQueryVo=new ItemsQueryVo();

        System.out.println("ItemsController \t"+itemsQueryVo);

        List<ItemsCustom> list = itemsService.findItemsList(null);

        ModelAndView modelAndView=new ModelAndView();

        modelAndView.addObject("list",list);

        modelAndView.setViewName("/itemsList.jsp");


        return modelAndView;
    }




//=========================================================================================================


    //修改页面显示

//    @RequestMapping(value = "/editItem",method = RequestMethod.GET)
//    public ModelAndView editItems() throws Exception{
//
//        ModelAndView modelAndView=new ModelAndView();
//
//
//        //调用serivce
//        ItemsCustom itemsCustom = itemsService.findItemsById(1);
//
//
//        System.out.println("ItemsController item对象是： \t"+itemsCustom);
//
//        //将模型数据传回jsp
//        modelAndView.addObject("item",itemsCustom);
//
//
//        //指定逻辑视图名
//        modelAndView.setViewName("/editItem.jsp");
//
//
//        return modelAndView;
//
//
//
//    }




    //修改页面显示String方式,使用Model对象作为参数

    @RequestMapping(value = "/editItem",method = RequestMethod.GET)
    public String editItems(Model model,Integer id) throws Exception{

        //调用serivce
        ItemsCustom itemsCustom = itemsService.findItemsById(id);




        System.out.println("ItemsController item对象是： \t"+itemsCustom+"\t传入的id是：\t"+id);

        //将id传回页面,数据回显使用
        model.addAttribute("id",id);


        //将模型数据传回页面
        model.addAttribute("item",itemsCustom);


        return "/editItem.jsp";



    }



    //修改页面显示String方式,不返回参数
//
//    @RequestMapping(value = "/editItem",method = RequestMethod.GET)
//    public void editItems2(Model model, HttpServletRequest request, HttpServletResponse response,Integer id) throws Exception{
//
//        ModelAndView modelAndView=new ModelAndView();
//
//
//        //调用serivce
//        ItemsCustom itemsCustom = itemsService.findItemsById(id);
//
//
//        System.out.println("ItemsController editItems2方法执行 item对象是： \t"+itemsCustom+"\t id是：\t"+id);
//
//        //将模型数据传回jsp ,原始的servlet方式
//        request.setAttribute("item",itemsCustom);
//
//
//
//        request.getRequestDispatcher("/editItem.jsp").forward(request,response);
//
//
//    }










    //=========================================================================================================


    //商品修改提交,上传图片
        //MultipartFile上传图片使用的类型

    @RequestMapping("/editItemSubit")
    public String editItemSubit(Model model, Integer id, String name, Float price,
                                @Validated(value = {ValidGroup1.class}) @ModelAttribute(value = "item") ItemsCustom item, BindingResult bindingResult,
                                ItemsQueryVo itemsQueryVo,
                                //上传图片
                                MultipartFile pictureFile) throws Exception{


        //输出错误信息
        //如果参数绑定有错
        if(bindingResult.hasErrors()){

            //获取错误
            List<ObjectError> allErrors = bindingResult.getAllErrors();

            for(ObjectError error:allErrors){

                //输出错误信息
                System.out.println(error.getDefaultMessage());

            }

        }




        //进行数据回显

            //简单类型数据回显
        model.addAttribute("id",id);
//        model.addAttribute("item",itemsCustom);


        //进行图片上传
        if (pictureFile!=null){

            //进行图片上传,路径保存到数据库

            String path="E:\\upload\\springmvc\\";

            //获取上传内容原始名称
            String originalFilename = pictureFile.getOriginalFilename();

            //生成图片新的名字
            String newFileName= UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));

            //新文件
            File file=new File(path+newFileName);

            //将内存中文件写入磁盘
            pictureFile.transferTo(file);


            //将上传成功后的路径写入到数据库
            item.setPic(newFileName);

        }




        System.out.println("ItemsController editItemSubit......  ItemsCustom是： \t"+item);

        System.out.println("ItemsController editItemSubit......  itemsQueryVo是： \t"+itemsQueryVo);

        System.out.println("ItemsController editItemSubit......  名称是： \t"+name+"\t价格是：\t"+price+"\tid是："+id);



        //绑定pojo，普通pojo，包装pojo

        //调用service更新商品信息
        itemsService.updateItems(id, item);


        //请求重定向
//        return "redirect:findItems.do";
        return "redirect:findItems.action";

    }




    //=========================================================================================================
    //删除商品
    @RequestMapping("/deleteItems")
    public String delete(Integer[] delete_id) throws Exception{

        //调用service方法删除商品


        System.out.println("ItemsController editItemSubit......  delete的id是： \t"+delete_id[0]+"\t"+delete_id[1]);

        return "/success.jsp";

    }





//=========================================================================================================
    //批量修改商品的页面视图
@RequestMapping("/updateAllItems")
public ModelAndView updateAllItems(HttpServletRequest request) throws Exception {

    System.out.println("ItemsController updateAllItems。。。。。");

    ItemsQueryVo itemsQueryVo=new ItemsQueryVo();

    System.out.println("ItemsController \t"+itemsQueryVo);

    List<ItemsCustom> list = itemsService.findItemsList(null);


    System.out.println("ItemsController updateAllItems。。。。。"+list);

    ModelAndView modelAndView=new ModelAndView();

    modelAndView.addObject("itemsList",list);

    modelAndView.setViewName("/editItemsList.jsp");


    return modelAndView;
}







    //=========================================================================================================
    //批量修改商品
    @RequestMapping("/updateAllItemSubmit")
    public ModelAndView updateAllItemSubmit(ItemsQueryVo itemsQueryVo) throws Exception {

        System.out.println("ItemsController updateAllItemSubmit。。。。。"+itemsQueryVo);

        ModelAndView modelAndView=new ModelAndView();


        //使用包装类型接收数据，给包装类型添加Lis属性


        modelAndView.setViewName("/success.jsp");


        return modelAndView;
    }




//=========================================================================================================

    //json的数据交互，请求json响应的也是json















//=========================================================================================================






    //解决日期类型报错问题  方式一：
//    @InitBinder
//    public void initBinder(WebDataBinder binder) throws Exception{
//
//
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"),true));
//
//
//    }



    //解决日期类型报错问题  方式二：

    //属性编辑器，代码掠过，不是重点，早期用法



    //解决日期类型报错问题  方式三， 转换器






//=========================================================================================================

    //根据商品id查看商品信息rest接口， 使用jason返回
    @RequestMapping("/viewItems/{id}")
    public @ResponseBody
    ItemsCustom viewItems(@PathVariable("id") Integer id) throws Exception{

        System.out.println("ItemsController viewItems。。。。。id是：\t"+id);

        ItemsCustom items = itemsService.findItemsById(id);




        return items;
    }







//=========================================================================================================






}
