package com.bysj.pss.controller;

import com.bysj.pss.model.ReturnValue;
import com.bysj.pss.model.pojo.Meterial;
import com.bysj.pss.model.pojo.MeterialOrder;
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
public class MeterialController {

    private static Logger logger = LoggerFactory.getLogger(MeterialController.class);

    @Autowired
    private MeterialService meterialService;

    //获得所有药材的数据
    @RequestMapping(value="/meterials",method= RequestMethod.GET)
    public ReturnValue<List> getMeterialList (){
        logger.info("获取所有的药材数据");
        return meterialService.getAllMeterial();
    }

    //插入药材数据
    @RequestMapping(value="/meterial",method= RequestMethod.POST)
    public ReturnValue<Integer> insertMeterial(
            @RequestParam String meterialName,
            @RequestParam String meterialOtherName,
            @RequestParam byte meterialSize,
            @RequestParam String saveway,
            @RequestParam String introduction){
        logger.info("调用药材插入接口,插入数据");
        return meterialService.insert(meterialName,meterialOtherName,meterialSize,saveway,introduction);
    }

    //模糊搜索接口
    @RequestMapping(value="/meterial",method= RequestMethod.GET)
    public ReturnValue<List> searchMeterial(
            @RequestParam("content") String content){
        logger.info("调用药材搜索接口,搜索数据"+content);
        return meterialService.search(content);
    }

    /**
     * 获得特定id的药材数据
     * @param id
     * @return
     */
    @RequestMapping(value="/meterial/{id}",method= RequestMethod.GET)
    public ReturnValue<Meterial> getMeterial(
            @PathVariable Integer id){
        logger.info("搜索特定id的药材信息"+id);
        return meterialService.getMeterial(id);
    }

    /**
     * 更新药材数据
     * @param meterialName
     * @param meterialOtherName
     * @param meterialSize
     * @param saveway
     * @param introduction
     * @return
     */
    @RequestMapping(value="/meterial/{id}",method= RequestMethod.POST)
    public ReturnValue<Integer> updateMeterial(
            @PathVariable Integer id,
            @RequestParam String meterialName,
            @RequestParam String meterialOtherName,
            @RequestParam Byte meterialSize,
            @RequestParam String saveway,
            @RequestParam String introduction){
        logger.info("调用药材插入接口,插入数据");
        Meterial meterial = new Meterial();
        meterial.setId(id);
        meterial.setMeterialName(meterialName);
        meterial.setMeterialOtherName(meterialOtherName);
        meterial.setMeterialSize(meterialSize);
        meterial.setSaveway(saveway);
        meterial.setIntroduce(introduction);
        return meterialService.updateMeterial(meterial);
    }



    //药材订单插入接口
    @RequestMapping(value="/meterialOrder",method= RequestMethod.POST)
    public ReturnValue<Integer> insertMeterialOrder(
            @RequestParam Integer meterialFk,
            @RequestParam Integer enterpriseId,
            @RequestParam String operationDate,
            @RequestParam String serialNo,
            @RequestParam Integer salesman,
            @RequestParam Double unitPrice,
            @RequestParam Double number,
            @RequestParam Byte size,
            @RequestParam String sremark) throws ParseException {
        operationDate=operationDate.substring(0,10);
        logger.info("调用药材入库接口,插入数据"+operationDate);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
        String dstr="2008-4-24";
        Date date=sdf.parse(operationDate);
        return meterialService.insertOrder(meterialFk,enterpriseId,date,serialNo,salesman,unitPrice,
                number,size,sremark);
    }

    //药材订单接口
    @RequestMapping(value="/meterialOrder",method= RequestMethod.GET)
    public ReturnValue<MeterialOrder> allMeterialOrder(){
        return meterialService.getAllOrder();
    }

    //药材订单接口
    @RequestMapping(value="/meterialOrder/search",method= RequestMethod.GET)
    public ReturnValue<List> searchOrder(
            @RequestParam Integer content,
            @RequestParam Integer type){
        return meterialService.searchOrder(content,type);
    }

    //药品配方获取接口
    @RequestMapping(value="/prescription/{id}",method= RequestMethod.GET)
    public ReturnValue<List> getPrescDro(@PathVariable("id") Integer id){
        return meterialService.getPrescDro(id);
    }

    //药材出库记录清单接口
    @RequestMapping(value="/meterialOut",method= RequestMethod.GET)
    public ReturnValue<List> allMeterialOut(){
        return meterialService.getAllMeterialOut();
    }

}
