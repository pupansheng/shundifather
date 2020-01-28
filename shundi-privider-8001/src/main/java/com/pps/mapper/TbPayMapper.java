package com.pps.mapper;

import com.pps.pojo.TbPay;
import com.pps.pojo.TbPayExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbPayMapper {
    int countByExample(TbPayExample example);

    int deleteByExample(TbPayExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbPay record);

    int insertSelective(TbPay record);

    List<TbPay> selectByExample(TbPayExample example);

    TbPay selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbPay record, @Param("example") TbPayExample example);

    int updateByExample(@Param("record") TbPay record, @Param("example") TbPayExample example);

    int updateByPrimaryKeySelective(TbPay record);

    int updateByPrimaryKey(TbPay record);
}