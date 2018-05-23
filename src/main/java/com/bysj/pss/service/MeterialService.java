package com.bysj.pss.service;

import com.bysj.pss.model.ReturnValue;
import com.bysj.pss.model.matadata.PrescDro;
import com.bysj.pss.model.pojo.Meterial;
import com.bysj.pss.model.pojo.MeterialOrder;
import com.bysj.pss.model.pojo.MeterialOut;

import java.util.Date;
import java.util.List;

public interface MeterialService {
    ReturnValue<List> getAllMeterial();

    ReturnValue<Meterial> getMeterial(Integer id);

    ReturnValue<Integer> insert(String meterialName, String meterialOtherName, Byte meterialSize, String saveway, String introduction);

    ReturnValue<List> search(String content);

    ReturnValue<Integer> updateMeterial(Meterial meterial);


    /**
     * 药材入库记录模糊搜索
     * @param content
     * @return
     */
    ReturnValue<List> searchOrder(Integer content,Integer type);

    ReturnValue<Integer> insertOrder(Integer meterialFk,Integer enterpriseId,Date operationDate,
                                     String serialNo,Integer salesman,Double unitPrice,Double number,
                                     Byte size, String sremark);

    ReturnValue<MeterialOrder> getAllOrder();



    //通过药品主键获取，药品配方信息
    ReturnValue<List> getPrescDro(Integer id);

    //批量插入药材出库数据
    ReturnValue<Integer> insertMeterialOut(Integer medicineProduceId, Integer medicineFk, Integer num, Date createTime);

    //获得所有药材出库记录
    ReturnValue<List> getAllMeterialOut();

}
