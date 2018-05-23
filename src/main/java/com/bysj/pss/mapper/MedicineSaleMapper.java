package com.bysj.pss.mapper;

import com.bysj.pss.model.pojo.MedicineSale;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface MedicineSaleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MedicineSale record);

    int insertSelective(MedicineSale record);

    MedicineSale selectByPrimaryKey(Integer id);

    List<MedicineSale> getAllSale();

    int updateByPrimaryKeySelective(MedicineSale record);

    int updateByPrimaryKey(MedicineSale record);

    int updateStatus(@Param("id") Integer id,@Param("status") Byte status,@Param("successDate") Date successDate);
}