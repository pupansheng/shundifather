package com.pps.pojo.status;

import javax.xml.soap.Detail;

/**
 * @Classname PackageStatus
 * @Description
 * @@Author Pupansheng
 * @Date 2019/12/31 14:25
 * @Vestion 1.0
 **/
public enum  PackageStatus {
     已提交(1,"已提交，待申请"),已申请(0,"拿货员已申请，待货主同意"),待回复(2,"等待拿货员回复"),被拒绝(3,"拿货员不同意价格"),进行中(4,"进行中")
    ,待支付(5,"待支付"),交易完成(6,"交易完成"),无效(7,"无效状态");
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

    PackageStatus(Integer code, String detail) {
        this.code = code;
        this.detail = detail;
    }
}
