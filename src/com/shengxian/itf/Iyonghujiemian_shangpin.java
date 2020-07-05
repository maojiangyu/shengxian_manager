package com.shengxian.itf;

import com.shengxian.model.yonghujiemian_shangpin;
import com.shengxian.util.BaseException;

import java.util.List;

public interface Iyonghujiemian_shangpin {
    public List<yonghujiemian_shangpin> loadAll()throws BaseException;
}
