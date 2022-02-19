package com.patikadev.Model;

import com.patikadev.Helper.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Content {
    private int id;
    private int course_id;
    private String title;
    private String description;
    private String youtube_link;
    private ArrayList<Quiz> quizzes;
    private Course course;

    public Content(int id, int course_id, String title, String description, String youtube_link) {
        this.id = id;
        this.course_id = course_id;
        this.title = title;
        this.description = description;
        this.youtube_link = youtube_link;
        this.course = Course.getFetch(course_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYoutube_link() {
        return youtube_link;
    }

    public void setYoutube_link(String youtube_link) {
        this.youtube_link = youtube_link;
    }

    public ArrayList<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(ArrayList<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public static ArrayList<Content> getListByCourseId(int course_id){
        ArrayList<Content> contents = new ArrayList<>();
        String query = "SELECT * FROM content WHERE course_id = "+course_id;
        Content obj;
        try {
            Statement st = DbConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                obj = new Content(rs.getInt("id"),rs.getInt("course_id"),
                        rs.getString("title"),rs.getString("description"),
                        rs.getString("youtube_link"));
                contents.add(obj);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return contents;
    }

    public static Content getById(int content_id){
        String query = "SELECT * FROM content WHERE id = "+content_id;
        Content obj = null;
        try {
            Statement st = DbConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                obj = new Content(rs.getInt("id"),rs.getInt("course_id"),
                        rs.getString("title"),rs.getString("description"),
                        rs.getString("youtube_link"));
                break;
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return obj;
    }

    public static ArrayList<Content> getListByEducatorId(int educator_id){
        ArrayList<Content> contents = new ArrayList<>();
        String query = "SELECT * FROM content WHERE course_id = ANY (SELECT id FROM course WHERE user_id = ?)";
        Content obj;
        try {
            PreparedStatement pr = DbConnector.getInstance().prepareStatement(query);
            pr.setInt(1,educator_id);
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                obj = new Content(rs.getInt("id"),rs.getInt("course_id"),
                        rs.getString("title"),rs.getString("description"),
                        rs.getString("youtube_link"));
                contents.add(obj);
            }
            pr.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return contents;
    }

    public static boolean add(int course_id,String title,String description,String youtube_link){
        String query = "INSERT INTO content (course_id,title,description,youtube_link) VALUES (?,?,?,?)";
        try {
            PreparedStatement pr = DbConnector.getInstance().prepareStatement(query);
            pr.setInt(1,course_id);
            pr.setString(2,title);
            pr.setString(3, description);
            pr.setString(4,youtube_link);
            int result = pr.executeUpdate();
            pr.close();
            return result!=-1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static boolean delete(int content_id){
        String query = "DELETE FROM content WHERE id = "+ content_id;
        try {
            Statement st = DbConnector.getInstance().createStatement();
            int result = st.executeUpdate(query);
            st.close();
            return result !=-1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static boolean update(int id,int course_id,String title,String description,String youtube_link){
        String query = "UPDATE content SET course_id=?,title=?,description=?,youtube_link=? WHERE id = ?";

        try {
            PreparedStatement pr = DbConnector.getInstance().prepareStatement(query);
            pr.setInt(1,course_id);
            pr.setString(2,title);
            pr.setString(3,description);
            pr.setString(4, youtube_link);
            pr.setInt(5,id);
            int result = pr.executeUpdate();
            pr.close();
            return result !=-1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public static ArrayList<Content> searchContentList(String query){
        ArrayList<Content> contents = new ArrayList<>();
        Content obj;
        try {
            Statement st = DbConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                obj = new Content(rs.getInt("id"),rs.getInt("course_id"),
                        rs.getString("title"),rs.getString("description"),
                        rs.getString("youtube_link"));
                contents.add(obj);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return contents;
    }

    public static String searchQuery(int course_id, String title){
        String query = "SELECT * FROM content WHERE title LIKE '%{{title}}%'";
        if(course_id != 0)
            query = query + "AND course_id =" + course_id;
        query = query.replace("{{title}}",title);
        return query;
    }
}
