package com.shengxian.itf;

import com.shengxian.model.manager_shangpin;
import com.shengxian.model.yonghujiemian_youhui;
import com.shengxian.util.BaseException;

import java.util.List;

public interface Imanager_shangpin {
    public List<manager_shangpin> loadAll()throws BaseException;
}
