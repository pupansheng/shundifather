package com.pps.pojo.mongo;

import com.pps.pojo.TbUser;
import com.pps.pojo.group.Consignee;
import com.pps.pojo.group.Goods;
import com.pps.pojo.group.Location;
import org.bson.types.ObjectId;
import org.omg.CORBA._IDLTypeStub;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname UserPoint
 * @Description
 * @@Author Pupansheng
 * @Date 2019/8/24 18:59
 * @Vestion 1.0
 **/
@Document
public class UserPoint implements Serializable {

    @Id
    private String _id;
    @Indexed
    private String user_id;

    private Location location;//出发坐标

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private Location location2;//目的地址

    private TbUser tbUser;//寄货人

    private Consignee consignee;//收货人

    private Goods goods;//货物

    private  String address;//出发地址

    private  String toAddress;//目标地址

    private  Double distance;//距离
    private  Double money;//金额
    private  Date createTime;//时间

    private  String cargoImage;//物品图片

    private  Integer status;//状态

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCargoImage() {
        return cargoImage;
    }

    public void setCargoImage(String cargoImage) {
        this.cargoImage = cargoImage;
    }

    public UserPoint(){


    }

    @PersistenceConstructor
    public UserPoint( String _id,String user_id, Location location, Location location2, TbUser tbUser, Goods goods, Consignee consignee, String address, String toAddress, Double distance, Double money, Date createTime,String cargoImage) {
        this._id= _id;
        this.user_id = user_id;
        this.location = location;
        this.location2=location2;
        this.tbUser = tbUser;
        this.address=address;
        this.toAddress=toAddress;
        this.consignee=consignee;
        this.goods=goods;
        this.money=money;
        this.distance=distance;
        this.createTime=createTime;
        this.cargoImage=cargoImage;

    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Location getLocation2() {
        return location2;
    }

    public void setLocation2(Location location2) {
        this.location2 = location2;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Consignee getConsignee() {
        return consignee;
    }

    public void setConsignee(Consignee consignee) {
        this.consignee = consignee;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public TbUser getTbUser() {
        return tbUser;
    }

    public void setTbUser(TbUser tbUser) {
        this.tbUser = tbUser;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
