package com.bysj.pss.controller;

import com.bysj.pss.model.ReturnValue;
import com.bysj.pss.model.matadata.UserMetadata;
import com.bysj.pss.model.pojo.Enterprise;
import com.bysj.pss.model.pojo.Member;
import com.bysj.pss.service.EnterpriseService;
import com.bysj.pss.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/bysj/pss")
public class UserEnterpriseController {

    private static Logger logger = LoggerFactory.getLogger(UserEnterpriseController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private EnterpriseService enterpriseService;

    /**
     * 用户登陆
     * @param mobile
     * @param password
     * @return
     */
    @RequestMapping(value="/login",method= RequestMethod.POST)
    public ReturnValue<UserMetadata> login(
            @RequestParam("mobile") String mobile,
            @RequestParam("password") String password){
        logger.info("调用登陆接口手机号："+mobile+"以及密码："+password);
        return userService.login(mobile,password);
    }

    /**
     * 用户清单
     * @return
     */
    @RequestMapping(value="/user/list",method= RequestMethod.GET)
    public ReturnValue<List> getAllUser(){
        return userService.getAllUser();
    }

    /**
     * 用户添加接口
     * @param mobileNumber
     * @param userName
     * @param userPassword
     * @param role
     * @param email
     * @return
     */
    @RequestMapping(value="/user",method= RequestMethod.POST)
    public ReturnValue<Integer> addUser(
            @RequestParam("mobileNumber") Long mobileNumber,
            @RequestParam("userName") String userName,
            @RequestParam("userPassword") String userPassword,
            @RequestParam("role") Byte role,
            @RequestParam("email") String email){
        return userService.addUser(mobileNumber,userName,userPassword,role,email);
    }

    /**
     * 用户删除接口
     * @param id
     * @return
     */
    @RequestMapping(value="/user/{id}",method= RequestMethod.DELETE)
    public ReturnValue<Integer> deleteUser(
            @PathVariable("id") Integer id){
        return userService.deleteUser(id);
    }

    /**
     * 用户更新接口
     * @param id
     * @param mobileNumber
     * @param userName
     * @param userPassword
     * @param role
     * @param email
     * @return
     */
    @RequestMapping(value="/user/{id}",method= RequestMethod.POST)
    public ReturnValue<Integer> updateUser(
            @PathVariable("id") Integer id,
            @RequestParam("mobileNumber") Long mobileNumber,
            @RequestParam("userName") String userName,
            @RequestParam("userPassword") String userPassword,
            @RequestParam("role") Byte role,
            @RequestParam("email") String email){
        return userService.updateUser(id,mobileNumber,userName,userPassword,role,email);
    }

    /**
     * 企业清单
     * @param type
     * @return
     */
    @RequestMapping(value="/enterpriseList/{type}",method= RequestMethod.GET)
    public ReturnValue<List> getEnterpriseList(
            @PathVariable("type") Byte type){
        logger.info("调用企业列表接口，类型为："+type);
        return enterpriseService.getEnterpriseList(type);
    }

    /**
     * 添加记录
     * @param name
     * @param legalPerson
     * @param contactName
     * @param contactMobile
     * @param email
     * @param address
     * @param socialCreditCode
     * @param type
     * @param drugBusiness
     * @param introduction
     * @return
     */
    @RequestMapping(value="/enterprise",method= RequestMethod.POST)
    public ReturnValue<Integer> insertEnterprise(
            @RequestParam String name,
            @RequestParam String legalPerson,
            @RequestParam String contactName,
            @RequestParam Long contactMobile,
            @RequestParam String email,
            @RequestParam String address,
            @RequestParam String socialCreditCode,
            @RequestParam Byte type,
            @RequestParam String drugBusiness,
            @RequestParam String introduction){
        logger.info("调用企业列表接口,插入数据");
       return enterpriseService.insertEnterpriseList(name,legalPerson,contactName,contactMobile,email,address,
               socialCreditCode,type,drugBusiness,introduction);
    }

    /**
     * 单条查询
     * @param id
     * @return
     */
    @RequestMapping(value="/enterprise/{id}",method= RequestMethod.GET)
    public ReturnValue<Enterprise> getEnterpriseById(
            @PathVariable("id") Integer id){
        logger.info("调用企业查询接口,获取数据"+id);
        return enterpriseService.getEnterpriseById(id);
    }

    /**
     * 企业记录单条更新
     * @param id
     * @param name
     * @param legalPerson
     * @param contactName
     * @param contactMobile
     * @param email
     * @param address
     * @param socialCreditCode
     * @param type
     * @param drugBusiness
     * @param introduction
     * @return
     */
    @RequestMapping(value="/enterprise/{id}",method= RequestMethod.POST)
    public ReturnValue<Integer> updateEnterprise(
            @PathVariable("id") Integer id,
            @RequestParam String name,
            @RequestParam String legalPerson,
            @RequestParam String contactName,
            @RequestParam Long contactMobile,
            @RequestParam String email,
            @RequestParam String address,
            @RequestParam String socialCreditCode,
            @RequestParam Byte type,
            @RequestParam String drugBusiness,
            @RequestParam String introduction){
        logger.info("调用企业更新接口,更新数据");
        return enterpriseService.updateEnterprise(id,name,legalPerson,contactName,contactMobile,email,address,
                socialCreditCode,type,drugBusiness,introduction);
    }

    /**
     * 删除企业记录
     * @param id
     * @return
     */
    //单条数据删除
    @RequestMapping(value="/enterprise/{id}",method= RequestMethod.DELETE)
    public ReturnValue<Integer> deleteEnterpriseById(
            @PathVariable("id") Integer id){
        logger.info("调用企业删除接口,删除数据"+id);
        return enterpriseService.deleteEnterpriseById(id);
    }

    /**
     * 企业模糊搜索接口
     * @param content
     * @return
     */
    //模糊搜索接口
    @RequestMapping(value="/enterprise",method= RequestMethod.GET)
    public ReturnValue<List> searchEnterprise(
            @RequestParam("content") String content){
        logger.info("调用企业搜索接口,搜索数据"+content);
        return enterpriseService.searchEnterprise(content);
    }

    /**
     * 获得职工清单
     * @return
     */
    @RequestMapping(value="/member/list",method= RequestMethod.GET)
    public ReturnValue<List> getAllMember(){
        return userService.getAllMamber();
    }

    /**
     * 职工添加接口
     * @param name
     * @param mobileNumber
     * @param userSex
     * @param card
     * @param addr
     * @param position
     * @return
     */
    @RequestMapping(value="/member",method= RequestMethod.POST)
    public ReturnValue<Integer> addMember(
            @RequestParam String name,
            @RequestParam Long mobileNumber,
            @RequestParam Byte userSex,
            @RequestParam String card,
            @RequestParam String addr,
            @RequestParam Byte position){
        logger.info("调用企业更新接口,更新数据");
        Member member = new Member();
        member.setName(name);
        member.setMobileNumber(mobileNumber);
        member.setUserSex(userSex);
        member.setCard(card);
        member.setAddr(addr);
        member.setPosition(position);
        return userService.addMember(member);
    }

    /**
     * 职工更新接口
     * @param name
     * @param mobileNumber
     * @param userSex
     * @param card
     * @param addr
     * @param position
     * @return
     */
    @RequestMapping(value="/member/{id}",method= RequestMethod.POST)
    public ReturnValue<Integer> addMember(
            @PathVariable Integer id,
            @RequestParam String name,
            @RequestParam Long mobileNumber,
            @RequestParam Byte userSex,
            @RequestParam String card,
            @RequestParam String addr,
            @RequestParam Byte position){
        logger.info("调用企业更新接口,更新数据");
        Member member = new Member();
        member.setId(id);
        member.setName(name);
        member.setMobileNumber(mobileNumber);
        member.setUserSex(userSex);
        member.setCard(card);
        member.setAddr(addr);
        member.setPosition(position);
        return userService.addMember(member);
    }
}
