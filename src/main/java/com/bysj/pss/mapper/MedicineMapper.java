package com.bysj.pss.mapper;

import com.bysj.pss.model.pojo.Medicine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MedicineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Medicine record);

    int insertSelective(Medicine record);

    Medicine selectByPrimaryKey(Integer id);

    List<Medicine> getAllMedicine();

    List<Medicine> search(@Param("content") String content);

    int updateByPrimaryKeySelective(Medicine record);

    int updateByPrimaryKey(Medicine record);
}