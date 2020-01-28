package com.pps.pojo.status;

/*
 * @Author Pupansheng
 * @Description // 支付状态
 * @Date 18:51 2020/1/11
 * @Param
 * @return
 **/

public enum PayStatus {

    未支付(0,"未支付"),已支付(1,"已支付");
    private  Integer code;
    private  String detail;

    PayStatus(Integer code, String detail) {
        this.code = code;
        this.detail = detail;
    }

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


}
