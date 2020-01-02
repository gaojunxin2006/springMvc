package cn.itcast.ssm.po.pojo;

import cn.itcast.ssm.validation.ValidGroup1;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class Items {
    private Integer id;


    //校验名称的长度 message = "商品名错误"，硬编码的方式.
    @Size(min = 1,max = 30,message = "名称长度需要1到30")
    private String name;

    private Float price;

    private String pic;

    //校验创建商品时间不能为空
    @NotNull(message = "时间不能为空",groups = {ValidGroup1.class})
    private Date createtime;


    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDetail() {
        return detail;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pic='" + pic + '\'' +
                ", createtime=" + createtime +
                ", detail='" + detail + '\'' +
                '}';
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();






    }
}