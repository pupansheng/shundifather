package com.pps.pojo.group;

/**
 * @Classname Result
 * @Description
 * @@Author Pupansheng
 * @Date 2019/8/16 16:56
 * @Vestion 1.0
 **/
public class Result {
    private  boolean status;
    private  String message;
    private  Object data;


    public Result(){


    }

    public Result(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public Result(boolean status, Object data) {
        this.status = status;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }


    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
