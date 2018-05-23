package com.bysj.pss.mapper;

import com.bysj.pss.model.pojo.MeterialOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MeterialOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MeterialOrder record);

    int insertSelective(MeterialOrder record);

    MeterialOrder selectByPrimaryKey(Integer id);

    List<MeterialOrder> getAllOrder();

    List<MeterialOrder> searchOrder(@Param("content") Integer content,@Param("type") Integer type);

    int updateByPrimaryKeySelective(MeterialOrder record);

    int updateByPrimaryKey(MeterialOrder record);
}