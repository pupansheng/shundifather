package com.pps.pojo.group;

public enum MessageType {
    SMS_152441019("身份验证验证码"),SMS_152441018("登录确认验证码"),SMS_152441017("登录异常验证码"),SMS_152441016("用户注册验证码"),SMS_152441015
            ("修改密码验证码"),SMS_152441014("信息变更验证码"),SMS_171358003("短信通知");
    String message;


      MessageType(String d){

          message=d;
      }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
