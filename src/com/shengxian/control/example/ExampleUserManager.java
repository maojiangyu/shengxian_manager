package com.shengxian.control.example;

import com.shengxian.itf.IyonghuManager;
import com.shengxian.model.yonghuxinxi;
import com.shengxian.util.BaseException;
import com.shengxian.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExampleUserManager implements IyonghuManager {


    @Override
    public yonghuxinxi reg(String userid,String username, String sex, String pwd, String pwd2, String phonenumber, String mail, String city) throws BaseException {
        if(userid==null)
            throw new BaseException("用户的ID不能为空");
        else {
            Connection con = null;
            try {
                con = DBUtil.getConnection();
                String sql = "SELECT yonghu_id FROM yonghuxinxi WHERE yonghu_id = ?";
                java.sql.PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, userid);
                ResultSet rs = st.executeQuery();
                if(rs.next()) {
                    throw new BaseException("用户名重复");
                }
                else {
                    if (!(sex.equals("男")||sex.equals("女")))
                        throw new BaseException("性别不正确");
                    if(pwd.equals(pwd2)) {
                        String sql2 = "INSERT INTO yonghuxinxi(yonghu_id,name,sex,mima,phonenumber,mail,suozaicity,zhuce_date) VALUES(?,?,?,?,?,?,?,?)";
                        PreparedStatement st2 = con.prepareStatement(sql2);
                        st2.setString(1, userid);
                        st2.setString(2,username);
                        st2.setString(3,sex);
                        st2.setString(4, pwd);
                        st2.setString(5,phonenumber);
                        st2.setString(6,mail);
                        st2.setString(7,city);
                        java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
                        st2.setDate(8, currentDate);
                        st2.execute();
                        System.out.print("创建成功");
                    }
                    else {
                        throw new BaseException("密码不相同");
                    }
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
        }
        return null;
    }

    @Override
    public yonghuxinxi login(String userid, String pwd) throws BaseException {
        Connection con = null;
        yonghuxinxi user = new yonghuxinxi();
        try {
            con = DBUtil.getConnection();
            String sql = "SELECT yonghu_id FROM yonghuxinxi WHERE yonghu_id = ? AND mima = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, userid);
            st.setString(2, pwd);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                user.setYonghu_id(userid);
                user.setMima(pwd);
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

    @Override
    public void changepwd(yonghuxinxi user, String oldpwd, String newpwd, String newpwd2) throws BaseException {
        Connection con = null;
        try {
            con = DBUtil.getConnection();
            String sql = "SELECT user_id FROM tbl_user WHERE user_id = ? AND user_pwd = ? ";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, user.getYonghu_id());
            st.setString(2,user.getMima());
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                if(newpwd.equals(newpwd2)) {
                    String sql2 = "UPDATE tbl_user\n" +
                            "SET user_pwd = ?\n" +
                            "WHERE user_id = ?";
                    PreparedStatement st2 = con.prepareStatement(sql2);
                    st2.setString(1,newpwd );
                    st2.setString(2, user.getYonghu_id());
                    st2.executeUpdate();
                    System.out.print("修改成功");
                }
                else {
                    throw new BaseException("密码不一致");
                }
            }
            else {
                System.out.print("密码错误");
            }
        }catch (SQLException e) {
            System.out.print("操作失败");
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

    }

}
