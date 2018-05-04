package com.bysj.pss.mapper;

import com.bysj.pss.model.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long mobileNumber);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long mobileNumber);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}