package com.bysj.pss.service.serviceImpl;

import com.bysj.pss.constants.ReturnCodeAndMsg;
import com.bysj.pss.mapper.MedicineMapper;
import com.bysj.pss.mapper.MedicineProduceMapper;
import com.bysj.pss.mapper.MedicineSaleMapper;
import com.bysj.pss.model.ReturnValue;
import com.bysj.pss.model.pojo.Medicine;
import com.bysj.pss.model.pojo.MedicineProduce;
import com.bysj.pss.model.pojo.MedicineSale;
import com.bysj.pss.service.MedicineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineMapper medicineMapper;
    @Autowired
    private MedicineProduceMapper medicineProduceMapper;
    @Autowired
    private MedicineSaleMapper medicineSaleMapper;

    private static Logger logger = LoggerFactory.getLogger(MedicineServiceImpl.class);


    @Override
    public ReturnValue<List> getAllMedicine() {
        List<Medicine> allMedicine = medicineMapper.getAllMedicine();
        if(allMedicine==null){
            return new ReturnValue(ReturnCodeAndMsg.No_DATA_IN_DB);
        }else {
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,allMedicine);
        }
    }

    @Override
    public ReturnValue<Integer> insert(String medicineName,String medicineOtherName,String licenseNo,
                                       Double tradePrice,Double retailPrice,String size,Integer sizeNum,
                                       Byte validityPeriod,String introduce){
        Medicine medicine = new Medicine();
        medicine.setMedicineName(medicineName);
        medicine.setMedicineOtherName(medicineOtherName);
        medicine.setLicenseNo(licenseNo);
        medicine.setTradePrice(tradePrice);
        medicine.setRetailPrice(retailPrice);
        medicine.setSize(size);
        medicine.setSizeNum(sizeNum);
        medicine.setValidityPeriod(validityPeriod);
        medicine.setIntroduce(introduce);
        int res = medicineMapper.insertSelective(medicine);
        if(res==0){
            return new ReturnValue(ReturnCodeAndMsg.DB_CONNECT_ERROR,0);
        }else{
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,res);
        }
    }

    @Override
    public ReturnValue<List> search(String content) {
        if(content == null){
            return new ReturnValue(ReturnCodeAndMsg.PARA_EMPTY,0);
        }
        List<Medicine> medicineList = medicineMapper.search(content);
        if (medicineList!=null){
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,medicineList);
        }else{
            return new ReturnValue(ReturnCodeAndMsg.No_DATA_IN_DB);
        }
    }

    @Override
    public ReturnValue<Integer> addProduce(String medicineProduceId, Integer medicineFk,
                                           Integer produceManFk, Date createTime, Integer num) {
        if(medicineProduceId==null||medicineFk==null||produceManFk==null||createTime==null||num==null){
            logger.error("addProduce get Param Empty");
            return new ReturnValue(ReturnCodeAndMsg.PARA_EMPTY,0);
        }
        MedicineProduce medicineProduce = new MedicineProduce();
        medicineProduce.setMedicineFk(medicineFk);
        medicineProduce.setCreateTime(createTime);
        medicineProduce.setMedicineProduceId(medicineProduceId);
        medicineProduce.setNum(num);
        medicineProduce.setProduceManFk(produceManFk);
        //添加药品生产记录
        int res = medicineProduceMapper.insertSelective(medicineProduce);
        if (res==0) {
            logger.error("DB connect error");
            return new ReturnValue(ReturnCodeAndMsg.DB_CONNECT_ERROR,0);
        }else{
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,medicineProduce.getId());
        }
    }

    @Override
    public ReturnValue<List> getAllProduce() {
        List<MedicineProduce> allMedicineProduce = medicineProduceMapper.getAllMedicineProduce();
        if(allMedicineProduce==null){
            return new ReturnValue(ReturnCodeAndMsg.No_DATA_IN_DB);
        }else {
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,allMedicineProduce);
        }
    }

    @Override
    public ReturnValue<Integer> addMedicineSale(MedicineSale medicineSale) {
        if (medicineSale==null){
            return new ReturnValue(ReturnCodeAndMsg.PARA_EMPTY,0);
        }
        Integer res = medicineSaleMapper.insertSelective(medicineSale);
        if(res==0){
            return new ReturnValue(ReturnCodeAndMsg.DB_CONNECT_ERROR,0);
        }

        int res2 =medicineProduceMapper.decreaseNumByPrimaryKey(Integer.valueOf(medicineSale.getMedicineProduceFk()),medicineSale.getNum());
        if(res2==0){
            return new ReturnValue(ReturnCodeAndMsg.DB_CONNECT_ERROR,0);
        }else {
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS, medicineSale.getId());
        }
    }

    @Override
    public ReturnValue<List> getAllSale() {
        List<MedicineSale> allMedicineSale = medicineSaleMapper.getAllSale();
        if(allMedicineSale==null){
            return new ReturnValue(ReturnCodeAndMsg.No_DATA_IN_DB);
        }else {
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,allMedicineSale);
        }
    }

    @Override
    public ReturnValue<Integer> updateSale(Integer id, Byte status,Date successDate) {
        if(id==null||status==null){
            return new ReturnValue(ReturnCodeAndMsg.No_DATA_IN_DB);
        }
        int res1 = medicineSaleMapper.updateStatus(id,status,successDate);
        if(res1==0){
            return new ReturnValue(ReturnCodeAndMsg.DB_CONNECT_ERROR,0);
        }

        if(status!=3) {
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,res1);
        }
        MedicineSale medicineSale = medicineSaleMapper.selectByPrimaryKey(id);
        int res2=medicineProduceMapper.decreaseNumByPrimaryKey(Integer.valueOf(medicineSale.getMedicineProduceFk()),
                (medicineSale.getNum()*-1));
        if (res2==0){
            return new ReturnValue(ReturnCodeAndMsg.DB_CONNECT_ERROR,0);
        }else {
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,res2);
        }

    }
}
