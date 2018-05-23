package com.bysj.pss.util;

import java.security.MessageDigest;

public class UtilSize {
    public static Double equalSize (Double num,Integer size1,Integer size2) {
        while (size1!=size2){
            if(size1>size2){
                num*=1000;
                size1--;
            }else{
                num/=1000;
                size1++;
            }
        }
        return num;
    }
}
