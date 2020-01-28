package com.pps.service;

import com.pps.pojo.group.Result;
import com.pps.pojo.mongo.UserPoint;
import org.springframework.data.geo.GeoResults;

import java.util.List;
import java.util.Map;
/*
 * @Author Pupansheng
 * @Description // 货主寄件相关接口
 * @Date 10:23 2020/1/9
 * @Param 
 * @return 
 **/

public interface UserPointService {


    /*
     * @Author Pupansheng
     * @Description // 保存寄件信息
     * @Date 10:15 2020/1/9
     * @Param
     * @return
     **/
     Result saveUserPoint(UserPoint userPoint);//寄件信息存入MongoDb数据库
    /*
     * @Author Pupansheng
     * @Description // 删除寄件信息
     * @Date 10:16 2020/1/9
     * @Param
     * @return
     **/

    Result deleteUserPoint(String _id);//删除寄件信息
    /*
     * @Author Pupansheng
     * @Description // 更新寄件坐标信息
     * @Date 10:16 2020/1/9
     * @Param
     * @return
     **/

     Result updateUserPont(UserPoint userPoint);
    /*
     * @Author Pupansheng
     * @Description // 更新寄件状态信息
     * @Date 10:16 2020/1/9
     * @Param
     * @return
     **/

    Result updateStatus(UserPoint userPoint,int Status);

    /*
     * @Author Pupansheng
     * @Description // 设置寄件状态
     * @Date 14:04 2020/1/9
     * @Param
     * @return
     **/
     Result setStatus(UserPoint userPoint,int status);

    /*
     * @Author Pupansheng
     * @Description // 货主同意接单或者拒绝
     * @Date 10:16 2020/1/9
     * @Param
     * @return
     **/
    Result agreeOrReject(UserPoint userPoint,int status);
    /*
     * @Author Pupansheng
     * @Description // 更具目的地经纬度获得附近的寄件信息
     * @Date 10:17 2020/1/9
     * @Param
     * @return
     **/

    GeoResults<UserPoint> getNearUserPoint(Double lat, Double lng, Double minDistance, Double maxDistance);//根据经纬度 最大距离获得附近的快递
  /*
   * @Author Pupansheng
   * @Description // 更具id获得寄件信息
   * @Date 10:17 2020/1/9
   * @Param
   * @return
   **/

    UserPoint getUserPoint(String id);
    /*
     * @Author Pupansheng
     * @Description // 根据userId获得寄件信息
     * @Date 10:18 2020/1/9
     * @Param
     * @return
     **/

    List<UserPoint> getUserPointsByUserId(String userId);
    /*
     * @Author Pupansheng
     * @Description // 根据用户Id获得对应状态的寄件信息 带分页
     * @Date 10:18 2020/1/9
     * @Param
     * @return
     **/

     Result getUserPointByUserIdWithPage(int pageNum, int pageSize, int status, int userId);

     /*
      * @Author Pupansheng
      * @Description // 更具用户ID获得对应状态寄件数量
      * @Date 10:19 2020/1/9
      * @Param
      * @return
      **/
     Result getPackageNum(Integer userId);

     /*
      * @Author Pupansheng
      * @Description // 根据寄件获得对应的取货码
      * @Date 15:30 2020/1/9
      * @Param 
      * @return 
      **/
     
     Result getCode(UserPoint userPoint);

     /*
      * @Author Pupansheng
      * @Description // 确认到货
      * @Date 16:08 2020/1/9
      * @Param
      * @return
      **/

     Result querenDaohuo(UserPoint userPoint);
}
