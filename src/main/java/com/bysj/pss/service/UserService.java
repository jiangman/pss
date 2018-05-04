package com.bysj.pss.service;

import com.bysj.pss.model.ReturnValue;

public interface UserService {
    ReturnValue<String> login(String mobile, String pass);

    boolean isLogin(String mobile,String token);
}
