package com.shengxian.model;

public class guanliyuanxinxi {
    public static guanliyuanxinxi currentLoginmanager = null;

    private String yuangong_id;
    private String yuangong_name;
    private String demglumima;

    public String getDemglumima() {
        return demglumima;
    }

    public void setDemglumima(String demglumima) {
        this.demglumima = demglumima;
    }

    public String getYuangong_name() {
        return yuangong_name;
    }

    public void setYuangong_name(String yuangong_name) {
        this.yuangong_name = yuangong_name;
    }

    public String getYuangong_id() {
        return yuangong_id;
    }

    public void setYuangong_id(String yuangong_id) {
        this.yuangong_id = yuangong_id;
    }
}
