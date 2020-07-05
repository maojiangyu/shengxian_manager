package com.shengxian.control.example;

import com.shengxian.itf.Imanager_shangpin;
import com.shengxian.model.manager_shangpin;
import com.shengxian.model.yonghujiemian_shangpin;
import com.shengxian.util.BaseException;
import com.shengxian.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Examplemanager_shangpin implements Imanager_shangpin {
    @Override
    public List<manager_shangpin> loadAll() throws BaseException {
        List<manager_shangpin> result1=new ArrayList<manager_shangpin>();
        manager_shangpin p=new manager_shangpin();
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
                p.setShanpin_id(rs.getString(1));
                p.setShangpin_name(rs.getString(3));
                p.setGuige(rs.getString(7));
                p.setKucun(rs.getFloat(6));
                p.setPrice(rs.getFloat(4));
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
