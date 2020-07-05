package com.shengxian.control.example;

import com.shengxian.itf.Iyonghujiemian_shangpin;
import com.shengxian.model.yonghujiemian_shangpin;
import com.shengxian.util.BaseException;
import com.shengxian.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Exampleyonghujiemian_shangpin implements Iyonghujiemian_shangpin {
    @Override
    public List<yonghujiemian_shangpin> loadAll() throws BaseException {
        List<yonghujiemian_shangpin> result1=new ArrayList<yonghujiemian_shangpin>();
        yonghujiemian_shangpin p=new yonghujiemian_shangpin();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            if(p==null)
                throw new BaseException("商品为空");
            con = DBUtil.getConnection();
            String sql = "SELECT * FROM shangpin";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                p.setShangpin_id(rs.getString(1));
                p.setShangpin_name(rs.getString(3));
                p.setPrice(rs.getFloat(4));
                p.setNumber(rs.getFloat(6));
                p.setGuige(rs.getString(7));
                p.setXiaoliang(rs.getFloat(9));
                result1.add(p);
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

        return result1;

    }
}
