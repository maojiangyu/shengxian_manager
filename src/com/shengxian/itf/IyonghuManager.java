package com.shengxian.itf;

import com.shengxian.model.yonghuxinxi;
import com.shengxian.util.BaseException;

public interface IyonghuManager {
    /**
     * 注册
     * @param username
     * @param pwd
     * @param pwd2
     * @return
     * @throws BaseException
     */
    public yonghuxinxi reg(String userid,String username,String sex,String pwd,String pwd2,String phonenumber,String mail,String city)throws BaseException;

    /**
     * 登陆
     * @param userid
     * @param pwd
     * @return
     * @throws BaseException
     */
    public yonghuxinxi login(String userid,String pwd)throws BaseException;

    /**
     * 修改密码
     * @param user
     * @param oldpwd
     * @param newpwd
     * @param newpwd2
     * @throws BaseException
     */
    public void changepwd(yonghuxinxi user,String oldpwd,String newpwd,String newpwd2)throws BaseException;
}
