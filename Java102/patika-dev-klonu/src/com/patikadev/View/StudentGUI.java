package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Helper.Item;
import com.patikadev.Model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGUI extends JFrame{
    private JPanel wrapper;
    private JPanel pnl_top;
    private JTabbedPane tbb_bottom;
    private JPanel pnl_patika_course_list;
    private JPanel pnl_patika_course_search;
    private JComboBox cmb_patika_course_search;
    private JButton btn_patika_course_search;
    private JButton btn_patika_course_go;
    private JTable tbl_patika_course_list;
    private JPanel pnl_course;
    private JPanel pnl_course_top;
    private JScrollPane scrl_cource_content_list;
    private JTable tbl_course_content_list;
    private JLabel lbl_welcome;
    private JButton btn_course_register;
    private JPanel pnl_content_form;
    private JTextField fld_course_isCompleted;
    private JButton btn_course_completed;
    private JButton btn_student_logout;

    private DefaultTableModel mdl_patika_course;
    private Object[] row_patika_course;

    private DefaultTableModel mdl_course_content;
    private Object[] row_course_content;

    private int courseId;
    private String courseName;

    private Student student;
    public StudentGUI(Student student){
        this.student = student;

        Helper.setLayout();
        add(wrapper);
        setSize(1000,500);
        setLocation(Helper.screenCenterPoint("x",getSize()),Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        lbl_welcome.setText("Hoşgediniz : " + student.getName());
        pnl_course.setVisible(false);
        btn_course_register.setVisible(false);

        //Model Patika kursları
        mdl_patika_course = new DefaultTableModel();
        Object[] col_patika_course = {"Id","Kurs Adı","Hoca Adı","Dili","Patika"};
        mdl_patika_course.setColumnIdentifiers(col_patika_course);
        row_patika_course = new Object[col_patika_course.length];
        loadPatikaCombo();


        btn_patika_course_search.addActionListener(e -> {
            Item select_item = (Item) cmb_patika_course_search.getSelectedItem();
            int patika_id = select_item.getKey();
            loadCourseModel(patika_id);
        });

        tbl_patika_course_list.setModel(mdl_patika_course);
        tbl_patika_course_list.getColumnModel().getColumn(0).setMaxWidth(70);
        tbl_patika_course_list.getTableHeader().setReorderingAllowed(false);

        tbl_patika_course_list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try{
                    String select_course_id = tbl_patika_course_list.getValueAt(tbl_patika_course_list.getSelectedRow(),0).toString();
                    String select_course_name = tbl_patika_course_list.getValueAt(tbl_patika_course_list.getSelectedRow(),1).toString();
                    courseId = Integer.parseInt(select_course_id);
                    courseName = select_course_name;
                    if(StudentCourse.getByUserIdAndCourseId(student.getId(),courseId)==null){
                        btn_course_register.setVisible(true);
                    }else{
                        btn_course_register.setVisible(false);
                    }
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        });

        // Model Course content
        mdl_course_content = new DefaultTableModel();
        Object[] col_course_content = {"Id","Title","Description","Youtube Link","Quizes"};
        mdl_course_content.setColumnIdentifiers(col_course_content);
        row_course_content = new Object[col_course_content.length];


        btn_patika_course_go.addActionListener(e -> {
            StudentCourse studentCourse =StudentCourse.getByUserIdAndCourseId(student.getId(),courseId);
            if(studentCourse==null){
                Helper.showMsg("Önce kursa kayıt olunmalıdır");
            }else{
                loadContentModel(courseId);
                pnl_course.setVisible(true);
                tbb_bottom.addTab(courseName,pnl_course);
                fld_course_isCompleted.setText(studentCourse.isCompleted()?"Tamamlandı":"Devam Ediyor");
            }
        });

        tbl_course_content_list.setModel(mdl_course_content);
        tbl_course_content_list.getColumnModel().getColumn(0).setMaxWidth(60);
        tbl_course_content_list.getTableHeader().setReorderingAllowed(false);

        btn_course_register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(StudentCourse.getByUserIdAndCourseId(student.getId(), courseId)!=null){
                    Helper.showMsg("Bu kursa zaten kayıtlıdır");
                }else{
                    if(StudentCourse.add(student.getId(),courseId,false)){
                        Helper.showMsg("done");
                        btn_course_register.setVisible(false);
                    }else{
                        Helper.showMsg("error");
                    }
                }

            }
        });
        btn_course_completed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(StudentCourse.update(student.getId(),courseId,true)){
                    Helper.showMsg("done");
                    fld_course_isCompleted.setText("Tamamlandı");
                }else{
                    Helper.showMsg("error");
                }
            }
        });
        btn_student_logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginGUI loginGUI = new LoginGUI();
                dispose();
            }
        });
    }

    private void loadCourseModel(int patika_id){
        DefaultTableModel clearModel = (DefaultTableModel) tbl_patika_course_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for(Course obj:Course.getListByPatikaId(patika_id)){
            i = 0;
            row_patika_course[i++] = obj.getId();
            row_patika_course[i++] = obj.getName();
            row_patika_course[i++] = obj.getEducator().getName();
            row_patika_course[i++] = obj.getLang();
            row_patika_course[i++] = obj.getPatika().getName();
            mdl_patika_course.addRow(row_patika_course);
        }
    }

    private void loadContentModel(int course_id){
        DefaultTableModel clearModel = (DefaultTableModel) tbl_course_content_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for(Content obj: Content.getListByCourseId(course_id)){
            i = 0;
            row_course_content[i++] = obj.getId();
            row_course_content[i++] = obj.getTitle();
            row_course_content[i++] = obj.getDescription();
            row_course_content[i++] = obj.getYoutube_link();
            row_course_content[i++] = Quiz.getByContentId(obj.getId()).size();
            mdl_course_content.addRow(row_course_content);
        }
    }

    public void loadPatikaCombo(){
        cmb_patika_course_search.removeAllItems();
        for (Patika obj: Patika.getList()){
            cmb_patika_course_search.addItem(new Item(obj.getId(),obj.getName()));
        }
    }
}
