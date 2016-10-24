package com.kosta._0830.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.kosta._0830.model.PersonDAO;
import com.kosta._0830.model.PersonDTO;
import com.kosta._0830.view.InputForm;
import com.kosta._0830.view.MainView;
import com.kosta._0830.view.UpForm;

public class Controller implements ActionListener{
	/*
	 <��Ʈ�ѷ�(����)�� ����>
	 - ��ü ���α׷��� ���� �帧 ����!!
	 1. ����� ��û �м�
	 2. ����ڰ� �Է��� �����͸� ������
	 3. �𵨰�ü����!! M m = new M();	���� = m.method();
	 4. ������ �̵�
	 �߰��ɼ�) 2���� ����: ��ȿ�� �˻�
	 */
	
	//����
	MainView view_main;
	InputForm view_form;
	UpForm view_upform;
	
	public Controller() {
		view_main = new MainView();
		view_form = new InputForm();
		view_upform = new UpForm();
		
		eventUp();
	}//������
	
	private void eventUp(){
		//���κ�
		view_main.bt_insert.addActionListener(this);
		
		//�Է���
		view_form.bt_cancel.addActionListener(this);
		view_form.bt_submit.addActionListener(this);
		
		//������
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();//��ư�� ���۷��� ������
		if(obj == view_main.bt_insert){//1.����: �Է¹�ư Ŭ���ߴٸ�
			//4.�������̵�
			view_form.initForm();
			view_main.setVisible(false);
			view_form.setVisible(true);
		} else if(obj == view_form.bt_cancel){//1.�Է���: ��ҹ�ư�� Ŭ���ߴٸ�
			//4.�������̵�
			view_form.setVisible(false);
			view_main.setVisible(true);
		} else if(obj == view_form.bt_submit){//1.�Է���: �Է¹�ư�� Ŭ���ߴٸ�
			//2.����ڰ� �Է��� ������ ������
			String name = view_form.tf_name.getText().trim();
			String age = view_form.tf_age.getText().trim();
			String job = view_form.tf_job.getText().trim();
			PersonDTO person = new PersonDTO(0, name, Integer.parseInt(age), job);
			
			//3. �𵨰�ü����
			PersonDAO dao = new PersonDAO();
			
			//boolean flag = dao.insert(person);
			if(dao.insert(person)){//(flag){ //�Է¼���!!
				ArrayList<PersonDTO> list = dao.selectAll();
				view_main.displayTable(list);
				//4. �������̵�
				view_form.setVisible(false);
				view_main.setVisible(true);
			} else {//�Է� ����!!
				JOptionPane.showMessageDialog(view_form, "�Է°��� Ȯ���ϼ���!!");
				view_form.initForm();
			}
		}
	}
	
	public static void main(String[] args) {
		new Controller();
	}
}
