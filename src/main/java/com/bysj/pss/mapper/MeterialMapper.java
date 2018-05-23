package com.bysj.pss.mapper;

import com.bysj.pss.model.pojo.Meterial;
import com.bysj.pss.model.pojo.MeterialOut;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MeterialMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Meterial record);

    int insertSelective(Meterial record);

    Meterial selectByPrimaryKey(Integer id);

    List<Meterial> getAllMeterial();

    List<Meterial> search(@Param("content") String content);

    int updateByPrimaryKeySelective(Meterial record);

    int updateByPrimaryKey(Meterial record);

    int updateNum(@Param("id") Integer id,@Param("number") Double number);

    int updateMeterialList(@Param("meterialList") List<MeterialOut> meterialList);

}