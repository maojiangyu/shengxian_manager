package com.shengxian.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import com.shengxian.model.yonghuxinxi;
import com.shengxian.util.BaseException;
import com.shengxian.shengxianmanager.shangxianUtil;

public  class Frmlogin extends JDialog implements ActionListener {
    private JPanel workpane;
    private JPanel panel1;

    private JButton loginButton;
    private JButton exitButton;
    private JButton registerButton;

    private JLabel userLabel;
    private JLabel passwordlabel;

    private JTextField textField1;
    private JPasswordField textField2;

    public Frmlogin(Frame f,String s,boolean b){
        super(f, s, b);
        panel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.getContentPane().add(panel1,BorderLayout.SOUTH);
        this.getContentPane().add(workpane,BorderLayout.CENTER);
        this.setSize(390,280);

        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        this.setLocation((int)(width-this.getWidth())/2,(int)(height-this.getHeight())/2);
        this.validate();

        loginButton.addActionListener(this);
        exitButton.addActionListener(this);
        this.registerButton.addActionListener(this);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==this.loginButton){
            String userid = this.textField1.getText();
            String pwd = new String(this.textField2.getPassword());
            try{
                yonghuxinxi.currentLoginuser = shangxianUtil.yonghuManager.login(userid,pwd);
            } catch (BaseException e1) {
                JOptionPane.showMessageDialog(null,e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
                return ;
            }
            this.setVisible(false);
        }
        else if (e.getSource()==this.exitButton){
            System.exit(0);
        }
        else if(e.getSource()==this.registerButton){
            FrmRegister dlg = new FrmRegister(this,"注册",true);
            dlg.setVisible(true);
        }

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
