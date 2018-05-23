package com.bysj.pss.mapper;

import com.bysj.pss.model.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User getByMobile(@Param("mobileNumber") Long mobileNumber);

    List<User> getAllUser();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}