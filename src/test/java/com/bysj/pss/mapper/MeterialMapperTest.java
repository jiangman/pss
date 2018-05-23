package com.bysj.pss.mapper;

import com.bysj.pss.BaseTest;
import com.bysj.pss.model.pojo.Meterial;
import com.bysj.pss.util.UtilsCompare;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

public class MeterialMapperTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(MeterialMapperTest.class);

    @Autowired
    private MeterialMapper meterialMapper;

    @Override
    public void insertUpdateByPrimaryKeyDeleteSelectByPrimaryKeyTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        meterialMapper = sqlSession.getMapper(MeterialMapper.class);
        Meterial meterial = this.getTestCase();
        meterialMapper.insert(meterial);
        Meterial userFromDB = meterialMapper.selectByPrimaryKey(meterial.getId());
        Assert.assertTrue(compareTo(userFromDB, meterial));
        meterial.setIntroduce("");
        meterialMapper.updateByPrimaryKey(meterial);
        userFromDB = meterialMapper.selectByPrimaryKey(meterial.getId());
        Assert.assertTrue(compareTo(userFromDB, meterial));
        Assert.assertEquals(1, meterialMapper.deleteByPrimaryKey(meterial.getId()));
    }

    @Test
    @Transactional
    public void getMeterialListTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        meterialMapper = sqlSession.getMapper(MeterialMapper.class);
        Meterial meterial = meterialMapper.selectByPrimaryKey(18);
//        List<Meterial> lm = meterialMapper.getAllMeterial();
//        for (Meterial m : lm) {
//            logger.info(m.toString());
//        }
    }

//    @Test
//    public void insertTest(){
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        meterialMapper = sqlSession.getMapper(MeterialMapper.class);
//        Meterial meterial = this.getTestCase();
//        meterialMapper.insert(meterial);
//    }

    @Override
    public Meterial getTestCase() {
        Meterial meterial = new Meterial();
        meterial.setEnterpriseId(3);
        meterial.setIntroduce("活血养颜");
        meterial.setMeterialName("红枣");
        meterial.setSaveway("干燥");
        meterial.setPicturePath("../images/logo.png");
        meterial.setNumber(12.0);
        meterial.setNumberNeed(12.0);
        meterial.setMeterialSize(((byte) 2));
        return meterial;
    }

    @Override
    public boolean compareTo(Object o1, Object o2) {
        Set<String> ignoreProperties = new HashSet<>();
        ignoreProperties.add("creatTime");
        ignoreProperties.add("astLoginTime");
        return UtilsCompare.isPropertiesEquals(o1, o2, ignoreProperties);
    }
}