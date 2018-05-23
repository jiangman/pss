package com.bysj.pss.service;

import com.bysj.pss.model.ReturnValue;
import com.bysj.pss.model.matadata.UserMetadata;
import com.bysj.pss.model.pojo.Member;
import com.bysj.pss.model.pojo.User;

import java.util.List;

public interface UserService {
    ReturnValue<UserMetadata> login(String mobile, String pass);

    boolean isLogin(String mobile,String token);

    ReturnValue<List> getAllUser();

    ReturnValue<Integer> deleteUser(Integer id);

    ReturnValue<Integer> addUser(Long mobileNumber,String userName,String userPassword,Byte role,String email);

    ReturnValue<Integer> updateUser(Integer id,Long mobileNumber,String userName,String userPassword,Byte role,String email);

    ReturnValue<List> getAllMamber();

    ReturnValue<Integer> addMember(Member member);

    ReturnValue<Integer> updateMember(Member member);
}
