package com.bysj.pss.service.serviceImpl;

import com.bysj.pss.constants.ReturnCodeAndMsg;
import com.bysj.pss.converte.MeterialConverte;
import com.bysj.pss.converte.PrescConv;
import com.bysj.pss.mapper.MeterialMapper;
import com.bysj.pss.mapper.MeterialOrderMapper;
import com.bysj.pss.mapper.MeterialOutMapper;
import com.bysj.pss.mapper.PrescriptionMapper;
import com.bysj.pss.model.ReturnValue;
import com.bysj.pss.model.matadata.MeterialMetadata;
import com.bysj.pss.model.matadata.PrescDro;
import com.bysj.pss.model.pojo.Meterial;
import com.bysj.pss.model.pojo.MeterialOrder;
import com.bysj.pss.model.pojo.MeterialOut;
import com.bysj.pss.model.pojo.Prescription;
import com.bysj.pss.service.MeterialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MeterialServiceImpl implements MeterialService {

    @Autowired
    private MeterialMapper meterialMapper;

    @Autowired
    private MeterialOrderMapper meterialOrderMapper;

    @Autowired
    private MeterialOutMapper meterialOutMapper;

    @Autowired
    private PrescriptionMapper prescriptionMapper;

    private static Logger logger = LoggerFactory.getLogger(MeterialServiceImpl.class);

    /**
     * 获得所有药材列表
     * @return
     */
    @Override
    public ReturnValue<List> getAllMeterial() {
        List<Meterial> allMeterials = meterialMapper.getAllMeterial();
        if(allMeterials==null){
            return new ReturnValue(ReturnCodeAndMsg.No_DATA_IN_DB,null);
        }else {
            List<MeterialMetadata> allMeterialMetadata = new ArrayList<>();
            for(Meterial meterial:allMeterials ){
                allMeterialMetadata.add(MeterialConverte.Converte(meterial));
            }
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,allMeterialMetadata);
        }
    }

    /**
     * 获得一种药材的所有信息
     * @return
     */
    @Override
    public ReturnValue<Meterial> getMeterial(Integer id) {
        if(id==null) {
            return new ReturnValue(ReturnCodeAndMsg.PARA_EMPTY);
        }
        Meterial meterial = meterialMapper.selectByPrimaryKey(id);
        if (meterial==null){
            return new ReturnValue(ReturnCodeAndMsg.DB_CONNECT_ERROR);
        }else{
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,meterial);
        }

    }

    /**
     * 更新药材基本信息
     * @param meterial
     * @return
     */
    @Override
    public ReturnValue<Integer> updateMeterial(Meterial meterial) {
        if(meterial==null) {
            return new ReturnValue(ReturnCodeAndMsg.PARA_EMPTY);
        }
        Meterial meterial1 =meterialMapper.selectByPrimaryKey(meterial.getId());
        if (meterial1==null){
            return new ReturnValue(ReturnCodeAndMsg.DB_CONNECT_ERROR);
        }
        //单位修改转换
        int num = meterial1.getMeterialSize()-meterial.getMeterialSize();
        while (num!=0){
            if(num>0){
                meterial.setNumber(meterial1.getNumber()*1000);
                num--;
            }else{
                meterial.setNumber(meterial1.getNumber()/1000);
                num++;
            }
        }
        int res = meterialMapper.updateByPrimaryKeySelective(meterial);
        if(res==0){
            return new ReturnValue(ReturnCodeAndMsg.DB_CONNECT_ERROR);
        }else{
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,res);
        }
    }

    /**
     * 添加药材
     * @param meterialName
     * @param meterialOtherName
     * @param meterialSize
     * @param saveway
     * @param introduction
     * @return
     */
    @Override
    public ReturnValue<Integer> insert(String meterialName, String meterialOtherName, Byte meterialSize, String saveway, String introduction) {
        if(meterialName==null||meterialSize==null||saveway==null){
            return new ReturnValue<Integer>(ReturnCodeAndMsg.PARA_EMPTY,0);
        }
        Meterial meterial = new Meterial();
        meterial.setMeterialName(meterialName);
        meterial.setMeterialOtherName(meterialOtherName);
        meterial.setMeterialSize(meterialSize);
        meterial.setSaveway(saveway);
        meterial.setIntroduce(introduction);
        int res = meterialMapper.insertSelective(meterial);
        if(res==0){
            return new ReturnValue(ReturnCodeAndMsg.DB_CONNECT_ERROR,0);
        }else{
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,res);
        }
    }

    /**
     * 模糊搜索药材
     * @param content
     * @return
     */
    @Override
    public ReturnValue<List> search(String content) {
        if(content == null){
            return new ReturnValue(ReturnCodeAndMsg.PARA_EMPTY,0);
        }
        List<Meterial> meterialList = meterialMapper.search(content);
        if (meterialList!=null){
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,meterialList);
        }else{
            return new ReturnValue(ReturnCodeAndMsg.No_DATA_IN_DB);
        }
    }

    /**
     * 根据药材主键、药材批发商或入库单号进行搜索
     * @param content
     * @return
     */
    @Override
    public ReturnValue<List> searchOrder(Integer content,Integer type) {
        if(content == null){
            return new ReturnValue(ReturnCodeAndMsg.PARA_EMPTY,0);
        }
        List<MeterialOrder> meterialOrderList = meterialOrderMapper.searchOrder(content,type);
        if (meterialOrderList!=null){
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,meterialOrderList);
        }else{
            return new ReturnValue(ReturnCodeAndMsg.No_DATA_IN_DB);
        }
    }

    /**
     * 添加药材入库记录
     * @param meterialFk
     * @param enterpriseId
     * @param operationDate
     * @param serialNo
     * @param salesman
     * @param unitPrice
     * @param number
     * @param size
     * @param sremark
     * @return
     */
    @Override
    public ReturnValue<Integer> insertOrder(Integer meterialFk, Integer enterpriseId, Date operationDate,
                                            String serialNo, Integer salesman, Double unitPrice, Double number,
                                            Byte size, String sremark) {
        MeterialOrder meterialOrder = new MeterialOrder();
        meterialOrder.setMeterialFk(meterialFk);
        meterialOrder.setEnterpriseId(enterpriseId);
        meterialOrder.setOperationDate(operationDate);
        meterialOrder.setSerialNo(serialNo);
        meterialOrder.setSalesman(salesman);
        meterialOrder.setUnitPrice(unitPrice);
        meterialOrder.setNumber(number);
        meterialOrder.setSize(size);
        meterialOrder.setSremark(sremark);
        int res1 = meterialOrderMapper.insertSelective(meterialOrder);
        int res2 = meterialMapper.updateNum(meterialFk,number);
        if(res1==0||res2==0){
            return new ReturnValue(ReturnCodeAndMsg.DB_CONNECT_ERROR,0);
        }else{
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,1);
        }
    }

    /**
     * 获得所有药材入库记录
     * @return
     */
    @Override
    public ReturnValue<MeterialOrder> getAllOrder() {
        List<MeterialOrder> allMeterialOrder = meterialOrderMapper.getAllOrder();
        if(allMeterialOrder==null){
            return new ReturnValue(ReturnCodeAndMsg.No_DATA_IN_DB,null);
        }else {
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,allMeterialOrder);
        }
    }

    /**
     * 获得一种药品的配方清单
     * @param id
     * @return
     */
    @Override
    public ReturnValue<List> getPrescDro(Integer id) {
        if(id==null){
            return new ReturnValue(ReturnCodeAndMsg.PARA_EMPTY,0);
        }
        List<Prescription> prescriptionList = prescriptionMapper.getPrescription(id);
        List<Meterial> meterialList = meterialMapper.getAllMeterial();
        if (prescriptionList==null||meterialList==null){
            return new ReturnValue(ReturnCodeAndMsg.No_DATA_IN_DB,null);
        }else {
            List<PrescDro> prescDros = new ArrayList<>();
            for (Prescription prescription:prescriptionList){
                for (Meterial meterial:meterialList){
                    if(prescription.getMeterialFk().equals(meterial.getId())){
                        prescDros.add(PrescConv.Converte(meterial,prescription));
                        continue;
                    }
                }
            }
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,prescDros);
        }
    }

    /**
     * 批量添加药材的出库记录
     * @param medicineProduceId
     * @param medicineFk
     * @param num
     * @param createTime
     * @return
     */
    @Override
    public ReturnValue<Integer> insertMeterialOut(Integer medicineProduceId, Integer medicineFk, Integer num, Date createTime) {
        List<PrescDro> prescDros = this.getPrescDro(medicineFk).getData();
        List<MeterialOut> meterialOuts = new ArrayList<>();
        for(PrescDro prescDro:prescDros){
            meterialOuts.add(MeterialConverte.MeterialOutConverte(prescDro,medicineProduceId,num,createTime));
        }
        int res1 = meterialOutMapper.insertMeterialOutList(meterialOuts);
        logger.info(String.valueOf(res1));
        if(res1!=meterialOuts.size()){
            return new ReturnValue(ReturnCodeAndMsg.DB_CONNECT_ERROR,0);
        }
        int res2 = meterialMapper.updateMeterialList(meterialOuts);
        if(res2 != meterialOuts.size()){
            return new ReturnValue(ReturnCodeAndMsg.DB_CONNECT_ERROR,0);
        }else{
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,res2);
        }
    }

    /**
     * 获得所有药材的出库记录
     * @return
     */
    @Override
    public ReturnValue<List> getAllMeterialOut() {
        List<MeterialOut> meterialOuts = meterialOutMapper.getAllMeterialOut();
        if(meterialOuts==null){
            return new ReturnValue(ReturnCodeAndMsg.No_DATA_IN_DB);
        }else {
            return new ReturnValue(ReturnCodeAndMsg.SUCCESS,meterialOuts);
        }
    }
}
