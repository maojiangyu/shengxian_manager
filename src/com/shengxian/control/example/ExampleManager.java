package com.shengxian.control.example;

import com.shengxian.itf.Imanager;
import com.shengxian.model.guanliyuanxinxi;
import com.shengxian.model.yonghuxinxi;
import com.shengxian.util.BaseException;
import com.shengxian.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExampleManager implements Imanager {
    @Override
    public guanliyuanxinxi login(String manager_id, String pwd) throws BaseException {
        Connection con = null;
        guanliyuanxinxi user = new guanliyuanxinxi();
        try {
            con = DBUtil.getConnection();
            String sql = "SELECT yuangong_id FROM guanliyuanxinxi WHERE yuangong_id = ? AND demglumima = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, manager_id);
            st.setString(2, pwd);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                user.setYuangong_id(manager_id);
                user.setDemglumima(pwd);
                return user;
            }
            else {
                throw new BaseException("密码错误或用户不存在");
            }
        }catch (SQLException e) {
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

        return null;
    }
}
