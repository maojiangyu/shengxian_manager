package com.shengxian.control.example;

import com.shengxian.itf.Iyonghujiemian_dingdan;
import com.shengxian.model.yonghujiemian_dingdan;
import com.shengxian.model.yonghujiemian_shangpin;
import com.shengxian.model.yonghuxinxi;
import com.shengxian.util.BaseException;
import com.shengxian.util.DBUtil;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Exampleyonghujiemian_dingdan implements Iyonghujiemian_dingdan {
    @Override
    public List<yonghujiemian_dingdan> loadAll() throws BaseException {
        List<yonghujiemian_dingdan> result3=new ArrayList<yonghujiemian_dingdan>();
        yonghujiemian_dingdan p=new yonghujiemian_dingdan();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            if(p==null)
                throw new BaseException("订单为空");
            con = DBUtil.getConnection();
            String sql = "SELECT * FROM dingdan_xiangqing";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                p.setDingdan_id(rs.getString(2));
                p.setShangpin_id(rs.getString(3));
                p.setShangpin_num(rs.getFloat(4));
                p.setZhekou(rs.getFloat(6));
                p.setMoney(rs.getFloat(5));
                result3.add(p);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return result3;
    }

    @Override
    public yonghujiemian_dingdan adddingdan(String shangpin_id, float num, String dizhi_id) throws BaseException {
        Connection con = null;
        yonghuxinxi user = new yonghuxinxi();
        try{
            con = DBUtil.getConnection();
            user = yonghuxinxi.currentLoginuser;
            PreparedStatement pst = null;
            ResultSet rs = null;
            String sql1 = "SELECT MAX(dingdan_id) FROM shangpindingdan WHERE yonghu_id = ?";
            pst.setString(1,user.getYonghu_id());
            pst = con.prepareStatement(sql1);
            rs = pst.executeQuery();
            int count = 1;
            if (rs.next())
                count = rs.getInt(1)+1;
            String sql2 = "SELECT VIP FROM yonghuxinxi WHERE yonghu_id = ?";
            pst = con.prepareStatement(sql2);
            pst.setString(1,user.getYonghu_id());
            rs = pst.executeQuery();
            rs.next();
            int VIP = rs.getInt(1);
            float danjia = 0;
            if (VIP==1){
                String sql3 = "SELECT VIP_price FROM shangpin WHERE shangpin_id ?";
                pst.setString(1,shangpin_id);
                rs = pst.executeQuery();
                rs.next();
                 danjia = rs.getFloat(1);
            }
            else{
                String sql3 = "SELECT price FROM shangpin WHERE shangpin_id ?";
                pst.setString(1,shangpin_id);
                rs = pst.executeQuery();
                rs.next();
                danjia = rs.getFloat(1);
            }
            rs.close();
            float total_money = danjia*num;
            java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
            String sql4 = "INSERT INTO shangpindindan(dingdan_id,dizhi_id,yonghu_id,yuanshi_money,jiesuan_money,songda_date,xiadan) "+"VALUES(?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql4);
            pst.setInt(1,count);
            pst.setString(2,dizhi_id);
            pst.setString(3,user.getYonghu_id());
            pst.setFloat(4,total_money);
            pst.setFloat(5,total_money);
            pst.setDate(6,currentDate);
            pst.setBoolean(7,true);
            pst.executeUpdate();

            String sql5 = "INSERT INTO dinagdan_xiangqing()";



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
