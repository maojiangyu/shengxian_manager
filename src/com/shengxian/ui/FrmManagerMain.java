package com.shengxian.ui;

import com.shengxian.model.*;
import com.shengxian.shengxianmanager.shangxianUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class FrmManagerMain extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JMenuBar menuber = new JMenuBar();
    private JMenu menu_shangpin = new JMenu("商品管理");
    private JMenu menu_dingdan = new JMenu("用户管理");
    private JMenu menu_more = new JMenu("更多");

    private JMenuItem menuItem_buy = new JMenuItem("购买商品");
    private JMenuItem menuItem_cannalbuy = new JMenuItem("设定价格");

    private JMenuItem menuItem_shangpinxinxi = new JMenuItem("删除用户");

    private JMenuItem menuItem_changepwd = new JMenuItem("修改密码");
    private JMenuItem menuItem_exit = new JMenuItem("退出");

    private FrmManagerlogin dlgLogin = null;
    private JPanel statusBar = new JPanel();

    private Object shangpinTitle[] = yonghujiemian_shangpin.tableTitles;
    private Object shangpinDate[][];
    DefaultTableModel shangpinModel = new DefaultTableModel();
    private JTable dataTableshangpin = new JTable(shangpinModel);

    private guanliyuanxinxi user = null;
    java.util.List<manager_shangpin> allshangpin = null;

    private void reloadshangpinTable(){
        try{
            allshangpin = shangxianUtil.manager_shangpin.loadAll();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
            return;
        }
        shangpinDate = new Object[allshangpin.size()][yonghujiemian_shangpin.tableTitles.length];
        for(int i = 0;i<allshangpin.size();i++){
            for (int j = 0;j<yonghujiemian_shangpin.tableTitles.length;j++)
                shangpinDate[i][j] = allshangpin.get(i).getcel(j);
        }
        shangpinModel.setDataVector(shangpinDate,shangpinTitle);
        this.dataTableshangpin.validate();
        this.dataTableshangpin.repaint();
    }

    public FrmManagerMain(){
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setTitle("生鲜网超管理系统");
        dlgLogin = new FrmManagerlogin(this,"管理员登陆",true);
        dlgLogin.setVisible(true);

        //menu
        this.menu_shangpin.add(this.menuItem_shangpinxinxi);this.menuItem_shangpinxinxi.addActionListener(this);

        this.menu_dingdan.add(this.menuItem_buy);this.menuItem_buy.addActionListener(this);
        this.menu_dingdan.add(this.menuItem_cannalbuy);this.menuItem_cannalbuy.addActionListener(this);

        this.menu_more.add(this.menuItem_changepwd);this.menuItem_changepwd.addActionListener(this);
        this.menu_more.add(this.menuItem_exit);this.menuItem_exit.addActionListener(this);

        menuber.add(menu_shangpin);
        menuber.add(menu_dingdan);
        menuber.add(menu_more);
        this.setJMenuBar(menuber);

        //信息表
        this.getContentPane().add(new JScrollPane(this.dataTableshangpin),BorderLayout.WEST);
        //this.getContentPane().add(new JScrollPane(this.dataTabledingdan),BorderLayout.EAST);
        //this.getContentPane().add(new JScrollPane(this.dataTableyouhui),BorderLayout.CENTER);
        this.reloadshangpinTable();
        //this.reloadyouhuiTable();
        //this.reloaddingdanTable();


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
        if (e.getSource()==menu_dingdan){

        }

        else if (e.getSource()==menuItem_exit){
            System.exit(0);
        }
    }
}
