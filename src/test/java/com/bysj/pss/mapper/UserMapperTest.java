package com.bysj.pss.mapper;

import com.bysj.pss.BaseTest;
import com.bysj.pss.model.pojo.User;
import com.bysj.pss.util.UtilsCompare;
import org.apache.ibatis.session.SqlSession;
import com.bysj.pss.mapper.UserMapper;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class UserMapperTest extends BaseTest {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUpdateByPrimaryKeyDeleteSelectByPrimaryKeyTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        User user = this.getTestCase();
        userMapper.insert(user);
        User userFromDB = userMapper.selectByPrimaryKey(user.getMobileNumber());
        Assert.assertTrue(compareTo(userFromDB,user));
        user.setUserSex("F");
        userMapper.updateByPrimaryKey(user);
        userFromDB = userMapper.selectByPrimaryKey(user.getMobileNumber());
        Assert.assertTrue(compareTo(userFromDB,user));
        Assert.assertEquals(1,userMapper.deleteByPrimaryKey(user.getMobileNumber()));
    }

    @Override
    public User getTestCase(){
        User user = new User();
        user.setMobileNumber(98765432101L);
        user.setUserPassword("123456");
        user.setUserName("赵四");
        user.setUserSex("M");
        user.setDepartment("仓库管理部门");
        return user;
    }

    @Override
    public boolean compareTo(Object o1,Object o2){
        Set<String> ignoreProperties = new HashSet<>();
        ignoreProperties.add("creatTime");
        ignoreProperties.add("astLoginTime");
        return UtilsCompare.isPropertiesEquals(o1,o2,ignoreProperties);
    }
}