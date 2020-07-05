package com.shengxian.model;

import java.util.Date;
import java.text.*;

public class yonghujiemian_youhui {
    private String youhuicard_id;
    private String youhuineirong;
    private float shiyong_money;
    private float reduce_money;
    private Date start_date;
    private Date end_date;

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public static final String[] tableTitles={"优惠卡编号","优惠内容","适用金额","减免金额","起始日期","截至日期"};

    public float getReduce_money() {
        return reduce_money;
    }

    public void setReduce_money(float reduce_money) {
        this.reduce_money = reduce_money;
    }

    public float getShiyong_money() {
        return shiyong_money;
    }

    public void setShiyong_money(float shiyong_money) {
        this.shiyong_money = shiyong_money;
    }

    public String getYouhuineirong() {
        return youhuineirong;
    }

    public void setYouhuineirong(String youhuineirong) {
        this.youhuineirong = youhuineirong;
    }

    public String getYouhuicard_id() {
        return youhuicard_id;
    }

    public void setYouhuicard_id(String youhuicard_id) {
        this.youhuicard_id = youhuicard_id;
    }

    public String gettime(Date time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  sdf.format(time);
    }

    public String getcell(int col){
        if (col==0) return this.getYouhuicard_id();
        else if (col==1) return this.getYouhuineirong();
        else if(col==2) return Float.toString(this.getShiyong_money());
        else if(col==3) return Float.toString(this.getReduce_money());
        else if(col==4) return gettime(start_date);
        else if(col==5) return gettime(end_date);
        else return "";
    }

}
