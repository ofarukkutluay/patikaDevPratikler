package com.patikadev.Model;

import com.patikadev.Helper.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Reply {
    private int id;
    private int quiz_id;
    private String reply;

    public Reply(int id, int quiz_id, String reply) {
        this.id = id;
        this.quiz_id = quiz_id;
        this.reply = reply;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public static ArrayList<Reply> getListByQuizId(int quiz_id){
        ArrayList<Reply> replies = new ArrayList<>();
        String query = "SELECT * FROM reply WHERE quiz_id ="+quiz_id;
        Reply obj;
        try {
            Statement st = DbConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                obj = new Reply(rs.getInt("id"),rs.getInt("quiz_id"),rs.getString("reply"));
                replies.add(obj);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return replies;
    }

    public static boolean add(int quiz_id,String reply){
        String query = "INSERT INTO reply (quiz_id,reply) VALUES (?,?)";
        try {
            PreparedStatement pr = DbConnector.getInstance().prepareStatement(query);
            pr.setInt(1,quiz_id);
            pr.setString(2,reply);
            int result = pr.executeUpdate();
            pr.close();
            return result != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
