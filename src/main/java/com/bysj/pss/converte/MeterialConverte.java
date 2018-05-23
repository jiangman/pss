package com.bysj.pss.converte;

import com.bysj.pss.model.matadata.MeterialMetadata;
import com.bysj.pss.model.matadata.PrescDro;
import com.bysj.pss.model.pojo.Meterial;
import com.bysj.pss.model.pojo.MeterialOut;
import com.bysj.pss.model.pojo.Prescription;

import java.util.Date;

public class MeterialConverte {

    public static MeterialMetadata Converte(Meterial meterial){
        if (meterial==null){
            return null;
        }else{
            MeterialMetadata meterialMetadata = new MeterialMetadata();
            meterialMetadata.setId(meterial.getId());
            meterialMetadata.setMeterialName(meterial.getMeterialName());
            meterialMetadata.setMeterialOtherName(meterial.getMeterialOtherName());
            meterialMetadata.setEnterpriseId(meterial.getEnterpriseId());
            meterialMetadata.setSaveway(meterial.getSaveway());
            meterialMetadata.setEnterpriseId(meterial.getEnterpriseId());
            meterialMetadata.setNumber(meterial.getNumber());
            meterialMetadata.setNumberNeed(meterial.getNumberNeed());
            switch (meterial.getMeterialSize()){
                case 1:{
                    meterialMetadata.setMeterialSize("毫克");
                    break;
                }
                case 2:{
                    meterialMetadata.setMeterialSize("克");
                    break;
                }
                case 3:{
                    meterialMetadata.setMeterialSize("千克");
                    break;
                }
                case 4:{
                    meterialMetadata.setMeterialSize("吨");
                    break;
                }
            }
            meterialMetadata.setIntroduce(meterial.getIntroduce());
            return meterialMetadata;
        }
    }

    public static MeterialOut MeterialOutConverte(PrescDro prescDro, Integer medicineProduceId,Integer num, Date createTime){
        MeterialOut meterialOut = new MeterialOut();
        meterialOut.setMedicineProduceFk(medicineProduceId);
        meterialOut.setMeterialFk(prescDro.getId());
        meterialOut.setTime(createTime);
        meterialOut.setNumber(prescDro.getUnitNeed()*num);
        return meterialOut;
    }
}
