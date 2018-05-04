package com.bysj.pss.model;

import com.bysj.pss.constants.ReturnCodeAndMsg;

public class ReturnValue<T> {
    private int ret;
    private String msg;
    private T data;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ReturnValue (ReturnCodeAndMsg r, T data){
        this.ret=r.getRet();
        this.msg=r.getMsg();
        this.data=data;
    }

    public ReturnValue (ReturnCodeAndMsg r){
        this.ret=r.getRet();
        this.msg=r.getMsg();
        this.data=null;
    }
}
