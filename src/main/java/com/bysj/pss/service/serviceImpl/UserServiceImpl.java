package com.bysj.pss.service.serviceImpl;

import com.bysj.pss.constants.ReturnCodeAndMsg;
import com.bysj.pss.mapper.UserMapper;
import com.bysj.pss.model.ReturnValue;
import com.bysj.pss.model.pojo.User;
import com.bysj.pss.service.UserService;
import com.bysj.pss.util.UtilMD5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    public UserMapper userMapper;

    @Override
    public ReturnValue<String> login(String mobile, String password) {
        if (mobile == null || password == null) {
            return new ReturnValue<String>(ReturnCodeAndMsg.PARA_EMPTY);
        }
        try {
            Long mobileNumber = Long.getLong(mobile);
            User user = userMapper.selectByPrimaryKey(mobileNumber);
            if (user.getUserPassword().equals(password)) {
                String token = UtilMD5.MD5(user.getUserPassword());
                user.setToken(token);
                userMapper.updateByPrimaryKeySelective(user);
                return new ReturnValue<String>(ReturnCodeAndMsg.SUCCESS, token);
            }
        } catch (Exception e) {
            logger.error("mobile number tranfer error", e);
            return new ReturnValue<String>(ReturnCodeAndMsg.DB_CONNECT_ERROR);
        }
        return new ReturnValue<String>(ReturnCodeAndMsg.LOGIN_ERROR);
    }

    @Override
    public ReturnValue<String> isLogin(String token) {
        return null;
    }
}
