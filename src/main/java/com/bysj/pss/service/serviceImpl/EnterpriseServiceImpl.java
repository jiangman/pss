package com.bysj.pss.service.serviceImpl;

import com.bysj.pss.constants.ReturnCodeAndMsg;
import com.bysj.pss.controller.UserEnterpriseController;
import com.bysj.pss.mapper.EnterpriseMapper;
import com.bysj.pss.model.ReturnValue;
import com.bysj.pss.model.pojo.Enterprise;
import com.bysj.pss.service.EnterpriseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseServiceImpl implements EnterpriseService{

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    private static Logger logger = LoggerFactory.getLogger(EnterpriseServiceImpl.class);

    @Override
    public ReturnValue<List> getEnterpriseList(byte type) {
        List<Enterprise> enterpriseList = enterpriseMapper.getListEnterprise(type);
        if(enterpriseList==null){
            return new ReturnValue(ReturnCodeAndMsg.No_DATA_IN_DB);
        }else {
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,enterpriseList);
        }
    }

    @Override
    public ReturnValue<Integer> insertEnterpriseList(String name, String legalPerson, String contactName,
                                                     Long contactMobile, String email, String address,
                                                     String socialCreditCode, Byte type, String drugBusiness,
                                                     String introduction) {
        Enterprise enterprise = new Enterprise();
        enterprise.setName(name);
        enterprise.setLegalPerson(legalPerson);
        enterprise.setContactName(contactName);
        enterprise.setContactMobile(contactMobile);
        enterprise.setEmail(email);
        enterprise.setAddress(address);
        enterprise.setSocialCreditCode(socialCreditCode);
        enterprise.setType(type);
        enterprise.setDrugBusiness(drugBusiness);
        enterprise.setIntroduction(introduction);
        Integer res = enterpriseMapper.insertSelective(enterprise);
        if (res.equals(1)){
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,enterprise.getId());
        }else{
            return new ReturnValue(ReturnCodeAndMsg.SAME_DATA_IN_DB,0);
        }
    }

    @Override
    public ReturnValue<Enterprise> getEnterpriseById(Integer id) {
        if(id == null ||id == 0){
            return new ReturnValue(ReturnCodeAndMsg.PARA_EMPTY);
        }
        Enterprise enterprise = enterpriseMapper.selectByPrimaryKey(id);
        if(enterprise==null){
            return new ReturnValue(ReturnCodeAndMsg.No_DATA_IN_DB);
        }else{
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,enterprise);
        }
    }

    @Override
    public ReturnValue<Integer> updateEnterprise(Integer id,String name, String legalPerson, String contactName,
                                                     Long contactMobile, String email, String address,
                                                     String socialCreditCode, Byte type, String drugBusiness,
                                                     String introduction) {
        Enterprise enterprise = new Enterprise();
        enterprise.setId(id);
        enterprise.setName(name);
        enterprise.setLegalPerson(legalPerson);
        enterprise.setContactName(contactName);
        enterprise.setContactMobile(contactMobile);
        enterprise.setEmail(email);
        enterprise.setAddress(address);
        enterprise.setSocialCreditCode(socialCreditCode);
        enterprise.setType(type);
        enterprise.setDrugBusiness(drugBusiness);
        enterprise.setIntroduction(introduction);
        Integer res = enterpriseMapper.updateByPrimaryKeySelective(enterprise);
        if (res.equals(1)){
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,res);
        }else{
            return new ReturnValue(ReturnCodeAndMsg.SAME_DATA_IN_DB,0);
        }
    }

    @Override
    public ReturnValue<Integer> deleteEnterpriseById(Integer id) {
        if(id == null ||id == 0){
            return new ReturnValue(ReturnCodeAndMsg.PARA_EMPTY,0);
        }
        Integer res = enterpriseMapper.deleteByPrimaryKey(id);
        if (res.equals(1)){
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,res);
        }else{
            return new ReturnValue(ReturnCodeAndMsg.SAME_DATA_IN_DB,0);
        }
    }

    @Override
    public ReturnValue<List> searchEnterprise(String content) {
        if(content == null){
            return new ReturnValue(ReturnCodeAndMsg.PARA_EMPTY,0);
        }
        Long phone = 0L;
        try{
            phone = Long.valueOf(content);
        }catch (Exception e){
            logger.warn(e.toString());
        }
        logger.info(content);
        logger.info(String.valueOf(phone));
        List<Enterprise> enterpriseList = enterpriseMapper.searchEnterprise(phone,content);
        if (enterpriseList!=null){
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,enterpriseList);
        }else{
            return new ReturnValue(ReturnCodeAndMsg.No_DATA_IN_DB);
        }
    }
}
