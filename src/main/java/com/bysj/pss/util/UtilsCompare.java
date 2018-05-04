package com.bysj.pss.util;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * create by lanxuewei in 2018/3/9
 */
public class UtilsCompare {

    /**
     * 对比两个对象是否相同
     */

    public static  boolean isEqual(Object o1,Object o2){
        if (o1 == null) {
            if (o2 == null) {
                return true;
            } else {
                return false;
            }
        }else{
            return o1.equals(o2);
        }
    }

    /**
     * 对比两个对象中属性值是否相等
     */
    public static boolean isPropertiesEquals(Object o1, Object o2) {
        if (o1 == null){
            if (o2 == null){
                return true;
            } else{
                return false;
            }
        } else {
            if (o2 == null){
                return false;
            } else {  //对实例中的属性值进行对比
                Field[] fields = o1.getClass().getDeclaredFields();  //获得所有属性值
                for (Field field : fields){
                    field.setAccessible(true);             //设置对象属性的可见行，访问私有属性
                    try {
                        Object fieldObj1 = field.get(o1);  //获取该o1和o2该字段的具体属性值
                        Object fieldObj2 = field.get(o2);
                        if (isEqual(fieldObj1,fieldObj2)){  //属性值对比,相同则跳过此次循环
                            continue;
                        } else {  //某个属性值不同则false
                            return false;
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }
        }
    }

    /**
     * 对比两个对象的属性值是否相等，ignoreProperties数组为忽略比较的属性值集合
     */
    public static boolean isPropertiesEquals(Object o1, Object o2, Set<String> ignoreProperties){
        if (o1 == null){
            if (o2 == null){
                return true;
            } else {
                return false;
            }
        } else {
            if (o2 == null){
                return false;
            } else {  //对实例中属性值进行对比
                Field[] fields = o1.getClass().getDeclaredFields();  //获得所有属性值
                for (Field field : fields) {
                    field.setAccessible(true);                       //设置对象属性的可见行，访问私有属性
                    try {
                        if (ignoreProperties.contains(field.getName())) {     //遇到忽略比较的属性值，跳过
                            continue;
                        } else {
                            Object fieldObj1 = field.get(o1);
                            Object fieldObj2 = field.get(o2);
                            if (isEqual(fieldObj1, fieldObj2)) {  //属性值相同，跳过
                                continue;
                            } else {
                                return false;
                            }
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }

        }
    }
}
