package com.company.Controller;

import com.company.Database.UserDb;
import com.company.Model.User;

public class AuthController {
    UserDb db;
    public AuthController() {
        this.db = new UserDb();
    }

    public boolean login(String tc, String pass){

        User user = this.db.getByTcNumber(tc);
        if(user==null){
            System.out.println("Kullanıcıı bulunamadı");
            return false;
        }else if(user.getPass().equals(pass)){
            System.out.println("Giriş yapıldı");
            return true;
        }
        return false;
    }

    public boolean register(long id,String name,String tc,String birth_date,String pass){
        if(pass.equals(birth_date)){
            System.out.println("Şifre doğum tarihi olamaz!");
            return false;
        }

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setTc_number(tc);
        user.setBirth_date(birth_date);
        user.setPass(pass);
        if(this.db.add(user)){
            System.out.println("kullanıcı kayıt edildi");
            return true;
        }else{
            System.out.println("Db ye kayıt ederken bir hata oluştu");
            return false;
        }
    }
}
