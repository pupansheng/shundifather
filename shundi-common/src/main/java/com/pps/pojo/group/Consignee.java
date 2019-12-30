package com.pps.pojo.group;

import java.io.Serializable;

/**
 * @Classname Consignee
 * @Description
 * @@Author Pupansheng
 * @Date 2019/8/30 15:59
 * @Vestion 1.0
 **/
public class Consignee implements Serializable {

    private  String name;//收货人姓名
    private  String phone;//收获人电话

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
