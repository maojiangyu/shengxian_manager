package com.shengxian.itf;

import com.shengxian.model.guanliyuanxinxi;
import com.shengxian.util.BaseException;

public interface Imanager {
    public guanliyuanxinxi login(String manager_id,String pwd)throws BaseException;

}
