package com.pps.pojo;

public class TbOrder {
    private Integer id;

    private String userpointid;

    private Integer userid;

    private Integer ownerid;

    private Integer status;

    private String goodsimage;

    private String goodsname;

    private String goodsweight;

    private String goodsvolume;

    private Double talkprice;

    private String bk1;

    private String bk2;

    private String bk3;

    private Integer goodsstatus;

    private  Integer pageSize;

    private  Integer pageNum;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserpointid() {
        return userpointid;
    }

    public void setUserpointid(String userpointid) {
        this.userpointid = userpointid == null ? null : userpointid.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Integer ownerid) {
        this.ownerid = ownerid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getGoodsimage() {
        return goodsimage;
    }

    public void setGoodsimage(String goodsimage) {
        this.goodsimage = goodsimage == null ? null : goodsimage.trim();
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public String getGoodsweight() {
        return goodsweight;
    }

    public void setGoodsweight(String goodsweight) {
        this.goodsweight = goodsweight == null ? null : goodsweight.trim();
    }

    public String getGoodsvolume() {
        return goodsvolume;
    }

    public void setGoodsvolume(String goodsvolume) {
        this.goodsvolume = goodsvolume == null ? null : goodsvolume.trim();
    }

    public Double getTalkprice() {
        return talkprice;
    }

    public void setTalkprice(Double talkprice) {
        this.talkprice = talkprice;
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

    public String getBk3() {
        return bk3;
    }

    public void setBk3(String bk3) {
        this.bk3 = bk3 == null ? null : bk3.trim();
    }

    public Integer getGoodsstatus() {
        return goodsstatus;
    }

    public void setGoodsstatus(Integer goodsstatus) {
        this.goodsstatus = goodsstatus;
    }
}