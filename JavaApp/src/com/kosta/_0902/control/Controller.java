package com.kosta._0902.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import com.kosta._0902.model.dao.UserInfoDAO;
import com.kosta._0902.model.dto.UserInfo;
import com.kosta._0902.view.JoinForm;
import com.kosta._0902.view.LoginForm;
import com.kosta._0902.view.ServiceForm;
import com.kosta._0902.view.UpdateForm;

public class Controller implements ActionListener {

	LoginForm form_login;
	JoinForm form_join;
	UpdateForm form_update;
	ServiceForm form_service;

	boolean checkIdFlag = false;
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

		// ������
		form_service.bt_sel_all.addActionListener(this);
		form_service.bt_up.addActionListener(this);
		form_service.bt_sel_name.addActionListener(this);

		// ������
		form_update.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// x��ư�� Ŭ��: �α��� ������ �ǵ��ư���
				form_update.setVisible(false);
				form_service.setVisible(true);
			}
		});
		form_update.bt_submit.addActionListener(this);

		// ����
		form_service.bt_del.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();// actionPerformed()�޼ҵ带 ȣ���� ��ư�� ���۷���!!

		if (obj == form_login.bt_join) {// �α�����: �ű԰��� ��ư Ŭ��
			// �α����� ---> ȸ�������� �̵�
			form_join.initForm();

			form_join.setVisible(true);
			form_login.setVisible(false);

			checkIdFlag = false;
		} else if (obj == form_join.bt_reset) {// ȸ��������: ��ҹ�ư Ŭ��
			form_join.initForm();
			checkIdFlag = false;
		} else if (obj == form_join.bt_submit) {// ȸ��������: ��Ϲ�ư Ŭ��
			String validMsg = form_join.validCheck();
			if (validMsg != null){
				form_join.showMsg(validMsg);
				return;
			}
			if (checkIdFlag) {
				// �信 �Էµ� ������ ���
				String id = form_join.tf_id.getText().trim();
				if (tmpId != null && !tmpId.equals(id)) {
					form_join.showMsg("ID �ߺ�üũ�� ���ּ���");
					checkIdFlag = false;
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
			if ("".equals(id)) {
				form_join.showMsg("ID�� �Է����ּ���");
				return;
			}
			if (new UserInfoDAO().select(id) == null) {
				tmpId = id;
				form_join.showMsg("����� �� �ִ� ID�Դϴ�.");
				checkIdFlag = true;
			} else {
				form_join.showMsg("����� �� ���� ID�Դϴ�.");
				form_join.tf_id.setText("");
			}
		} else if (obj == form_login.bt_login) {
			String id = form_login.tf_id.getText().trim();
			String pass = new String(form_login.tf_pass.getPassword()).trim();

			// �����͸� DAO���� ����
			UserInfoDAO dao = new UserInfoDAO();
			// boolean flag = dao.findLogin(id, pass);
			String dpass = dao.findLogin3(id);

			// ������� ���� Action!!
			if (dpass == null) {// ���̵� ����x
				if (form_login.showConfirm("�������� �ʴ� ���̵��Դϴ�.\nȸ�������Ͻðڽ��ϱ�?") == 0) {
					form_login.setVisible(false);
					form_join.setVisible(true);
				}
				form_login.initForm();
			} else {// ���̵� ���� o
				if (dpass.equals(pass)) {// DB����� pass�� ���Էµ� pass��
					// ���̵� ����O, ��� ��ġ
					form_login.showMsg("�α��� ����!!");

					// ����â��(JTable)�� �ѷ��� (DB)�����͸� ��û
					List<UserInfo> list = dao.findAll();
					if (list != null)
						form_service.displayTable(list);

					form_login.setVisible(false);
					form_service.setVisible(true);
				} else {
					// ���̵� ����O, ��� ����ġ
					form_login.showMsg("��й�ȣ�� Ȯ���ϼ���.");
					form_login.initForm();
				}

			}

		} else if (obj == form_service.bt_sel_all) {
			List<UserInfo> list = new UserInfoDAO().findAll();
			if (list != null)
				form_service.displayTable(list);
		} else if (obj == form_service.bt_up) {// ����â: ������ư Ŭ��
			// �Ǵ�: ���������ϰڴ�!!
			// �׼�: ��κ��� ������ϴ� ID, DB������ ���, ������ ���̱�

			// 1. JTable���� ���õ� id ��� 2. DB������() ���
			int row = form_service.table.getSelectedRow();
			if (row == -1)
				return;
			UserInfo user = new UserInfoDAO().select(form_service.dtm.getValueAt(row, 0).toString());
			System.out.println(form_service.dtm.getValueAt(row, 0).toString());
			if (user == null)
				return;
			form_update.tf_id.setText(user.getId());
			form_update.tf_id.setEnabled(false);
			form_update.tf_pass.setText(user.getPass());
			form_update.tf_name.setText(user.getName());
			form_update.tf_ssn1.setText(user.getSsn1());
			form_update.tf_ssn1.setEnabled(false);
			form_update.tf_ssn2.setText(user.getSsn2());
			form_update.tf_ssn2.setEnabled(false);
			form_update.tf_phone1.setText(user.getPhone().substring(0, user.getPhone().indexOf("-")));
			form_update.tf_phone2.setText(
					user.getPhone().substring(user.getPhone().indexOf("-") + 1, user.getPhone().lastIndexOf("-")));
			form_update.tf_phone3.setText(user.getPhone().substring(user.getPhone().lastIndexOf("-") + 1));
			form_update.tf_addr.setText(user.getAddr());
			form_update.cb_job.setSelectedItem(user.getJob());

			form_service.setVisible(false);
			form_update.setVisible(true);

		} else if (obj == form_update.bt_reset) {
			form_update.tf_pass.setText("");
			form_update.tf_pass2.setText("");
			form_update.tf_name.setText("");
			form_update.tf_phone1.setText("");
			form_update.tf_phone2.setText("");
			form_update.tf_phone3.setText("");
			form_update.tf_addr.setText("");
			form_update.cb_job.setSelectedIndex(0);
		} else if (obj == form_update.bt_submit) {
			String phone = form_update.tf_phone1.getText() + "-" + form_update.tf_phone2.getText() + "-"
					+ form_update.tf_phone3.getText();
			if (form_update.tf_pass.getPassword() == null || "".equals(form_update.tf_pass.getPassword())) {
				form_update.showMsg("��й�ȣ�� �Է��ϼ���.");
				return;
			}
			if (form_update.tf_name.getText() == null || "".equals(form_update.tf_name.getText())) {
				form_update.showMsg("�̸��� �Է��ϼ���.");
				return;
			}

			UserInfo user = new UserInfo(form_update.tf_id.getText(), form_update.tf_pass.getPassword().toString(),
					form_update.tf_name.getText(), null, null, phone, form_update.tf_addr.getText(),
					form_update.cb_job.getSelectedItem().toString());

			if (new UserInfoDAO().update(user)) {
				form_update.showMsg("������ �Ϸ�Ǿ����ϴ�");
				UserInfoDAO dao = new UserInfoDAO();
				if (dao.findAll() != null)
					form_service.displayTable(dao.findAll());
				form_update.setVisible(false);
				form_service.setVisible(true);
			} else {
				form_update.showMsg("�Էµ����͸� Ȯ���ϼ���!");
				form_update.tf_pass2.setText("");
			}
		} else if (obj == form_service.bt_del) {// ����â: ������ư Ŭ��
			// �Ǵ�: ȸ�������� �����Ϸ� �ϴ±���!!
			// �׼�: �����Ϸ��� ����, DB ����

			// 1. (Ư����) ������ ����: ���̵� �Է� ---> inputDialog
			String delId = form_service.showInputDialog("������ ���̵� �Է��ϼ���.");
			if (delId == null) {
				return;
			} else if (delId.equals("")) {
				form_service.showMsg("������ ���̵� �Է����ּ���");
				return;
			}
			// 2. DB ---> Ư�� ���� ���� : DAO (delete) 3. ������ �� �� ������� ���� ����
			UserInfoDAO dao = new UserInfoDAO();
			if (dao.delete(delId)) {
				form_service.showMsg("������ �Ϸ�Ǿ����ϴ�");
				if (dao.findAll() != null)
					form_service.displayTable(dao.findAll());
			} else {
				form_service.showMsg("������ ���̵� �������� �ʽ��ϴ�.");
			}

		} else if (obj == form_service.bt_sel_name) {// ����â: '�̸��˻�'��ư Ŭ��
			// �Ǵ�: Ư���� ���ڷ� �����ϴ� �̸��鸸 �˻��Ϸ��� �ϴ±���
			// �׼�: Ư�����ڷ� �����ϴ� �̸��� ���� ��˻�

			// 1. �˻��ϰ��� �ϴ� �����̸� ���� �Է�!! inputDialog
			String findId = form_service.showInputDialog("�˻��� �̸��� �Է��ϼ���");
			// 2. DB ---> Ư�����ڷ� �����ϴ� �̸��˻�: DAO (findByName)
			UserInfoDAO dao = new UserInfoDAO();
			List<UserInfo> list = dao.find(findId);
			if (list == null) {
				form_service.showMsg("�ش� �̸��� �������� �ʽ��ϴ�.");
			} else {
				form_service.displayTable(list);
			}
			// 3. �˻������ ��(Jtable)�� ���
		} else if (obj == form_service.bt_exit) {// ����â: �����ư Ŭ��
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new Controller();
	}
}
