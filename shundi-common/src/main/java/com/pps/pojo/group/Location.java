package com.pps.pojo.group;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @Classname Location
 * @Description
 * @@Author Pupansheng
 * @Date 2019/8/21 19:23
 * @Vestion 1.0
 **/
public class Location implements Serializable {

    private  String type="Point";//形状
    private  Double[] coordinates;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Double[] coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Location{" +
                "type='" + type + '\'' +
                ", coordinates=" + Arrays.toString(coordinates) +
                '}';
    }
}
