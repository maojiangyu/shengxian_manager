package com.shengxian.ui;

import com.shengxian.model.yonghuxinxi;
import com.shengxian.shengxianmanager.shangxianUtil;
import com.shengxian.util.BaseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmRegister extends JDialog implements ActionListener {
    private JPanel panel1;
    private JButton registerButton;
    private JButton cannalButton;
    private JTextField nametext;
    private JTextField sextext;
    private JTextField phonenumbertext;
    private JTextField mailtext;
    private JTextField citytext;
    private JPasswordField newpasswordField1;
    private JPasswordField newpasswordField2;
    private JLabel citylabel;
    private JLabel maillabel;
    private JLabel phonelabel;
    private JLabel newpwd2label;
    private JLabel newpwdlabel;
    private JLabel sexlabel;
    private JLabel namelabel;
    private JTextField useridtext;
    private JLabel userlabel;

    public FrmRegister(Frame f, String s, boolean b){
        super(f, s, b);
        panel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.getContentPane().add(panel1,BorderLayout.SOUTH);
        this.setSize(390,280);

        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        this.setLocation((int)(width-this.getWidth())/2,(int)(height-this.getHeight())/2);
        this.validate();

        registerButton.addActionListener(this);
        cannalButton.addActionListener(this);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public FrmRegister(Frmlogin f, String s, boolean b){
        super(f, s, b);
        panel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.getContentPane().add(panel1,BorderLayout.SOUTH);
        this.setSize(300,300);

        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        this.setLocation((int)(width-this.getWidth())/2,(int)(height-this.getHeight())/2);
        this.validate();

        registerButton.addActionListener(this);
        cannalButton.addActionListener(this);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==this.cannalButton){
            this.setVisible(false);
        }
        else if (e.getSource()==this.registerButton){
            String userid = this.useridtext.getText();
            String username = this.nametext.getText();
            String sex = this.sextext.getText();
            String pwd1 = new String(this.newpasswordField1.getPassword());
            String pwd2 = new String(this.newpasswordField2.getPassword());
            String phonenumber = this.phonenumbertext.getText();
            String mail = this.mailtext.getText();
            String city = this.citytext.getText();
            try{
                yonghuxinxi user = shangxianUtil.yonghuManager.reg(userid,username,sex,pwd1,pwd2,phonenumber,mail,city);
                this.setVisible(false);
            } catch (BaseException e1) {
                JOptionPane.showMessageDialog(null,e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

    }
}
