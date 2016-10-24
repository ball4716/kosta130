package com.kosta.person.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import com.kosta.person.model.Model;
import com.kosta.person.model.Person;
import com.kosta.person.view.InputForm;
import com.kosta.person.view.MainView;

public class Controller implements ActionListener {
	// ��ü ���ø����̼��� �帧 ����

	// ����
	MainView mainView;
	InputForm inputForm;

	// �𵨵��
	Model model;

	int cntNo;
	/*
	 * <��Ʈ�ѷ��� ����> 1. ����� ��û�� ���� �м� 2. ����� �Էµ����͸� ������ 3. �𵨰�ü����. 3_1. �޼ҵ�ȣ�� 3_2.
	 * ���ϵ����͸� ������ ���� 4. ������(������) �̵�
	 * 
	 * �ɼ�) ��ȿ�� �˻�
	 */

	public Controller() {
		mainView = new MainView();
		inputForm = new InputForm();

		model = new Model();

		mainView.displayTable(model.selectAll());

		eventUp();
	}// ������

	private void eventUp() {// �̺�Ʈ �ҽ�- �̺�Ʈ �ڵ鷯 ����
		// mainView ������(������) ���
		mainView.bt_insert.addActionListener(this);
		mainView.bt_delete.addActionListener(this);
		mainView.bt_update.addActionListener(this);
		mainView.bt_exit.addActionListener(this);

		// inputForm ������(������) ���
		inputForm.bt_submit.addActionListener(this);
		inputForm.bt_cancel.addActionListener(this);
		inputForm.tf_name.addActionListener(this);
		

		mainView.table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Object obj = e.getSource();
				if (obj == mainView.table) {
					mainView.updateButtonStateTrue();
				}
			}
		});// ���̺��� 1���� row ���ýø� ������ư Ȱ��ȭ
		
		inputForm.tf_name.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==10)
					inputForm.tf_age.requestFocus();
			}
		});
		
		inputForm.tf_age.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==10)
					inputForm.tf_job.requestFocus();
			}
		});
		
		inputForm.tf_job.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==10)
					inputForm.bt_submit.doClick();
			}
		});

		if (model.persons.size() == 0)
			mainView.deleteButtonStateFalse();
	}

	@Override
	public void actionPerformed(ActionEvent e) {// �̺�Ʈ �ڵ鷯(ó����)
		Object obj = e.getSource();
		

		if (obj == mainView.bt_insert) {// 1. ���ο��� '�Է�'��ư Ŭ��
										// ------> ������ �Է����� ���ߴٸ�
			// 4. �������̵�
			inputForm.initForm();
			mainView.setVisible(false);
			inputForm.setVisible(true);

			// �� Ÿ��Ʋ ����
			inputForm.setTitle("�Է���");
			mainView.updateButtonStateFalse();
			mainView.deleteButtonStateTrue();

		} else if (obj == mainView.bt_delete) {// 1. ���ο��� '����'��ư Ŭ��

			String deleteNoStr = mainView.showInput("������ ���ϴ� ��ȣ�� �Է��ϼ���");
			int deleteNo = 0;
			
			if (deleteNoStr == null)
				return;
			
			if (mainView.showConfirm("������ �����Ͻðڽ��ϱ�?")) {
				
				if (deleteNoStr != null && deleteNoStr.equals("")) {
					mainView.showMessage("��ȣ�� �Էµ��� �ʾҽ��ϴ�");
				} else if (deleteNoStr != null && deleteNoStr.matches("^[1-9]*$")) {
					deleteNo = Integer.parseInt(deleteNoStr);
					if (model.delete(deleteNo))
						mainView.showMessage("�����Ǿ����ϴ�.");
					else
						mainView.showMessage("�������� �ʴ� ��ȣ�Դϴ�.");
				} else {
					mainView.showMessage("1�̻��� ���ڸ� �Է��ϼ���");
				}
				
			} else {
				return;
			}

			mainView.displayTable(model.selectAll());// ������ ���系���� JTable�� ���
			mainView.updateButtonStateFalse();

		} else if (obj == mainView.bt_update) {// 1. ���ο��� '����'��ư Ŭ��
			// �м����: ���������� �����ϰڴ�!!
			// �ʿ��Ѱ�? �������� ���. ������ �ѷ��� ���� �ʿ�!!
			
			if(!isRowSelected()){
				//���� ���� �� ���� ���Ұ��, ��ư ��ü�� ���Ƴ��� ���� �������� ������
				//������ ���� �־���� �ڵ���
				mainView.showMessage("������ ���� �������ּ���");
				return;
			}
			// ������ ���� �����͸� ������ ��������

			int row = mainView.table.getSelectedRow();
			int no = (int) mainView.table.getValueAt(row, 0);
			Person p = model.select(no);

			inputForm.initForm(p);
			// 4. �������̵�
			mainView.setVisible(false);
			inputForm.setVisible(true);

			mainView.updateButtonStateFalse();

		} else if (obj == mainView.bt_exit) {// 4. ���ο��� '����'��ư Ŭ��

			System.exit(0);

		} else if (obj == inputForm.bt_submit) {// 5. ������ '�Է�'��ư Ŭ��
			// 1.�Է������� '�Է�'��ư�� Ŭ���ߴٸ�
			// 1.���������� '����'��ư�� Ŭ���ߴٸ�
			String name = inputForm.tf_name.getText().trim();// 2. //��������
			String ageStr = inputForm.tf_age.getText();
			String job = inputForm.tf_job.getText();// 2.
			int age;
			if (isEmpty(name, ageStr, job)) {
				return;
			} else {
				age = Integer.parseInt(ageStr);// 2.
			}

			if (inputForm.getTitle().equals("�Է���")) {
				cntNo++;// 1 ������ȣ
				Person p = new Person(cntNo, name, age, job);// 3.
				model.insert(p);// 3_1.
			} else {// inputForm.getTitle()=="������"

				int row = mainView.table.getSelectedRow();
				int updateNo = (int) mainView.table.getValueAt(row, 0);
				Person old_p = model.select(updateNo);
				Person update_p = new Person(updateNo, name, age, job);
				model.update(old_p, update_p);

			}

			// Vector<Person> v = model.selectAll();//3_2.
			// mainView.displayTable(v);
			mainView.displayTable(model.selectAll());// ������ ���系���� JTable�� ���

			// 4. �������̵�
			mainView.setVisible(true);
			inputForm.setVisible(false);

		} else if (obj == inputForm.bt_cancel) {

			// 4. �������̵�
			mainView.setVisible(true);
			inputForm.setVisible(false);

		}

	}

	private boolean isEmpty(String name, String ageStr, String job) {
		if(name.equals("")){
		   JOptionPane.showMessageDialog(inputForm, "�̸��Է�!!");
		   inputForm.tf_name.requestFocus();
		}else if(ageStr.length()==0){
			JOptionPane.showMessageDialog(inputForm, "�����Է�!!");
			inputForm.tf_age.requestFocus();
		}else if(job.length()<1){
			JOptionPane.showMessageDialog(inputForm, "�����Է�!!");
			inputForm.tf_job.requestFocus();
		}else{
		   //�̸�,����,������ ���� �ԷµǾ��ٸ�
			return false;
		}
		return true;
	}// �� ��� Ȯ��
	
	private boolean isRowSelected(){
		for (int i = 0; i < mainView.table.getRowCount(); i++) {
			if(mainView.table.isRowSelected(i))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		new Controller();
	}
}
