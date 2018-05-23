package com.bysj.pss.service.serviceImpl;

import com.bysj.pss.constants.ReturnCodeAndMsg;
import com.bysj.pss.converte.UserConverte;
import com.bysj.pss.mapper.MemberMapper;
import com.bysj.pss.mapper.UserMapper;
import com.bysj.pss.model.ReturnValue;
import com.bysj.pss.model.matadata.UserMetadata;
import com.bysj.pss.model.pojo.Member;
import com.bysj.pss.model.pojo.User;
import com.bysj.pss.service.UserService;
import com.bysj.pss.util.UtilMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MemberMapper memberMapper;

    /**
     * 登陆
     * @param mobile
     * @param pass
     * @return
     */
    @Override
    public ReturnValue<UserMetadata> login(String mobile, String pass) {
        if(mobile==null||pass==null){
            return new ReturnValue(ReturnCodeAndMsg.PARA_EMPTY);
        }
        User userFromDB = userMapper.getByMobile(Long.valueOf(mobile));
        if (userFromDB.getUserPassword().equals(pass)){
            String token = UtilMD5.MD5(pass);
            userFromDB.setToken(token);
            try {
                userMapper.updateByPrimaryKeySelective(userFromDB);
                return new ReturnValue(ReturnCodeAndMsg.SUCCESS, UserConverte.Converte(userFromDB));
            }catch (Exception e){
                return new ReturnValue(ReturnCodeAndMsg.DB_CONNECT_ERROR);
            }
        }else{
            return new ReturnValue(ReturnCodeAndMsg.LOGIN_ERROR);
        }
    }

    @Override
    public boolean isLogin(String mobile, String token) {
        return false;
    }

    /**
     * 获得所有用户信息
     */
    @Override
    public ReturnValue<List> getAllUser() {
        List<User> userList = userMapper.getAllUser();
        if(userList==null){
            return new ReturnValue(ReturnCodeAndMsg.No_DATA_IN_DB);
        }else {
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,userList);
        }
    }

    /**
     * 获得职工清单
     * @return
     */
    @Override
    public ReturnValue<List> getAllMamber() {
        List<Member> memberList = memberMapper.getAllMember();
        if(memberList==null){
            return new ReturnValue(ReturnCodeAndMsg.No_DATA_IN_DB);
        }else {
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,memberList);
        }
    }

    /**
     * 添加职工
     * @param member
     * @return
     */
    @Override
    public ReturnValue<Integer> addMember(Member member) {
        if(member==null){
            return new ReturnValue(ReturnCodeAndMsg.PARA_EMPTY,0);
        }
        Integer ret =memberMapper.insertSelective(member);
        if(ret==0){
            return new ReturnValue(ReturnCodeAndMsg.DB_CONNECT_ERROR,0);
        }else{
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,ret);
        }
    }

    /**
     * 更新用户信息
     * @param member
     * @return
     */
    @Override
    public ReturnValue<Integer> updateMember(Member member) {
        if(member==null){
            return new ReturnValue(ReturnCodeAndMsg.PARA_EMPTY,0);
        }
        Integer ret =memberMapper.updateByPrimaryKeySelective(member);
        if(ret==0){
            return new ReturnValue(ReturnCodeAndMsg.DB_CONNECT_ERROR,0);
        }else{
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,ret);
        }
    }

    /**
     * 用户删除
     */
    @Override
    public ReturnValue<Integer> deleteUser(Integer id) {
        if(id==null){
            return new ReturnValue(ReturnCodeAndMsg.PARA_EMPTY,0);
        }
        Integer res = userMapper.deleteByPrimaryKey(id);
        if(res==0){
            return new ReturnValue(ReturnCodeAndMsg.DB_CONNECT_ERROR,0);
        }else {
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,res);
        }
    }

    /**
     * 用户添加
     * @param mobileNumber
     * @param userName
     * @param userPassword
     * @param role
     * @param email
     * @return
     */
    @Override
    public ReturnValue<Integer> addUser(Long mobileNumber, String userName, String userPassword, Byte role, String email) {
        if(mobileNumber==null||userName==null||userPassword==null||role==null||email==null){
            return new ReturnValue(ReturnCodeAndMsg.PARA_EMPTY,0);
        }
        User user = new User();
        user.setMobileNumber(mobileNumber);
        user.setUserPassword(userPassword);
        user.setUserName(userName);
        user.setRole(role);
        user.setEmail(email);
        Integer res = userMapper.insertSelective(user);
        if(res==0){
            return new ReturnValue(ReturnCodeAndMsg.DB_CONNECT_ERROR,0);
        }else {
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,res);
        }
    }

    /**
     * 用户修改
     * @param mobileNumber
     * @param userName
     * @param userPassword
     * @param role
     * @param email
     * @return
     */
    @Override
    public ReturnValue<Integer> updateUser(Integer id,Long mobileNumber, String userName, String userPassword, Byte role, String email) {
        User user = new User();
        user.setMobileNumber(mobileNumber);
        user.setUserPassword(userPassword);
        user.setUserName(userName);
        user.setRole(role);
        user.setEmail(email);
        Integer res = userMapper.updateByPrimaryKeySelective(user);
        if(res==0){
            return new ReturnValue(ReturnCodeAndMsg.DB_CONNECT_ERROR,0);
        }else {
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,res);
        }
    }
}
