package com.bysj.pss.converte;

import com.bysj.pss.model.matadata.EnterpriseDto;
import com.bysj.pss.model.pojo.Enterprise;

public class EnterpriseConv {
    public static Enterprise Converte(EnterpriseDto enterpriseDto){
        if(enterpriseDto==null){
            return null;
        }else{
            Enterprise enterprise = new Enterprise();
            enterprise.setId(enterpriseDto.getId());
            return enterprise;
        }
    }
}
