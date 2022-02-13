package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Example extends JFrame{
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JTextField fld_username;
    private JPasswordField fld_password;
    private JButton btn_login;

    public Example(){
        //PC de bullunan temaları geziyoruz.
        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            if ("Nimbus".equals(info.getName())){
                try {
                    UIManager.setLookAndFeel(info.getClassName()); // UI temesını set ediyoruz
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
            }
        }


        setContentPane(wrapper);
        setSize(400,300);
        setTitle("Uygulama adı");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // kapat tuşuna basınca dispose olmasını sağlıyor.

        setResizable(false); // kullanıcının formun boyutunu değiştirmesini engelliyoruz.

        // Başlangı lokasyonunu belirliyoruz.
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) /2 ;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) /2;
        setLocation(x,y);


        setVisible(true); // Formun görünürlüğü


//        btn_login.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
        // farklı yazılabir YADA;
        btn_login.addActionListener(e->{
            if (fld_username.getText().length() == 0 || fld_password.getText().length() == 0){
                JOptionPane.showMessageDialog(null,"Tüm alanalrı doldurun", "Hata",JOptionPane.INFORMATION_MESSAGE); // Popup messagepenceresi tanımladık.
            }
        });
    }

}
