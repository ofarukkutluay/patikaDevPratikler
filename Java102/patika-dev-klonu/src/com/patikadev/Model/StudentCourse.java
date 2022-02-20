package com.patikadev.Model;

import com.patikadev.Helper.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentCourse {
    private int user_id;
    private int course_id;
    private boolean isCompleted;

    public StudentCourse(int user_id, int course_id, boolean isCompleted) {
        this.user_id = user_id;
        this.course_id = course_id;
        this.isCompleted = isCompleted;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public static ArrayList<StudentCourse> getListByUserId(int user_id){
        ArrayList<StudentCourse> rtnObj = new ArrayList<>();
        String query = "SELECT * FROM student_course WHERE user_id = "+user_id;
        try {
            Statement st = DbConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                StudentCourse obj = new StudentCourse(rs.getInt("user_id"),rs.getInt("course_id"),rs.getBoolean("is_completed"));
                rtnObj.add(obj);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rtnObj;
    }

    public static StudentCourse getByUserIdAndCourseId(int user_id,int course_id){
        StudentCourse rtnObj = null;
        String query = "SELECT * FROM student_course WHERE user_id =" +user_id +" AND course_id ="+course_id;
        try {
            Statement st = DbConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                rtnObj = new StudentCourse(rs.getInt("user_id"),rs.getInt("course_id"),rs.getBoolean("is_completed"));
                break;
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rtnObj;
    }

    public static boolean add(int user_id,int course_id,boolean isCompleted){
        String query = "INSERT INTO student_course (user_id,course_id,is_completed) VALUES (?,?,?)";
        try {
            PreparedStatement pr = DbConnector.getInstance().prepareStatement(query);
            pr.setInt(1,user_id);
            pr.setInt(2,course_id);
            pr.setBoolean(3,isCompleted);
            int result = pr.executeUpdate();
            pr.close();
            return result!=-1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static boolean update(int user_id,int course_id,boolean isCompleted){
        String query = "UPDATE student_course SET is_completed=? WHERE user_id=? AND course_id=?";
        try {
            PreparedStatement pr = DbConnector.getInstance().prepareStatement(query);
            pr.setBoolean(1,isCompleted);
            pr.setInt(2,user_id);
            pr.setInt(3,course_id);
            int result = pr.executeUpdate();
            pr.close();
            return result!=-1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
