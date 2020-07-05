package com.shengxian.itf;

import com.shengxian.model.yonghujiemian_shangpin;
import com.shengxian.model.yonghujiemian_youhui;
import com.shengxian.util.BaseException;

import java.util.List;

public interface Iyonghuijiemian_youhui {
    public List<yonghujiemian_youhui> loadAll()throws BaseException;
}
