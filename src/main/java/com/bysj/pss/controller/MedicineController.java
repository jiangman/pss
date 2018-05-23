package com.bysj.pss.controller;

import com.bysj.pss.model.ReturnValue;
import com.bysj.pss.model.pojo.MedicineSale;
import com.bysj.pss.service.MedicineService;
import com.bysj.pss.service.MeterialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/bysj/pss")
public class MedicineController {

    private static Logger logger = LoggerFactory.getLogger(MedicineController.class);

    @Autowired
    private MedicineService medicineService;

    @Autowired
    private MeterialService meterialService;

    //获得所有药品的数据
    @RequestMapping(value="/medicines",method= RequestMethod.GET)
    public ReturnValue<List> getMedicineList (){
        logger.info("获取所有的药材数据");
        return medicineService.getAllMedicine();
    }

    //插入药材数据
    @RequestMapping(value="/medicine",method= RequestMethod.POST)
    public ReturnValue<Integer> insertEnterprise(
            @RequestParam String medicineName,
            @RequestParam String medicineOtherName,
            @RequestParam String licenseNo,
            @RequestParam Double tradePrice,
            @RequestParam Double retailPrice,
            @RequestParam String size,
            @RequestParam Integer sizeNum,
            @RequestParam Byte validityPeriod,
            @RequestParam String introduce){
        logger.info("调用药材插入接口,插入数据");
        return medicineService.insert(medicineName,medicineOtherName,licenseNo,tradePrice,retailPrice,
                size,sizeNum,validityPeriod,introduce);
    }

    //模糊搜索接口
    @RequestMapping(value="/medicines/{content}",method= RequestMethod.GET)
    public ReturnValue<List> searchEnterprise(
            @PathVariable("content") String content){
        logger.info("调用药品搜索接口,搜索数据"+content);
        return medicineService.search(content);
    }


    //药品生产接口
    @RequestMapping(value="/medicineProduce",method= RequestMethod.POST)
    public ReturnValue<Integer> produceMedicine(
            @RequestParam String medicineProduceId,
            @RequestParam Integer medicineFk,
            @RequestParam Integer produceManFk,
            @RequestParam String createTime,
            @RequestParam Integer num) throws ParseException {
        createTime=createTime.substring(0,10);
        logger.info("调用药材入库接口,插入数据"+createTime);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
        Date date=sdf.parse(createTime);
        ReturnValue<Integer> ret1 = medicineService.addProduce(medicineProduceId,medicineFk,produceManFk,date,num);
        if(ret1.getRet()!=0){
            return ret1;
        }
        return meterialService.insertMeterialOut(ret1.getData(), medicineFk, num, date);
    }

    //获得所有生产记录
    @RequestMapping(value="/medicineProduce",method= RequestMethod.GET)
    public ReturnValue<List> getAllMedicineProduce(){
        return medicineService.getAllProduce();
    }

    //添加生产记录
    @RequestMapping(value = "/medicineSale",method = RequestMethod.POST)
    public ReturnValue<Integer> addMedicineSale(
            @RequestParam Integer enterpirsId,
            @RequestParam String medicineProduceFk,
            @RequestParam Integer num,
            @RequestParam String contractCode,
            @RequestParam Integer saleMaleFk,
            @RequestParam String deliveryAddress,
            @RequestParam Byte ransportType,
            @RequestParam String deliveryDate) throws ParseException {
        MedicineSale medicineSale = new MedicineSale();
        medicineSale.setEnterpirsId(enterpirsId);
        medicineSale.setMedicineProduceFk(medicineProduceFk);
        medicineSale.setNum(num);
        medicineSale.setContractCode(contractCode);
        medicineSale.setSaleMaleFk(saleMaleFk);
        medicineSale.setDeliveryAddress(deliveryAddress);
        medicineSale.setRansportType(ransportType);
        deliveryDate=deliveryDate.substring(0,10);
        logger.info("调用药材入库接口,插入数据"+deliveryDate);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
        Date date=sdf.parse(deliveryDate);
        medicineSale.setDeliveryDate(date);
        return medicineService.addMedicineSale(medicineSale);
    }

    //获得所有生产记录
    @RequestMapping(value="/medicineSaleList",method= RequestMethod.GET)
    public ReturnValue<List> getAllSale(){
        return medicineService.getAllSale();
    }

    //更新生产记录状态
    @RequestMapping(value="/medicineSale/{id}",method= RequestMethod.POST)
    public ReturnValue<Integer> updateSale(
            @PathVariable("id") Integer id,
            @RequestParam Byte status,
            @RequestParam String successDate) throws ParseException {
        successDate=successDate.substring(0,10);
        logger.info("调用销售修改接口"+successDate);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
        Date date=sdf.parse(successDate);
        return medicineService.updateSale(id,status,date);
    }
}
