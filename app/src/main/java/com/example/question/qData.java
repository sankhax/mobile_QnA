package com.example.question;

public class qData {
    private String qkey;
    private String qvalue;

    public  qData(){

    }
    public qData(String qkey, String qvalue) {
        this.qkey = qkey;
        this.qvalue = qvalue;
    }

    public String getQkey() {
        return qkey;
    }

    public void setQkey(String qkey) {
        this.qkey = qkey;
    }

    public String getQvalue() {
        return qvalue;
    }

    public void setQvalue(String qvalue) {
        this.qvalue = qvalue;
    }
}
