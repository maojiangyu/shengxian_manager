package com.shengxian.model;

import java.math.BigInteger;

public class shangpin {
    private String shangpin_id;
    private String phangpin_name;
    private String leibie_id;
    private float price;
    private float VIP_price;
    private float number;
    private String guige;
    private String xiangqing;

    public String getLeibie_id() {
        return leibie_id;
    }

    public void setLeibie_id(String leibie_id) {
        this.leibie_id = leibie_id;
    }



    public String getXiangqing() {
        return xiangqing;
    }

    public void setXiangqing(String xiangqing) {
        this.xiangqing = xiangqing;
    }

    public String getGuige() {
        return guige;
    }

    public void setGuige(String guige) {
        this.guige = guige;
    }

    public float getNumber() {
        return number;
    }

    public void setNumber(float number) {
        this.number = number;
    }

    public float getVIP_price() {
        return VIP_price;
    }

    public void setVIP_price(float VIP_price) {
        this.VIP_price = VIP_price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPhangpin_name() {
        return phangpin_name;
    }

    public void setPhangpin_name(String phangpin_name) {
        this.phangpin_name = phangpin_name;
    }

    public String getShangpin_id() {
        return shangpin_id;
    }

    public void setShangpin_id(String shangpin_id) {
        this.shangpin_id = shangpin_id;
    }
}
