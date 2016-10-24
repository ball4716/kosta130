package com.kosta._0901.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import com.kosta._0901.model.dao.UserInfoDAO;
import com.kosta._0901.model.dto.UserInfo;
import com.kosta._0901.view.JoinForm;
import com.kosta._0901.view.LoginForm;
import com.kosta._0901.view.ServiceForm;
import com.kosta._0901.view.UpdateForm;

public class Controller implements ActionListener {

	LoginForm form_login;
	JoinForm form_join;
	UpdateForm form_update;
	ServiceForm form_service;
	
	boolean checkIdFlag=false;
	String tmpId;

	public Controller() {
		form_login = new LoginForm();
		form_join = new JoinForm();
		form_update = new UpdateForm();
		form_service = new ServiceForm();

		eventUp();
	}

	private void eventUp() {
		// �α�����
		form_login.bt_join.addActionListener(this);
		form_login.bt_login.addActionListener(this);

		// ȸ��������(������)
		form_join.bt_reset.addActionListener(this);// �Էµ� ���� �ʱ�ȭ
		form_join.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// x��ư�� Ŭ��: �α��� ������ �ǵ��ư���
				form_join.setVisible(false);
				form_login.setVisible(true);
			}
		});
		form_join.bt_submit.addActionListener(this);
		form_join.bt_checkid.addActionListener(this);
		
		//������
		form_service.bt_sel_all.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();// actionPerformed()�޼ҵ带 ȣ���� ��ư�� ���۷���!!

		if (obj == form_login.bt_join) {// �α�����: �ű԰��� ��ư Ŭ��
			// �α����� ---> ȸ�������� �̵�
			form_join.initForm();

			form_join.setVisible(true);
			form_login.setVisible(false);
			
			checkIdFlag=false;
		} else if (obj == form_join.bt_reset) {// ȸ��������: ��ҹ�ư Ŭ��
			form_join.initForm();
			checkIdFlag=false;
		} else if (obj == form_join.bt_submit) {// ȸ��������: ��Ϲ�ư Ŭ��
			if (checkIdFlag) {
				// �信 �Էµ� ������ ���
				String id = form_join.tf_id.getText().trim();
				if(tmpId!=null && !tmpId.equals(id)){
					form_join.showMsg("ID �ߺ�üũ�� ���ּ���");
					checkIdFlag=false;
					return;
				}
				String pass = new String(form_join.tf_pass.getPassword()).trim();
				String name = form_join.tf_name.getText().trim();
				String ssn1 = form_join.tf_ssn1.getText().trim();
				String ssn2 = new String(form_join.tf_ssn2.getPassword()).trim();
				String phone = form_join.tf_phone1.getText().trim() + "-" + form_join.tf_phone2.getText().trim() + "-"
						+ form_join.tf_phone3.getText().trim();
				String addr = form_join.tf_addr.getText().trim();
				String job = "" + form_join.cb_job.getSelectedItem();

				// ���� ������ ----> �ϳ��� Ŭ����(�̸�)�� �����ֱ�
				UserInfo user = new UserInfo(id, pass, name, ssn1, ssn2, phone, addr, job);

				// DAO���� ���� //��ȯ�� ����� ���� ����
				if (new UserInfoDAO().insert(user)) {
					form_join.showMsg("������ ȯ���մϴ�!");
					form_join.setVisible(false);
					form_login.setVisible(true);
				} else {
					form_join.showMsg("�ʼ��Է��׸�(ID/���/�̸�)�� �Է����ּ���");
				}
			} else {
				form_join.showMsg("ID �ߺ�üũ�� ���ּ���");
			}

		} else if (obj == form_join.bt_checkid) {
			// ���̵� üũ�� ���� ��, �ߺ�x�϶� checkIdFlag�� true
			String id = form_join.tf_id.getText().trim();
			if(new UserInfoDAO().find(id)==null){
				tmpId=id;
				form_join.showMsg("����� �� �ִ� ID�Դϴ�.");
				checkIdFlag = true;
			} else if("".equals(id)){
				form_join.showMsg("ID�� �Է����ּ���");
			} else {
				form_join.showMsg("����� �� ���� ID�Դϴ�.");
				form_join.tf_id.setText("");
			}
		} else if (obj == form_login.bt_login){
			String id = form_login.tf_id.getText().trim();
			String pass = new String(form_login.tf_pass.getPassword()).trim();
			
			
			//�����͸� DAO���� ����
			UserInfoDAO dao = new UserInfoDAO();
			//boolean flag = dao.findLogin(id, pass);
			String dpass = dao.findLogin3(id);
			
			//������� ���� Action!!
			if(dpass == null){//���̵� ����x
				if(form_login.showConfirm("�������� �ʴ� ���̵��Դϴ�.\nȸ�������Ͻðڽ��ϱ�?")==0){
					form_login.setVisible(false);
					form_join.setVisible(true);
				} else {
					
				}
			} else {//���̵� ���� o
				if(dpass.equals(pass)){//DB����� pass�� ���Էµ� pass��
					//���̵� ����O, ��� ��ġ
					form_login.showMsg("�α��� ����!!");
					form_login.setVisible(false);
					form_service.setVisible(true);
				} else {
					//���̵� ����O, ��� ����ġ
					form_login.showMsg("��й�ȣ�� Ȯ���ϼ���.");
				}
				
			}
			/*if(flag){
				//�α��� ���� �޽���
				form_login.showMsg("�α��� ����!!");
				//�α�����--->����â�̵�
				form_login.setVisible(false);
				form_service.setVisible(true);
			} else {//�α��� ����
				//��
				form_login.showMsg("�α��� ����!!\n���̵� �Ǵ� ����� Ȯ���ϼ���");
			}*/
		} else if(obj == form_service.bt_sel_all){
			UserInfoDAO dao = new UserInfoDAO();
			List<UserInfo> list = dao.findAll();
			if(list != null)
				form_service.displayTable(list);
		}
	}

	public static void main(String[] args) {
		new Controller();
	}
}
