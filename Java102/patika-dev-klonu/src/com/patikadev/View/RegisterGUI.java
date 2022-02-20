package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterGUI extends JFrame {
    private JPanel wrapper;
    private JTextField fld_user_name;
    private JTextField fld_user_uname;
    private JPasswordField fld_user_pass;
    private JButton btn_user_resgister;
    private JPanel pnl_register;
    private JPanel pnl_top;
    private JButton btn_user_login;

    public RegisterGUI(){
        Helper.setLayout();
        add(wrapper);
        setSize(600,500);
        setLocation(Helper.screenCenterPoint("x",getSize()),Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        btn_user_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginGUI loginGUI = new LoginGUI();
                dispose();
            }
        });
        btn_user_resgister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Helper.isFieldEmpty(fld_user_name)||Helper.isFieldEmpty(fld_user_uname)||Helper.isFieldEmpty(fld_user_pass)){
                    Helper.showMsg("fill");
                }else{
                    String name = fld_user_name.getText();
                    String uname = fld_user_uname.getText();
                    String pass = fld_user_pass.getText();
                    String type = "student";
                    if(User.add(name,uname,pass,type)){
                        if(Helper.confirm("Kayıt tamamdır. Login sayfasına geçeyim mi?")){
                            LoginGUI loginGUI = new LoginGUI();
                            dispose();
                        }else{
                            dispose();
                        }
                    }else{
                        Helper.showMsg("error");
                    }
                }
            }
        });
    }
}
