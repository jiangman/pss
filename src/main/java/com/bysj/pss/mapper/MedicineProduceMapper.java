package com.bysj.pss.mapper;

import com.bysj.pss.model.pojo.MedicineProduce;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MedicineProduceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MedicineProduce record);

    int insertSelective(MedicineProduce record);

    MedicineProduce selectByPrimaryKey(Integer id);

    List<MedicineProduce> getAllMedicineProduce();

    int updateByPrimaryKeySelective(MedicineProduce record);

    int updateByPrimaryKey(MedicineProduce record);

    int decreaseNumByPrimaryKey(@Param("id") Integer id,@Param("num") Integer num);
}