package com.pps.pojo;

public class TbOrder {
    private Integer id;

    private String userpointid;

    private Integer userid;

    private Integer ownerid;

    private Integer status;

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
}