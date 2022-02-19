package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Helper.Item;
import com.patikadev.Model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EducatorGUI extends JFrame{
    private JPanel wrapper;
    private JPanel pnl_top;
    private JLabel lbl_welcome;
    private JTabbedPane tab_operator;
    private JPanel pnl_course_list;
    private JScrollPane scrl_course_list;
    private JTable tbl_course_list;
    private JButton btn_logout;
    private JPanel pnl_content_list;
    private JScrollPane scrl_content_list;
    private JTable tbl_content_list;
    private JPanel pnl_content_form;
    private JComboBox cmb_content_course_list;
    private JTextField fld_content_title;
    private JTextField fld_content_youtube_link;
    private JTextArea fld_content_description;
    private JButton btn_content_add;
    private JTextField fld_content_Id;
    private JButton btn_content_delete;
    private JPanel pnl_content_search;
    private JComboBox cmb_content_course_search;
    private JButton btn_content_search;
    private JTextField fld_content_title_search;

    private DefaultTableModel mdl_course_list;
    private Object[] row_course_list;

    private DefaultTableModel mdl_content_list;
    private Object[] row_content_list;

    private JPopupMenu contentMenu;

    private Educator educator;

    public EducatorGUI(Educator educator){
        this.educator = educator;

        Helper.setLayout();
        add(wrapper);
        setSize(1000,700);
        setLocation(Helper.screenCenterPoint("x",getSize()),Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        lbl_welcome.setText("Hoşgeldin Hocam : " + educator.getName());

        // Model Course List
        mdl_course_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0){
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_course_list = {"Id","Kurs Adı","Dili","Patika","Hoca"};
        mdl_course_list.setColumnIdentifiers(col_course_list);
        row_course_list = new Object[col_course_list.length];
        loadCourseModel();

        tbl_course_list.setModel(mdl_course_list);
        tbl_course_list.getTableHeader().setReorderingAllowed(false);
        tbl_course_list.getColumnModel().getColumn(0).setMaxWidth(80);

        // Model Content List
        contentMenu = new JPopupMenu();
        JMenuItem quizMenu = new JMenuItem("Quiz Ekle");
        contentMenu.add(quizMenu);

        quizMenu.addActionListener(e -> {
            int select_id = Integer.parseInt(tbl_content_list.getValueAt(tbl_content_list.getSelectedRow(),0).toString());
            Content findContent = Content.getById(select_id);
            if(findContent == null){
                Helper.showMsg("İçerik bulunamadı");
            }else{
                AddQuizGUI addQuizGUI = new AddQuizGUI(findContent);
                addQuizGUI.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        loadContentModel();
                    }
                });
            }
        });


        mdl_content_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row,int column){
                if(column == 0){
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_content_list = {"Id","Başlık","Açıklama","Youtube","Kurs ID","Kurs Adı","Toplam Quiz"};
        mdl_content_list.setColumnIdentifiers(col_content_list);
        row_content_list = new Object[col_content_list.length];
        loadContentModel();

        tbl_content_list.setModel(mdl_content_list);
        tbl_content_list.setComponentPopupMenu(contentMenu);
        tbl_content_list.getTableHeader().setReorderingAllowed(false);
        tbl_content_list.getColumnModel().getColumn(0).setMaxWidth(80);

        tbl_content_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selected_row = tbl_content_list.rowAtPoint(point);
                tbl_content_list.setRowSelectionInterval(selected_row,selected_row);
            }
        });

        tbl_content_list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    String selected_content_id = tbl_content_list.getValueAt(tbl_content_list.getSelectedRow(),0).toString();
                    fld_content_Id.setText(selected_content_id);
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        });

        tbl_content_list.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if(e.getType()==TableModelEvent.UPDATE){
                    int content_id = Integer.parseInt(tbl_content_list.getValueAt(tbl_content_list.getSelectedRow(),0).toString());
                    int course_id =  Integer.parseInt(tbl_content_list.getValueAt(tbl_content_list.getSelectedRow(),4).toString());
                    String title = tbl_content_list.getValueAt(tbl_content_list.getSelectedRow(),1).toString();
                    String description = tbl_content_list.getValueAt(tbl_content_list.getSelectedRow(),2).toString();
                    String youtube_link = tbl_content_list.getValueAt(tbl_content_list.getSelectedRow(),3).toString();
                    if(Content.update(content_id,course_id,title,description,youtube_link)){
                        Helper.showMsg("done");
                    }else{
                        Helper.showMsg("error");
                    }
                    loadContentModel();
                }
            }
        });




        btn_logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
                LoginGUI loginGUI = new LoginGUI();
            }
        });


        btn_content_add.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_content_title) || fld_content_description.getText()=="" || Helper.isFieldEmpty(fld_content_youtube_link)){
                Helper.showMsg("fill");
            }else {
                Item select_item = (Item) cmb_content_course_list.getSelectedItem();
                int course_id = select_item.getKey();
                String title = fld_content_title.getText();
                String description = fld_content_description.getText();
                String youtube_link = fld_content_youtube_link.getText();
                if (Content.add(course_id, title, description, youtube_link)) {
                    loadContentModel();
                    Helper.showMsg("done");
                    fld_content_description.setText(null);
                    fld_content_title.setText(null);
                    fld_content_youtube_link.setText(null);
                }else{
                    Helper.showMsg("error");
                }
            }
        });
        btn_content_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Helper.isFieldEmpty(fld_content_Id)){
                    Helper.showMsg("fill");
                }else{
                    int content_id = Integer.parseInt(fld_content_Id.getText());
                    if(Content.delete(content_id)){
                        loadContentModel();
                        Helper.showMsg("done");
                    }else{
                        Helper.showMsg("error");
                    }
                }
            }
        });
        btn_content_search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item select_item = (Item) cmb_content_course_search.getSelectedItem();
                int course_id = select_item.getKey();
                String title = fld_content_title_search.getText();
                String query = Content.searchQuery(course_id,title);
                ArrayList<Content> searchingList = Content.searchContentList(query);
                loadContentModel(searchingList);
            }
        });
        tab_operator.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadContentModel();
            }
        });
    }

    private void loadContentModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_content_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for(Content obj:Content.getListByEducatorId(educator.getId())){
            i = 0;
            row_content_list[i++] = obj.getId();
            row_content_list[i++] = obj.getTitle();
            row_content_list[i++] = obj.getDescription();
            row_content_list[i++] = obj.getYoutube_link();
            row_content_list[i++] = obj.getCourse_id();
            row_content_list[i++] = obj.getCourse().getName();
            row_content_list[i++] = Quiz.getByContentId(obj.getId()).size();
            mdl_content_list.addRow(row_content_list);
        }
    }
    private void loadContentModel(ArrayList<Content> searchingList) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_content_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for(Content obj:searchingList){
            i = 0;
            row_content_list[i++] = obj.getId();
            row_content_list[i++] = obj.getTitle();
            row_content_list[i++] = obj.getDescription();
            row_content_list[i++] = obj.getYoutube_link();
            row_content_list[i++] = obj.getCourse_id();
            row_content_list[i++] = obj.getCourse().getName();
            row_content_list[i++] = Quiz.getByContentId(obj.getId()).size();
            mdl_content_list.addRow(row_content_list);
        }
    }

    private void loadCourseModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_course_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for(Course obj:Course.getListByUserId(educator.getId())){
            i = 0;
            row_course_list[i++] = obj.getId();
            row_course_list[i++] = obj.getName();
            row_course_list[i++] = obj.getLang();
            row_course_list[i++] = obj.getPatika().getName();
            row_course_list[i++] = obj.getEducator().getName();
            mdl_course_list.addRow(row_course_list);
        }

        loadCourseCombo();
    }

    private void loadCourseCombo(){
        cmb_content_course_list.removeAllItems();
        cmb_content_course_search.removeAllItems();
        //cmb_content_course_search.addItem(new Item(0,"")); //bu sebeble iligisi olamayan diğer userların kurs listesini veriyor
        for(Course obj : Course.getListByUserId(educator.getId())){
            cmb_content_course_search.addItem(new Item(obj.getId(),obj.getName()+"-"+obj.getPatika().getName()));
            cmb_content_course_list.addItem(new Item(obj.getId(),obj.getName()+"-"+obj.getPatika().getName()));
        }
    }
}
