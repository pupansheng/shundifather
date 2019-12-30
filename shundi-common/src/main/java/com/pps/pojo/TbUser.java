package com.pps.pojo;

import java.math.BigDecimal;

public class TbUser {
    private Integer id;

    private String headimage;

    private String openid;

    private String username;

    private String password;

    private String phone;

    private Integer usertype;

    private Integer lerver;

    private BigDecimal money;

    private String bk1;

    private String bk2;

    private Integer status;

    private String realname;

    private String nativeplace;

    private String nowplace;

    private String idcardimage1;

    private String idcardimage2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage == null ? null : headimage.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public Integer getLerver() {
        return lerver;
    }

    public void setLerver(Integer lerver) {
        this.lerver = lerver;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getBk1() {
        return bk1;
    }

    public void setBk1(String bk1) {
        this.bk1 = bk1 == null ? null : bk1.trim();
    }

    public String getBk2() {
        return bk2;
    }

    public void setBk2(String bk2) {
        this.bk2 = bk2 == null ? null : bk2.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace == null ? null : nativeplace.trim();
    }

    public String getNowplace() {
        return nowplace;
    }

    public void setNowplace(String nowplace) {
        this.nowplace = nowplace == null ? null : nowplace.trim();
    }

    public String getIdcardimage1() {
        return idcardimage1;
    }

    public void setIdcardimage1(String idcardimage1) {
        this.idcardimage1 = idcardimage1 == null ? null : idcardimage1.trim();
    }

    public String getIdcardimage2() {
        return idcardimage2;
    }

    public void setIdcardimage2(String idcardimage2) {
        this.idcardimage2 = idcardimage2 == null ? null : idcardimage2.trim();
    }
}