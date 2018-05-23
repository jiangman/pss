package com.bysj.pss.mapper;

import com.bysj.pss.BaseTest;
import com.bysj.pss.model.pojo.User;
import com.bysj.pss.util.UtilsCompare;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class UserMapperTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(UserMapperTest.class);


    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUpdateByPrimaryKeyDeleteSelectByPrimaryKeyTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        User user = this.getTestCase();
        userMapper.insert(user);
        User userFromDB = userMapper.selectByPrimaryKey(user.getId());
        Assert.assertTrue(compareTo(userFromDB,user));
        user.setUserPassword("654321");
        userMapper.updateByPrimaryKeySelective(user);
        userFromDB = userMapper.selectByPrimaryKey(user.getId());
        Assert.assertTrue(compareTo(userFromDB,user));
        Assert.assertEquals(1,userMapper.deleteByPrimaryKey(user.getId()));
    }

//    @Test
//    @Transactional
//    public void getAllUserTest(){
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        userMapper = sqlSession.getMapper(UserMapper.class);
//        for(User u:userMapper.getAllUser()) {
//            logger.info(u.toString());
//        }
//    }

    @Override
    public User getTestCase(){
        User user = new User();
        user.setMobileNumber(98765432101L);
        user.setUserPassword("123456");
        user.setUserName("赵四");
        return user;
    }

    @Override
    public boolean compareTo(Object o1,Object o2){
        Set<String> ignoreProperties = new HashSet<>();
        ignoreProperties.add("creatTime");
        ignoreProperties.add("lastLoginTime");
        return UtilsCompare.isPropertiesEquals(o1,o2,ignoreProperties);
    }
}