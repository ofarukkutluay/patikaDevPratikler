package com.patikadev.Model;

import com.patikadev.Helper.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Patika {
    private int id;
    private String name;

    public Patika(){}

    public Patika(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ArrayList<Patika> getList(){
        ArrayList<Patika> patikaList = new ArrayList<>();
        String query = "SELECT * FROM patika";
        Patika obj;
        try {
            Statement st = DbConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                obj = new Patika();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                patikaList.add(obj);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return patikaList;
    }

    public static boolean add(String name){
        String query = "INSERT INTO patika (name) VALUES (?)";
        Patika findPatika = getFetch(name);
        if(findPatika != null){
            return false;
        }
        try {
            PreparedStatement pr = DbConnector.getInstance().prepareStatement(query);
            pr.setString(1,name);
            int result = pr.executeUpdate();
            pr.close();
            return result !=-1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public static Patika getFetch(String name){
        Patika obj = null;
        String query = "SELECT * FROM patika WHERE name = ?";
        try {
            PreparedStatement pr = DbConnector.getInstance().prepareStatement(query);
            pr.setString(1,name);
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                obj = new Patika();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                break;
            }
            pr.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return obj;
    }

    public static Patika getFetch(int id){
        Patika obj = null;
        String query = "SELECT * FROM patika WHERE id = ?";
        try {
            PreparedStatement pr = DbConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                obj = new Patika();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                break;
            }
            pr.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return obj;
    }

    public static boolean delete(int id){
        String query = "DELETE FROM patika WHERE id= ?";
        ArrayList<Course> courseList = Course.getList();
        for(Course c : courseList){
            if (c.getPatika().getId() == id){
                Course.delete(c.getId());
            }
        }
        try {
            PreparedStatement pr = DbConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            int result = pr.executeUpdate();
            pr.close();
            return result !=-1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;

    }

    public static boolean update(int id,String name){
        String query = "UPDATE patika SET name=? WHERE id=?";
        Patika findPatika = getFetch(name);
        if(findPatika != null && findPatika.getId() != id){
            return false;
        }
        try {
            PreparedStatement pr = DbConnector.getInstance().prepareStatement(query);
            pr.setString(1,name);
            pr.setInt(2,id);
            int result = pr.executeUpdate();
            pr.close();
            return result !=-1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static ArrayList<Patika> searchUserList(String query){
        ArrayList<Patika> patikaList = new ArrayList<>();
        Patika obj;
        try {
            Statement st = DbConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                obj = new Patika();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                patikaList.add(obj);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return patikaList;
    }

    public static String searchQuery(String name,String uname,String type){
        String query = "SELECT * FROM patika WHERE  name LIKE '%{{name}}%' ";
        query = query.replace("{{name}}",name);
        return query;
    }
}
