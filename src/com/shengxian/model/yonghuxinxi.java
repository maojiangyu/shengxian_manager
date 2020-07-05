package com.shengxian.model;

import java.util.Date;

public class yonghuxinxi {
    public static yonghuxinxi currentLoginuser = null;

    private String yonghu_id;
    private String name;
    private String sex;
    private String mima;
    private String phonenumber;
    private String mail;
    private String souzaicity;
    private Date zhuce_date;
    private boolean VIP = false;
    private Date VIP_end_date;

    public Date getVIP_end_date() {
        return VIP_end_date;
    }

    public void setVIP_end_date(Date VIP_end_date) {
        this.VIP_end_date = VIP_end_date;
    }

    public boolean isVIP() {
        return VIP;
    }

    public void setVIP(boolean VIP) {
        this.VIP = VIP;
    }

    public Date getZhuce_date() {
        return zhuce_date;
    }

    public void setZhuce_date(Date zhuce_date) {
        this.zhuce_date = zhuce_date;
    }

    public String getSouzaicity() {
        return souzaicity;
    }

    public void setSouzaicity(String souzaicity) {
        this.souzaicity = souzaicity;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getMima() {
        return mima;
    }

    public void setMima(String mima) {
        this.mima = mima;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYonghu_id() {
        return yonghu_id;
    }

    public void setYonghu_id(String yonghu_id) {
        this.yonghu_id = yonghu_id;
    }
}
