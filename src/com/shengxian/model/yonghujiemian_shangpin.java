package com.shengxian.model;



public class yonghujiemian_shangpin {
    public static final String[] tableTitles={"商品编号","商品名称","价格","会员价","库存","规格","销量"};

    private String shangpin_id;
    private String shangpin_name;
    private float price;
    private float VIP_price;
    private float number;
    private String guige;
    private float xiaoliang;

    public float getXiaoliang() {
        return xiaoliang;
    }

    public void setXiaoliang(float xiaoliang) {
        this.xiaoliang = xiaoliang;
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

    public String getShangpin_name() {
        return shangpin_name;
    }

    public void setShangpin_name(String shangpin_name) {
        this.shangpin_name = shangpin_name;
    }

    public String getShangpin_id() {
        return shangpin_id;
    }

    public void setShangpin_id(String shangpin_id) {
        this.shangpin_id = shangpin_id;
    }

    public String getCell(int col){
        if(col==0) return this.getShangpin_id();
        else if(col==1) return this.getShangpin_name();
        else if(col==2) return Float.toString(this.getPrice());
        else if(col==3) return Float.toString(this.getVIP_price());
        else if(col==4) return Float.toString(this.getNumber());
        else if (col==5) return this.getGuige();
        else if (col==6) return Float.toString(this.getXiaoliang());
        else return "";
    }

}
