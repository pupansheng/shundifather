package com.pps.pojo.group;

import java.io.Serializable;

/**
 * @Classname Goods
 * @Description
 * @@Author Pupansheng
 * @Date 2019/8/30 16:01
 * @Vestion 1.0
 **/
public class Goods implements Serializable{
    private  String name;//货物名
    private  String number;//数量
    private  String weight;//重量
    private  String detail;//描述
    private  String volume;//体积

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
