package com.shengxian.model;

import java.util.Date;

public class youhuicard {
    private String card_id;
    private String card_neirong;
    private float price_fanwei;
    private float reduce;
    private Date start_date;
    private Date end_date;

    public float getPrice_fanwei() {
        return price_fanwei;
    }

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

    public float getReduce() {
        return reduce;
    }

    public void setReduce(float reduce) {
        this.reduce = reduce;
    }

    public void setPrice_fanwei(float price_fanwei) {
        this.price_fanwei = price_fanwei;
    }

    public String getCard_neirong() {
        return card_neirong;
    }

    public void setCard_neirong(String card_neirong) {
        this.card_neirong = card_neirong;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }
}
