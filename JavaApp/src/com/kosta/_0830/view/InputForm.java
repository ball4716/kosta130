package com.kosta._0830.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kosta.person.model.Person;

public class InputForm extends JFrame{
	
	private JLabel la_name,la_age,la_job;
	public JTextField tf_name,tf_age,tf_job;
	public JButton bt_submit,bt_cancel;
	private JPanel pnl_name,pnl_age,pnl_job,pnl_btn;
	
	public InputForm() {
		
		//컴포넌트 초기화
		la_name = new JLabel("이름");
		la_age = new JLabel("나이");
		la_job = new JLabel("직업");
		
		tf_name = new JTextField(5);
		tf_age = new JTextField(5);
		tf_job = new JTextField(5);
		
		bt_submit = new JButton("입력");
		bt_cancel = new JButton("취소");
		
		//패널 초기화 및 컴포넌트 배치
		pnl_name = new JPanel();
		pnl_name.add(la_name);
		pnl_name.add(tf_name);
		
		pnl_age = new JPanel();
		pnl_age.add(la_age);
		pnl_age.add(tf_age);
		
		pnl_job = new JPanel();
		pnl_job.add(la_job);
		pnl_job.add(tf_job);
		
		pnl_btn = new JPanel();
		pnl_btn.add(bt_submit);
		pnl_btn.add(bt_cancel);
		
		//레이아웃 배치
		setLayout(new GridLayout(6,1,0,45));
		add(new JLabel());
		add(pnl_name);
		add(pnl_age);
		add(pnl_job);
		add(pnl_btn);
		add(new JLabel());
		
		//레이아웃 설정
		setBounds(300,300,300,500);
		//setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//생성자
	
	public void initForm(){//입력폼 초기화
		tf_name.setText("");
		tf_age.setText("");
		tf_job.setText("");
		
		tf_name.requestFocus();//최초 이름필드에 작성이 편하게 포커스 설정
	}

	
	public void showMessage(String msg){
		JOptionPane.showMessageDialog(this,msg);
	}//showMessage
}//InputForm
