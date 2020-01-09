package com.pps.pojo.status;

public enum OrderStatus {

     已申请(0,"已申请，待同意"),已同意(1,"货主同意，可以取货"),被拒绝(2,"进行中"),进行中(3,"进行中"),待确认收货(4,"待确认收货")
    ,待支付(5,"待支付"),交易完成(6,"交易完成"),无效(7,"无效状态");;
    private  Integer code;
    private  String detail;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    OrderStatus(Integer code, String detail) {
        this.code = code;
        this.detail = detail;
    }
}
