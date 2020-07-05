package com.shengxian.model;

public class manager_shangpin {
    public static final String[] tableTitles={"商品编号","商品名称","规格","库存","价格"};
    private String shanpin_id;
    private String shangpin_name;
    private String guige;
    private float kucun;
    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getKucun() {
        return kucun;
    }

    public void setKucun(float kucun) {
        this.kucun = kucun;
    }

    public String getGuige() {
        return guige;
    }

    public void setGuige(String guige) {
        this.guige = guige;
    }

    public String getShangpin_name() {
        return shangpin_name;
    }

    public void setShangpin_name(String shangpin_name) {
        this.shangpin_name = shangpin_name;
    }

    public String getShanpin_id() {
        return shanpin_id;
    }

    public void setShanpin_id(String shanpin_id) {
        this.shanpin_id = shanpin_id;
    }

    public String getcel(int col){
        if (col==0) return this.getShanpin_id();
        else if (col==1) return this.getShangpin_name();
        else if (col==2) return this.getGuige();
        else if (col==3) return Float.toString(this.getKucun());
        else if (col==4) return Float.toString(this.getPrice());
        else return "";
    }
}
