package com.bysj.pss.mapper;

import com.bysj.pss.model.pojo.MeterialOut;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MeterialOutMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MeterialOut record);

    int insertSelective(MeterialOut record);

    MeterialOut selectByPrimaryKey(Integer id);

    List<MeterialOut> getAllMeterialOut();

    int updateByPrimaryKeySelective(MeterialOut record);

    int updateByPrimaryKey(MeterialOut record);

    int insertMeterialOutList(@Param("meterialOutList") List<MeterialOut> meterialOutList);

}