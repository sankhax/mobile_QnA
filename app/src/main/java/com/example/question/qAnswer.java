package com.example.question;

public class qAnswer {
    private String qkey;
    private String avalue;

    public qAnswer(String qkey, String avalue) {
        this.qkey = qkey;
        this.avalue = avalue;
    }

    public String getQkey() {
        return qkey;
    }

    public void setQkey(String qkey) {
        this.qkey = qkey;
    }

    public String getAvalue() {
        return avalue;
    }

    public void setAvalue(String avalue) {
        this.avalue = avalue;
    }
}
