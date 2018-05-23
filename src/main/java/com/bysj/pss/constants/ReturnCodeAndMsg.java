package com.bysj.pss.constants;

public enum ReturnCodeAndMsg {
    SUCCESS(0,"OK"),
    LOGIN_ERROR(-1,"password wrong"),
    PARA_EMPTY(-2,"paramenter empty"),
    No_DATA_IN_DB(-3,"no data in DB"),
    SAME_DATA_IN_DB(-4,"have same data in DB"),
    DB_CONNECT_ERROR(10001,"DB connect error");


    private ReturnCodeAndMsg(int ret, String msg){
        this.ret=ret;
        this.msg=msg;
    };

    public int ret;
    public String msg;
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
}
