package com.kh.view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.kh.user.controller.UserManager;
import com.kh.user.model.vo.User;

public class Admin extends JFrame {

   String userId;
   String userName;
   String email;
   JTable table1;
   DefaultTableModel model1;
   int removeCnt;
   String header[] = { "아이디", "이름", "이메일","신고내역" };
   String contents[][] = {};
   UserManager um = new UserManager();
   // String userId,String username,String email,int removeCnt

   public Admin() {

   }

   public void Adminsd() {
      um.readAllUser();
      ArrayList<User> list = um.readAllUser();

      model1 = new DefaultTableModel(contents, header) {

         public boolean isCellEditable(int i, int c) {
            return false;
         }
      };
      JTable table1 = new JTable(model1);
      table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      for (int i = 0; i < list.size(); i++) {
         model1.insertRow(0,
               new Object[] { list.get(i).getUserId(), list.get(i).getUserName(), list.get(i).getEmail() });
         table1.updateUI();
         

      }

      Font font = new Font("고딕", Font.BOLD, 15);

      this.setBounds(500, 200, 500, 500);

      JPanel adPanel = new JPanel();
      adPanel.setBackground(new Color(195, 245, 230));
      adPanel.setBounds(330, 60, 400, 400);
      adPanel.setLayout(null);

      JButton userListbt = new JButton("유저 관리");
      userListbt.setSize(120, 30);
      userListbt.setLocation(50, 50);
      userListbt.setFont(font);

      JButton asd = new JButton("asd");
      asd.setSize(120, 30);
      asd.setLocation(300, 50);
      asd.setFont(font);

      Dialog userDl = new Dialog(this, "관리자");
      userDl.setBounds(500, 300, 700, 700);

      JPanel userDlPl = new JPanel();
      userDlPl.setBackground(new Color(195, 245, 230));
      userDlPl.setBounds(500, 300, 700, 700);

      userDlPl.add(table1);

      JScrollPane scPanel = new JScrollPane(table1);
      scPanel.setBounds(500, 300, 700, 700);
      scPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      userDlPl.add(scPanel);

      JButton corUser = new JButton("수정");
      corUser.setSize(20, 20);

      JButton delUser = new JButton("삭제");
      delUser.setSize(20, 20);
      
      JButton delDlPl = new JButton("뒤로");
      delDlPl.setSize(20,20);

      Dialog corDl = new Dialog(this, "수정");
      corDl.setBounds(600, 400, 400, 400);
      corDl.setBackground(new Color(195, 245, 230));
      JPanel corDlPl = new JPanel();
      corDlPl.setBounds(400, 400, 400, 400);
      corDlPl.setLayout(null);
      JTextField userId = new JTextField();
      userId.setSize(200, 30);
      userId.setLocation(90, 30);

      JTextField userName = new JTextField();
      userName.setSize(200, 30);
      userName.setLocation(90, 90);

      JTextField userMail = new JTextField();
      userMail.setSize(200, 30);
      userMail.setLocation(90, 150);

      JTextField userReport = new JTextField();
      userReport.setSize(200, 30);
      userReport.setLocation(90, 210);

      JLabel idLabel = new JLabel("아이디");
      idLabel.setSize(60, 30);
      idLabel.setLocation(10, 30);

      JLabel nameLabel = new JLabel("이름");
      nameLabel.setSize(60, 30);
      nameLabel.setLocation(10, 90);

      JLabel mailLabel = new JLabel("메일");
      mailLabel.setSize(60, 30);
      mailLabel.setLocation(10, 150);

      JLabel reportLabel = new JLabel("신고");
      reportLabel.setSize(60, 30);
      reportLabel.setLocation(10, 210);

      JButton corOk = new JButton("확인");
      corOk.setSize(60, 30);
      corOk.setLocation(280, 270);

      corDl.add(corDlPl);
      corDlPl.add(userId);
      corDlPl.add(userName);
      corDlPl.add(userMail);
      corDlPl.add(userReport);
      corDlPl.add(idLabel);
      corDlPl.add(nameLabel);
      corDlPl.add(mailLabel);
      corDlPl.add(reportLabel);
      corDlPl.add(corOk);
      userDlPl.add(corUser);
      userDlPl.add(delUser);
      userDlPl.add(delDlPl);
      delDlPl.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			userDl.dispose();
		}
	});
      userListbt.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            userDl.setVisible(true);
         }
      });
      corUser.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
        	
            corDl.setVisible(true);

         }
      });
      
		
      
      delUser.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
        	 if (table1.getSelectedRow() != -1) {
        		
        		 System.out.println((String)model1.getValueAt(table1.getSelectedRow(),0));
        		 um.userDelete( (String)model1.getValueAt(table1.getSelectedRow(),0));
        		 model1.removeRow(table1.getSelectedRow());
        		 System.out.println(list.size());
        	// um.userDelete();
        	 
        	 
           // for (int i = 0; i < list.size(); i++) {
                    	           	           	          	
//               if ((model1.getValueAt(table1.getSelectedRow(), 0)).equals(list.get(i).getUserId())) {
//                  model1.removeRow(table1.getSelectedRow());
//                  um.userDelete(i);
//               }
//            	
//            	
//            	
//               table1.updateUI();

            }

         }
      });
      
      //회원정보 수정하고 ok 
      corOk.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//
			/*userId.getText();
			userName.getText();
			userMail.getText();
			userReport.getText();*/
			
			corDl.dispose();
			
		}
	});
      userDl.add(userDlPl);
      adPanel.add(asd);
      adPanel.add(userListbt);
      adPanel.setLayout(null);

      this.add(adPanel);
      this.setVisible(true);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static void main(String[] args) {
      Admin a = new Admin();
      a.Adminsd();

   }
}