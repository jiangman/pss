package com.bysj.pss.converte;

import com.bysj.pss.model.matadata.PrescDro;
import com.bysj.pss.model.pojo.Meterial;
import com.bysj.pss.model.pojo.MeterialOut;
import com.bysj.pss.model.pojo.Prescription;

public class PrescConv {
    public static PrescDro Converte(Meterial meterial, Prescription prescription){
        if(meterial==null||prescription==null){
            return null;
        }else{
            PrescDro prescDro = new PrescDro();
            prescDro.setId(meterial.getId());
            prescDro.setName(meterial.getMeterialName());
            prescDro.setNumber(meterial.getNumber());
            prescDro.setNeed(prescription.getNum());
            switch (meterial.getMeterialSize()){
                case 1:{
                    prescDro.setSize("毫克");
                    break;
                }
                case 2:{
                    prescDro.setSize("克");
                    break;
                }
                case 3:{
                    prescDro.setSize("千克");
                    break;
                }
                case 4:{
                    prescDro.setSize("吨");
                    break;
                }
            }
            prescDro.setUnitNeed(prescription.getNum());
            return prescDro;
        }
    }
}
