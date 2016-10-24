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
		
		//서비스폼
		form_service.bt_sel_all.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();// actionPerformed()메소드를 호출한 버튼의 레퍼런스!!

		if (obj == form_login.bt_join) {// 로그인폼: 신규가입 버튼 클릭
			// 로그인폼 ---> 회원가입폼 이동
			form_join.initForm();

			form_join.setVisible(true);
			form_login.setVisible(false);
			
			checkIdFlag=false;
		} else if (obj == form_join.bt_reset) {// 회원가입폼: 취소버튼 클릭
			form_join.initForm();
			checkIdFlag=false;
		} else if (obj == form_join.bt_submit) {// 회원가입폼: 등록버튼 클릭
			if (checkIdFlag) {
				// 뷰에 입력된 데이터 얻기
				String id = form_join.tf_id.getText().trim();
				if(tmpId!=null && !tmpId.equals(id)){
					form_join.showMsg("ID 중복체크를 해주세요");
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
			if(new UserInfoDAO().find(id)==null){
				tmpId=id;
				form_join.showMsg("사용할 수 있는 ID입니다.");
				checkIdFlag = true;
			} else if("".equals(id)){
				form_join.showMsg("ID를 입력해주세요");
			} else {
				form_join.showMsg("사용할 수 없는 ID입니다.");
				form_join.tf_id.setText("");
			}
		} else if (obj == form_login.bt_login){
			String id = form_login.tf_id.getText().trim();
			String pass = new String(form_login.tf_pass.getPassword()).trim();
			
			
			//데이터를 DAO에게 전달
			UserInfoDAO dao = new UserInfoDAO();
			//boolean flag = dao.findLogin(id, pass);
			String dpass = dao.findLogin3(id);
			
			//결과값에 따른 Action!!
			if(dpass == null){//아이디 존재x
				if(form_login.showConfirm("존재하지 않는 아이디입니다.\n회원가입하시겠습니까?")==0){
					form_login.setVisible(false);
					form_join.setVisible(true);
				} else {
					
				}
			} else {//아이디 존재 o
				if(dpass.equals(pass)){//DB저장된 pass와 뷰입력된 pass비교
					//아이디 존재O, 비번 일치
					form_login.showMsg("로그인 성공!!");
					form_login.setVisible(false);
					form_service.setVisible(true);
				} else {
					//아이디 존재O, 비번 불일치
					form_login.showMsg("비밀번호를 확인하세요.");
				}
				
			}
			/*if(flag){
				//로그인 성공 메시지
				form_login.showMsg("로그인 성공!!");
				//로그인폼--->서비스창이동
				form_login.setVisible(false);
				form_service.setVisible(true);
			} else {//로그인 실패
				//로
				form_login.showMsg("로그인 실패!!\n아이디 또는 비번을 확인하세요");
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
