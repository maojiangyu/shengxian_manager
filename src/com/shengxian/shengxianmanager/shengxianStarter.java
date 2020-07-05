package com.shengxian.shengxianmanager;

import com.shengxian.ui.FrmMain;
import com.shengxian.ui.FrmManagerMain;

import java.util.*;

public class shengxianStarter {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.print("请输入你的身份为管理员或者用户： ");

        Scanner in = new Scanner(System.in);
        // TODO Auto-generated method stub
        String a = in.nextLine();
        if(a.equals("管理员"))
            new FrmManagerMain();
        else if (a.equals("用户"))
            new FrmMain();

    }
}
