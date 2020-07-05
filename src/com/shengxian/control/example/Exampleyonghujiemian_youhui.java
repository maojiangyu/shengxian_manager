package com.shengxian.control.example;

import com.shengxian.itf.Iyonghuijiemian_youhui;
import com.shengxian.itf.Iyonghujiemian_shangpin;
import com.shengxian.model.yonghujiemian_shangpin;
import com.shengxian.model.yonghujiemian_youhui;
import com.shengxian.util.BaseException;
import com.shengxian.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Exampleyonghujiemian_youhui implements Iyonghuijiemian_youhui {
    @Override
    public List<yonghujiemian_youhui> loadAll() throws BaseException {
        List<yonghujiemian_youhui> result3=new ArrayList<yonghujiemian_youhui>();
        yonghujiemian_youhui p=new yonghujiemian_youhui();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            if(p==null)
                throw new BaseException("优惠情况为空");
            con = DBUtil.getConnection();
            String sql = "SELECT * FROM youhuicard";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                p.setYouhuicard_id(rs.getString(1));
                p.setYouhuineirong(rs.getString(2));
                p.setShiyong_money(rs.getFloat(3));
                p.setReduce_money(rs.getFloat(4));
                p.setStart_date(rs.getDate(5));
                p.setEnd_date(rs.getDate(6));

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
}
