package com.kh.part01_main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JoinText extends JFrame {

	public JTextArea textArea;
	 public JRadioButton rbAgree;
	    public JRadioButton rbdisAgree;


	public JoinText() {

		
		setTitle("KHġ ���ε� - ȸ�� ��� ���Ǽ�");
		try {
			this.setIconImage(ImageIO.read(new File("������.PNG")));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		this.setBounds(250, 250, 800, 768);
		this.setLayout(null);

		
		JLabel agreeLabel = new JLabel("ȸ�� ��� ����");
		agreeLabel.setFont(new Font("����",Font.BOLD,40));
		agreeLabel.setBounds(200, 100, 300, 200);
		add(agreeLabel);

        // ȸ����� 
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(200, 365, 342, 115);
        add(scrollPane);
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        scrollPane.setViewportView(textArea);
        textArea.setText("\uC11C\uBE44\uC2A4 \uC774\uC6A9\uC57D\uAD00\r\n\r\n\uC81C1\uC870 (\uC774\uC6A9\uACC4\uC57D\uC758 \uC131\uB9BD)\r\n\uC774\uC6A9\uACC4\uC57D\uC740 \uC774\uC6A9\uC790\uC758 \uC57D\uAD00\uB0B4\uC6A9\uC5D0 \uB300\uD55C \uB3D9\uC758\uC640 \uC774\uC6A9\uC790\uC758 \uC774\uC6A9\uC2E0\uCCAD\uC5D0 \uB300\uD55C  \uC2B9\uB099\uC73C\uB85C \uC131\uB9BD\uD569\uB2C8\uB2E4.\r\n\r\n\uC81C2\uC870 (\uC774\uC6A9\uC2E0\uCCAD)\r\n\uC774\uC6A9\uC2E0\uCCAD\uC740 \uC11C\uBE44\uC2A4\uC758 \uD68C\uC6D0\uC815\uBCF4 \uD654\uBA74\uC5D0\uC11C \uC774\uC6A9\uC790\uAC00  \uC694\uAD6C\uD558\uB294 \uAC00\uC785\uC2E0\uCCAD \uC591\uC2DD\uC5D0 \uAC1C\uC778\uC758 \uC2E0\uC0C1\uC815\uBCF4\uB97C \uAE30\uB85D\uD558\uB294 \uBC29\uC2DD\uC73C\uB85C \uC2E0\uCCAD\uD569\uB2C8\uB2E4.\r\n");

        
        
        
        // ȸ����� ���� or �̵��� ��ư
        ButtonGroup bg = new ButtonGroup();
        rbAgree = new JRadioButton("����");
        rbAgree.setOpaque(false);
        rbAgree.setForeground(Color.BLACK);
        rbAgree.setBounds(280, 500, 71, 27);
        add(rbAgree);
        
        rbdisAgree = new JRadioButton("�̵���");
        rbdisAgree.setOpaque(false);
        rbdisAgree.setForeground(Color.BLACK);
        rbdisAgree.setBounds(390, 500, 139, 27);
        add(rbdisAgree);
        
        bg.add(rbAgree);
        bg.add(rbdisAgree);
    
        rbdisAgree.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
		
				JOptionPane.showMessageDialog(null, "�̵��ǽ� ȸ������ ������ �Ұ����մϴ�.");
				
			}
		});
        
        
        
        //���ǿϷ� ��ư
        JButton agreeBtn = new JButton("���� �Ϸ�");
        agreeBtn.setBounds(230, 550, 100, 30);
        add(agreeBtn);
        
        agreeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(rbAgree.isSelected()) {
				JoinPage jp = new JoinPage();
				dispose();
				}else if(rbdisAgree.isSelected()) {
					JOptionPane.showMessageDialog(null, "�̵��ǽ� ȸ������ ������ �Ұ����մϴ�.");
				}
			}
		});
        
        
        //���
        JButton cancleBtn = new JButton("���");
        cancleBtn.setBounds(400, 550, 100, 30);
        add(cancleBtn);
        
        cancleBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginPage lp = new LoginPage();
			}
		});
        
        
        
        
		
		
   
		
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);//���߾�
		}
	
	


}