package com.pps.pojo.group;

/**
 * @Classname PageParam
 * @Description
 * @@Author Pupansheng
 * @Date 2020/1/9 11:04
 * @Vestion 1.0
 **/
public class PageParam {
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
}
