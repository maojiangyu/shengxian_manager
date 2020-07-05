package com.shengxian.itf;

import com.shengxian.model.yonghujiemian_dingdan;
import com.shengxian.model.yonghujiemian_shangpin;
import com.shengxian.util.BaseException;

import java.util.List;

public interface Iyonghujiemian_dingdan {
    public List<yonghujiemian_dingdan> loadAll()throws BaseException;

    public yonghujiemian_dingdan adddingdan(String shangpin_id,float num,String dizhi_id) throws BaseException;
}
