package com.shengxian.shengxianmanager;

import com.shengxian.control.example.*;
import com.shengxian.itf.IyonghuManager;
import com.shengxian.itf.*;

public class shangxianUtil {
    public static IyonghuManager yonghuManager = new ExampleUserManager();
    public static Iyonghujiemian_shangpin usershangpin = new Exampleyonghujiemian_shangpin();
    public static Iyonghuijiemian_youhui useryouhui = new Exampleyonghujiemian_youhui();
    public static Iyonghujiemian_dingdan userdingdan = new Exampleyonghujiemian_dingdan();
    public static Imanager manager_system = new ExampleManager();
    public static Imanager_shangpin manager_shangpin = new Examplemanager_shangpin();
}
