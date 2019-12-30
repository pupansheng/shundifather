package com.pps.service;

import com.pps.pojo.group.Result;
import com.pps.pojo.mongo.UserPoint;
import org.springframework.data.geo.GeoResults;

import java.util.List;
import java.util.Map;

public interface UserPointService {


    public Result saveUserPoint(UserPoint userPoint);//寄件信息存入MongoDb数据库
    public Result deleteUserPoint(String _id);//删除寄件信息
    public Result updateUserPont(UserPoint userPoint);//更新寄件坐标信息
    public GeoResults<UserPoint> getNearUserPoint(Double lat, Double lng, Double minDistance, Double maxDistance);//根据经纬度 最大距离获得附近的快递
    public UserPoint getUserPoint(String id);//获得id用户
    public List<UserPoint> getUserPointsByUserId(String userId);
    public Result getUserPointByUserIdWithPage(int pageNum, int pageSize, int status, int userId);

}
