package com.shengxian.model;

public class yonghujiemian_dingdan {
    public static final String[] tableTitles={"订单编号","商品编号","数量","折扣","结算金额"};

    private String dingdan_id;
    private String shangpin_id;
    private float shangpin_num;
    private float zhekou;
    private float money;

    public String getCell(int col) {
        if (col==0) return this.getDingdan_id();
        else if (col==1) return this.getShangpin_id();
        else if (col==2) return Float.toString(this.getShangpin_num());
        else if (col==3) return Float.toString(this.getZhekou());
        else if (col==4) return Float.toString(this.getMoney());
        else return "";
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public float getZhekou() {
        return zhekou;
    }

    public void setZhekou(float zhekou) {
        this.zhekou = zhekou;
    }

    public float getShangpin_num() {
        return shangpin_num;
    }

    public void setShangpin_num(float shangpin_num) {
        this.shangpin_num = shangpin_num;
    }


    public String getShangpin_id() {
        return shangpin_id;
    }

    public void setShangpin_id(String shangpin_id) {
        this.shangpin_id = shangpin_id;
    }


    public String getDingdan_id() {
        return dingdan_id;
    }

    public void setDingdan_id(String dingdan_id) {
        this.dingdan_id = dingdan_id;
    }
}
