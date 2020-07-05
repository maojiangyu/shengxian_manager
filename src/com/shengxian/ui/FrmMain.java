package com.shengxian.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

import com.shengxian.model.*;
import com.shengxian.shengxianmanager.shangxianUtil;
import com.shengxian.util.BaseException;

public class FrmMain extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JMenuBar menuber = new JMenuBar();
    private JMenu menu_shangpin = new JMenu("商品");
    private JMenu menu_dingdan = new JMenu("订单");
    private JMenu menu_more = new JMenu("更多");

    private JMenuItem menuItem_buy = new JMenuItem("购买商品");
    private JMenuItem menuItem_cannalbuy = new JMenuItem("取消订单");

    private JMenuItem menuItem_shangpinxinxi = new JMenuItem("查看商品信息");
    private JMenuItem menuItem_shangpinjianmian = new JMenuItem("查看商品满减情况");

    private JMenuItem menuItem_chuangjianVIP = new JMenuItem("创建会员");
    private JMenuItem menuItem_changepwd = new JMenuItem("修改密码");
    private JMenuItem menuItem_exit = new JMenuItem("退出");

    private Frmlogin dlgLogin = null;
    private JPanel statusBar = new JPanel();

    private Object shangpinTitle[] = yonghujiemian_shangpin.tableTitles;
    private Object shangpinDate[][];
    DefaultTableModel shangpinModel = new DefaultTableModel();
    private JTable dataTableshangpin = new JTable(shangpinModel);

    private Object youhuiTitle[] = yonghujiemian_youhui.tableTitles;
    private Object youhuiDate[][];
    DefaultTableModel youhuiModel = new DefaultTableModel();
    private JTable dataTableyouhui = new JTable(youhuiModel);

    private Object dingdanTitle[] = yonghujiemian_dingdan.tableTitles;
    private Object dingdanDate[][];
    DefaultTableModel dingdanModel = new DefaultTableModel();
    private JTable dataTabledingdan = new JTable(dingdanModel);

    private yonghuxinxi user = null;
    List<yonghujiemian_shangpin> allshangpin = null;
    List<yonghujiemian_youhui> youhui__ = null;
    List<yonghujiemian_dingdan> dingdan__ = null;

    private void reloadshangpinTable(){
        try{
            allshangpin = shangxianUtil.usershangpin.loadAll();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
            return;
        }
        shangpinDate = new Object[allshangpin.size()][yonghujiemian_shangpin.tableTitles.length];
        for(int i = 0;i<allshangpin.size();i++){
            for (int j = 0;j<yonghujiemian_shangpin.tableTitles.length;j++)
                shangpinDate[i][j] = allshangpin.get(i).getCell(j);
        }
        shangpinModel.setDataVector(shangpinDate,shangpinTitle);
        this.dataTabledingdan.validate();
        this.dataTabledingdan.repaint();
    }

    private void reloadyouhuiTable(){
        try{
            youhui__ = shangxianUtil.useryouhui.loadAll();
        } catch (BaseException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
            return;
        }
        youhuiDate = new Object[youhui__.size()][yonghujiemian_youhui.tableTitles.length];
        for(int i = 0;i<youhui__.size();i++){
            for (int j = 0;j<yonghujiemian_youhui.tableTitles.length;j++)
                shangpinDate[i][j] = youhui__.get(i).getcell(j);
        }
        youhuiModel.setDataVector(youhuiDate,youhuiTitle);
        this.dataTableyouhui.validate();
        this.dataTableyouhui.repaint();
    }

    private void reloaddingdanTable(){
        try{
            dingdan__ = shangxianUtil.userdingdan.loadAll();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
            return;
        }
        dingdanDate = new Object[dingdan__.size()][yonghujiemian_dingdan.tableTitles.length];
        for(int i = 0;i<dingdan__.size();i++){
            for (int j = 0;j<yonghujiemian_dingdan.tableTitles.length;j++)
                dingdanDate[i][j] = dingdan__.get(i).getCell(j);
        }
        dingdanModel.setDataVector(dingdanDate,dingdanTitle);
        this.dataTabledingdan.validate();
        this.dataTabledingdan.repaint();
    }




    public FrmMain(){
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setTitle("生鲜网超");
        dlgLogin = new Frmlogin(this,"登陆",true);
        dlgLogin.setVisible(true);
        //menu
        this.menu_shangpin.add(this.menuItem_shangpinxinxi);this.menuItem_shangpinxinxi.addActionListener(this);
        this.menu_shangpin.add(this.menuItem_shangpinjianmian);this.menuItem_shangpinjianmian.addActionListener(this);

        this.menu_dingdan.add(this.menuItem_buy);this.menuItem_buy.addActionListener(this);
        this.menu_dingdan.add(this.menuItem_cannalbuy);this.menuItem_cannalbuy.addActionListener(this);

        this.menu_more.add(this.menuItem_chuangjianVIP);this.menuItem_chuangjianVIP.addActionListener(this);
        this.menu_more.add(this.menuItem_changepwd);this.menuItem_changepwd.addActionListener(this);
        this.menu_more.add(this.menuItem_exit);this.menuItem_exit.addActionListener(this);

        menuber.add(menu_shangpin);
        menuber.add(menu_dingdan);
        menuber.add(menu_more);
        this.setJMenuBar(menuber);

        this.getContentPane().add(new JScrollPane(this.dataTableshangpin),BorderLayout.WEST);
        this.getContentPane().add(new JScrollPane(this.dataTabledingdan),BorderLayout.EAST);
        this.getContentPane().add(new JScrollPane(this.dataTableyouhui),BorderLayout.CENTER);
        this.reloadshangpinTable();
        this.reloadyouhuiTable();
        this.reloaddingdanTable();

        statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel("您好");
        statusBar.add(label);
        this.getContentPane().add(statusBar,BorderLayout.SOUTH);
        this.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==menuItem_shangpinxinxi){


        }

        else if (e.getSource()==menuItem_buy){

        }

        else if (e.getSource()==menuItem_shangpinjianmian){

        }

        else if (e.getSource()==menuItem_cannalbuy){

        }

        else if (e.getSource()==menuItem_chuangjianVIP){

        }

        else if (e.getSource()==menuItem_changepwd){

        }

        else if (e.getSource()==menuItem_exit){
            System.exit(0);

        }

    }
}
