package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Helper.Item;
import com.patikadev.Model.Content;
import com.patikadev.Model.Quiz;
import com.patikadev.Model.Reply;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddQuizGUI extends JFrame{
    private JPanel wrapper;
    private JTextField fld_quiz_content_id;
    private JPanel pnl_top;
    private JTextField fld_quiz_question;
    private JTextField fld_quiz_reply_1;
    private JTextField fld_quiz_reply_2;
    private JTextField fld_quiz_reply_3;
    private JButton btn_quiz_update;
    private JComboBox cmb_quiz_replies;
    private JPanel pnl_quiz_form;
    private JButton btn_reply_add;
    private JPanel pnl_reply_form;
    private JPanel pnl_correct_answer;
    private JButton btn_quiz_add;
    private JPanel pnl_quiz_add;

    private Content content;
    private Quiz searchQuiz ;

    public AddQuizGUI(Content content){
        this.content = content;

        Helper.setLayout();
        add(wrapper);
        setSize(400,400);
        setLocation(Helper.screenCenterPoint("x",getSize()),Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        fld_quiz_content_id.setText(String.valueOf(content.getId()));
        pnl_reply_form.setVisible(false);
        pnl_correct_answer.setVisible(false);


        btn_quiz_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Helper.isFieldEmpty(fld_quiz_question)){
                    Helper.showMsg("fill");
                }else{
                    int content_id = Integer.parseInt(fld_quiz_content_id.getText());
                    String question = fld_quiz_question.getText();
                    if(Quiz.add(content_id,question)){
                        searchQuiz = Quiz.getByContentIdAndQuestion(content_id,question);
                        pnl_quiz_add.setVisible(false);
                        pnl_reply_form.setVisible(true);

                    }

                }
            }
        });
        btn_reply_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String reply1 = fld_quiz_reply_1.getText();
                String reply2 = fld_quiz_reply_2.getText();
                String reply3 = fld_quiz_reply_3.getText();

                if(Reply.add(searchQuiz.getId(),reply1) && Reply.add(searchQuiz.getId(),reply2) &&
                        Reply.add(searchQuiz.getId(),reply3)){
                    pnl_reply_form.setVisible(false);
                    pnl_correct_answer.setVisible(true);
                    loadReplyComboByQuizId(searchQuiz.getId());
                }

            }
        });
        btn_quiz_update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item select_item = (Item) cmb_quiz_replies.getSelectedItem();
                int correctAnswerId = select_item.getKey();
                if(Quiz.updateCorrectAnswer(searchQuiz.getId(),correctAnswerId)){
                    Helper.showMsg("done");
                    dispose();
                }
            }
        });
    }

    private void loadReplyComboByQuizId(int quiz_id){
        cmb_quiz_replies.removeAllItems();
        for (Reply obj: Reply.getListByQuizId(quiz_id)){
            cmb_quiz_replies.addItem(new Item(obj.getId(),obj.getReply()));
        }
    }

}
