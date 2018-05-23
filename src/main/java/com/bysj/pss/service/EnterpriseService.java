package com.bysj.pss.service;

import com.bysj.pss.model.ReturnValue;
import com.bysj.pss.model.pojo.Enterprise;

import java.util.List;

public interface EnterpriseService {
    ReturnValue<List> getEnterpriseList(byte type);

    ReturnValue<Integer> insertEnterpriseList(String name,String legalPerson,String contactName,Long contactMobile,
                                              String email, String address,String socialCreditCode,Byte type,
                                              String drugBusiness,String introduction);

    ReturnValue<Enterprise> getEnterpriseById(Integer id);

    ReturnValue<Integer> updateEnterprise(Integer id,String name,String legalPerson,String contactName,Long contactMobile,
                                              String email, String address,String socialCreditCode,Byte type,
                                              String drugBusiness,String introduction);

    ReturnValue<Integer> deleteEnterpriseById(Integer id);

    ReturnValue<List> searchEnterprise(String content);
}
