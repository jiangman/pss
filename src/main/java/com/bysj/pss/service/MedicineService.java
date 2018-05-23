package com.bysj.pss.service;

import com.bysj.pss.model.ReturnValue;
import com.bysj.pss.model.matadata.PrescDro;
import com.bysj.pss.model.pojo.MedicineSale;
import com.bysj.pss.model.pojo.Meterial;
import com.bysj.pss.model.pojo.MeterialOut;
import com.bysj.pss.model.pojo.Prescription;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface MedicineService {
    ReturnValue<List> getAllMedicine();

    ReturnValue<Integer> insert(String medicineName,String medicineOtherName,String licenseNo,
                                Double tradePrice,Double retailPrice,String size,Integer sizeNum,
                                Byte validityPeriod,String introduce);

    ReturnValue<List> search(String content);

    ReturnValue<Integer> addProduce(String medicineProduceId, Integer medicineFk,Integer produceManFk,
                                    Date createTime,Integer num);

    ReturnValue<List> getAllProduce();

    ReturnValue<Integer> addMedicineSale(MedicineSale medicineSale);

    ReturnValue<List> getAllSale();

    ReturnValue<Integer> updateSale(Integer id,Byte status,Date successDate);
}
