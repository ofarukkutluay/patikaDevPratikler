package com.patikadev.Model;

import com.patikadev.Helper.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Quiz {
    private int id;
    private int content_id;
    private String question;
    private ArrayList<Reply> replies;
    private int correctAnswerId;
    private Content content;

    public Quiz(int id, int content_id, String question, int correctAnswerId) {
        this.id = id;
        this.content_id = content_id;
        this.question = question;
        this.replies = Reply.getListByQuizId(id);
        this.correctAnswerId = correctAnswerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int content_id) {
        this.content_id = content_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<Reply> getReplies() {
        return replies;
    }

    public void setReplies(ArrayList<Reply> replies) {
        this.replies = replies;
    }

    public int getCorrectAnswerId() {
        return correctAnswerId;
    }

    public void setCorrectAnswerId(int correctAnswerId) {
        this.correctAnswerId = correctAnswerId;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public static boolean add(int content_id,String question){
        String query = "INSERT INTO quiz (content_id,question) VALUES (?,?)";
        try {
            PreparedStatement pr = DbConnector.getInstance().prepareStatement(query);
            pr.setInt(1,content_id);
            pr.setString(2,question);
            int result = pr.executeUpdate();
            pr.close();
            return result != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static Quiz getByContentIdAndQuestion(int content_id,String question){
        String query = "SELECT * FROM quiz WHERE content_id = ? AND question = ?";
        Quiz obj = null;
        try {
            PreparedStatement pr = DbConnector.getInstance().prepareStatement(query);
            pr.setInt(1,content_id);
            pr.setString(2,question);
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                obj = new Quiz(rs.getInt("id"),rs.getInt("content_id"),
                        rs.getString("question"),rs.getInt("correct_answer"));
                break;
            }
            pr.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return obj;

    }

    public static ArrayList<Quiz> getByContentId(int content_id){
        ArrayList<Quiz> quizzes = new ArrayList<>();
        String query = "SELECT * FROM quiz WHERE content_id = ?";
        Quiz obj ;
        try {
            PreparedStatement pr = DbConnector.getInstance().prepareStatement(query);
            pr.setInt(1,content_id);
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                obj = new Quiz(rs.getInt("id"),rs.getInt("content_id"),
                        rs.getString("question"),rs.getInt("correct_answer"));
                quizzes.add(obj);
            }
            pr.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return quizzes;

    }

    public static boolean updateCorrectAnswer(int id,int correctAnswerId){
        String query = "UPDATE quiz SET correct_answer=? WHERE id=?";

        try {
            PreparedStatement pr = DbConnector.getInstance().prepareStatement(query);
            pr.setInt(1,correctAnswerId);
            pr.setInt(2,id);
            int result = pr.executeUpdate();
            pr.close();
            return result !=-1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
