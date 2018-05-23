package com.bysj.pss.mapper;

import com.bysj.pss.model.pojo.Enterprise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EnterpriseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Enterprise record);

    int insertSelective(Enterprise record);

    Enterprise selectByPrimaryKey(Integer id);

    List<Enterprise> getListEnterprise(@Param("type") byte type);

    int updateByPrimaryKeySelective(Enterprise record);

    int updateByPrimaryKey(Enterprise record);

    List<Enterprise> searchEnterprise(@Param("phone") Long phone,@Param("content") String content);

}