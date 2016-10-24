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
	 <컨트롤러(서버)의 역할>
	 - 전체 프로그램에 대한 흐름 제어!!
	 1. 사용자 요청 분석
	 2. 사용자가 입력한 데이터를 얻어오기
	 3. 모델객체생성!! M m = new M();	변수 = m.method();
	 4. 페이지 이동
	 추가옵션) 2번과 관련: 유효성 검사
	 */
	
	//뷰등록
	MainView view_main;
	InputForm view_form;
	UpForm view_upform;
	
	public Controller() {
		view_main = new MainView();
		view_form = new InputForm();
		view_upform = new UpForm();
		
		eventUp();
	}//생성자
	
	private void eventUp(){
		//메인뷰
		view_main.bt_insert.addActionListener(this);
		
		//입력폼
		view_form.bt_cancel.addActionListener(this);
		view_form.bt_submit.addActionListener(this);
		
		//수정폼
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();//버튼의 레퍼런스 얻어오기
		if(obj == view_main.bt_insert){//1.메인: 입력버튼 클릭했다면
			//4.페이지이동
			view_form.initForm();
			view_main.setVisible(false);
			view_form.setVisible(true);
		} else if(obj == view_form.bt_cancel){//1.입력폼: 취소버튼을 클릭했다면
			//4.페이지이동
			view_form.setVisible(false);
			view_main.setVisible(true);
		} else if(obj == view_form.bt_submit){//1.입력폼: 입력버튼을 클릭했다면
			//2.사용자가 입력한 데이터 얻어오기
			String name = view_form.tf_name.getText().trim();
			String age = view_form.tf_age.getText().trim();
			String job = view_form.tf_job.getText().trim();
			PersonDTO person = new PersonDTO(0, name, Integer.parseInt(age), job);
			
			//3. 모델객체생성
			PersonDAO dao = new PersonDAO();
			
			//boolean flag = dao.insert(person);
			if(dao.insert(person)){//(flag){ //입력성공!!
				ArrayList<PersonDTO> list = dao.selectAll();
				view_main.displayTable(list);
				//4. 페이지이동
				view_form.setVisible(false);
				view_main.setVisible(true);
			} else {//입력 실패!!
				JOptionPane.showMessageDialog(view_form, "입력값을 확인하세요!!");
				view_form.initForm();
			}
		}
	}
	
	public static void main(String[] args) {
		new Controller();
	}
}
