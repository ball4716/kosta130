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
		// 로그인폼
		form_login.bt_join.addActionListener(this);
		form_login.bt_login.addActionListener(this);

		// 회원가입폼(조인폼)
		form_join.bt_reset.addActionListener(this);// 입력된 값을 초기화
		form_join.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// x버튼을 클릭: 로그인 폼으로 되돌아가기
				form_join.setVisible(false);
				form_login.setVisible(true);
			}
		});
		form_join.bt_submit.addActionListener(this);
		form_join.bt_checkid.addActionListener(this);

		// 서비스폼
		form_service.bt_sel_all.addActionListener(this);
		form_service.bt_up.addActionListener(this);
		form_service.bt_sel_name.addActionListener(this);

		// 수정폼
		form_update.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// x버튼을 클릭: 로그인 폼으로 되돌아가기
				form_update.setVisible(false);
				form_service.setVisible(true);
			}
		});
		form_update.bt_submit.addActionListener(this);

		// 삭제
		form_service.bt_del.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();// actionPerformed()메소드를 호출한 버튼의 레퍼런스!!

		if (obj == form_login.bt_join) {// 로그인폼: 신규가입 버튼 클릭
			// 로그인폼 ---> 회원가입폼 이동
			form_join.initForm();

			form_join.setVisible(true);
			form_login.setVisible(false);

			checkIdFlag = false;
		} else if (obj == form_join.bt_reset) {// 회원가입폼: 취소버튼 클릭
			form_join.initForm();
			checkIdFlag = false;
		} else if (obj == form_join.bt_submit) {// 회원가입폼: 등록버튼 클릭
			String validMsg = form_join.validCheck();
			if (validMsg != null){
				form_join.showMsg(validMsg);
				return;
			}
			if (checkIdFlag) {
				// 뷰에 입력된 데이터 얻기
				String id = form_join.tf_id.getText().trim();
				if (tmpId != null && !tmpId.equals(id)) {
					form_join.showMsg("ID 중복체크를 해주세요");
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

				// 여러 데이터 ----> 하나의 클래스(이름)로 묶어주기
				UserInfo user = new UserInfo(id, pass, name, ssn1, ssn2, phone, addr, job);

				// DAO에게 전달 //반환된 결과에 따라 진행
				if (new UserInfoDAO().insert(user)) {
					form_join.showMsg("가입을 환영합니다!");
					form_join.setVisible(false);
					form_login.setVisible(true);
				} else {
					form_join.showMsg("필수입력항목(ID/비번/이름)을 입력해주세요");
				}
			} else {
				form_join.showMsg("ID 중복체크를 해주세요");
			}

		} else if (obj == form_join.bt_checkid) {
			// 아이디 체크후 디비와 비교, 중복x일때 checkIdFlag를 true
			String id = form_join.tf_id.getText().trim();
			if ("".equals(id)) {
				form_join.showMsg("ID를 입력해주세요");
				return;
			}
			if (new UserInfoDAO().select(id) == null) {
				tmpId = id;
				form_join.showMsg("사용할 수 있는 ID입니다.");
				checkIdFlag = true;
			} else {
				form_join.showMsg("사용할 수 없는 ID입니다.");
				form_join.tf_id.setText("");
			}
		} else if (obj == form_login.bt_login) {
			String id = form_login.tf_id.getText().trim();
			String pass = new String(form_login.tf_pass.getPassword()).trim();

			// 데이터를 DAO에게 전달
			UserInfoDAO dao = new UserInfoDAO();
			// boolean flag = dao.findLogin(id, pass);
			String dpass = dao.findLogin3(id);

			// 결과값에 따른 Action!!
			if (dpass == null) {// 아이디 존재x
				if (form_login.showConfirm("존재하지 않는 아이디입니다.\n회원가입하시겠습니까?") == 0) {
					form_login.setVisible(false);
					form_join.setVisible(true);
				}
				form_login.initForm();
			} else {// 아이디 존재 o
				if (dpass.equals(pass)) {// DB저장된 pass와 뷰입력된 pass비교
					// 아이디 존재O, 비번 일치
					form_login.showMsg("로그인 성공!!");

					// 서비스창에(JTable)에 뿌려줄 (DB)데이터를 요청
					List<UserInfo> list = dao.findAll();
					if (list != null)
						form_service.displayTable(list);

					form_login.setVisible(false);
					form_service.setVisible(true);
				} else {
					// 아이디 존재O, 비번 불일치
					form_login.showMsg("비밀번호를 확인하세요.");
					form_login.initForm();
				}

			}

		} else if (obj == form_service.bt_sel_all) {
			List<UserInfo> list = new UserInfoDAO().findAll();
			if (list != null)
				form_service.displayTable(list);
		} else if (obj == form_service.bt_up) {// 서비스창: 수정버튼 클릭
			// 판단: 정보수정하겠다!!
			// 액션: 뷰로부터 얻고자하는 ID, DB데이터 얻기, 수정폼 보이기

			// 1. JTable부터 선택된 id 얻기 2. DB데이터() 얻기
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
				form_update.showMsg("비밀번호를 입력하세요.");
				return;
			}
			if (form_update.tf_name.getText() == null || "".equals(form_update.tf_name.getText())) {
				form_update.showMsg("이름을 입력하세요.");
				return;
			}

			UserInfo user = new UserInfo(form_update.tf_id.getText(), form_update.tf_pass.getPassword().toString(),
					form_update.tf_name.getText(), null, null, phone, form_update.tf_addr.getText(),
					form_update.cb_job.getSelectedItem().toString());

			if (new UserInfoDAO().update(user)) {
				form_update.showMsg("수정이 완료되었습니다");
				UserInfoDAO dao = new UserInfoDAO();
				if (dao.findAll() != null)
					form_service.displayTable(dao.findAll());
				form_update.setVisible(false);
				form_service.setVisible(true);
			} else {
				form_update.showMsg("입력데이터를 확인하세요!");
				form_update.tf_pass2.setText("");
			}
		} else if (obj == form_service.bt_del) {// 서비스창: 삭제버튼 클릭
			// 판단: 회원정보를 삭제하려 하는구나!!
			// 액션: 삭제하려는 정보, DB 삭제

			// 1. (특정행) 삭제할 정보: 아이디 입력 ---> inputDialog
			String delId = form_service.showInputDialog("삭제할 아이디를 입력하세요.");
			if (delId == null) {
				return;
			} else if (delId.equals("")) {
				form_service.showMsg("삭제할 아이디를 입력해주세요");
				return;
			}
			// 2. DB ---> 특정 행을 삭제 : DAO (delete) 3. 삭제를 한 후 결과값에 따른 실행
			UserInfoDAO dao = new UserInfoDAO();
			if (dao.delete(delId)) {
				form_service.showMsg("삭제가 완료되었습니다");
				if (dao.findAll() != null)
					form_service.displayTable(dao.findAll());
			} else {
				form_service.showMsg("삭제할 아이디가 존재하지 않습니다.");
			}

		} else if (obj == form_service.bt_sel_name) {// 서비스창: '이름검색'버튼 클릭
			// 판단: 특정한 문자로 시작하는 이름들만 검색하려고 하는구나
			// 액션: 특정문자로 시작하는 이름을 갖는 행검색

			// 1. 검색하고자 하는 시작이름 문자 입력!! inputDialog
			String findId = form_service.showInputDialog("검색할 이름을 입력하세요");
			// 2. DB ---> 특정문자로 시작하는 이름검색: DAO (findByName)
			UserInfoDAO dao = new UserInfoDAO();
			List<UserInfo> list = dao.find(findId);
			if (list == null) {
				form_service.showMsg("해당 이름이 존재하지 않습니다.");
			} else {
				form_service.displayTable(list);
			}
			// 3. 검색결과를 뷰(Jtable)에 출력
		} else if (obj == form_service.bt_exit) {// 서비스창: 종료버튼 클릭
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new Controller();
	}
}
