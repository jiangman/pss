package com.bysj.pss.mapper;

import com.bysj.pss.model.pojo.Member;
import com.bysj.pss.model.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Integer id);

    List<Member> getAllMember();

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}