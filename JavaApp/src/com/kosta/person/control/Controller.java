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
	// 전체 어플리케이션의 흐름 제어

	// 뷰등록
	MainView mainView;
	InputForm inputForm;

	// 모델등록
	Model model;

	int cntNo;
	/*
	 * <컨트롤러의 역할> 1. 사용자 요청에 대한 분석 2. 사용자 입력데이터를 얻어오기 3. 모델객체생성. 3_1. 메소드호출 3_2.
	 * 리턴데이터를 변수에 저장 4. 페이지(프레임) 이동
	 * 
	 * 옵션) 유효성 검사
	 */

	public Controller() {
		mainView = new MainView();
		inputForm = new InputForm();

		model = new Model();

		mainView.displayTable(model.selectAll());

		eventUp();
	}// 생성자

	private void eventUp() {// 이벤트 소스- 이벤트 핸들러 연결
		// mainView 연결자(감시자) 등록
		mainView.bt_insert.addActionListener(this);
		mainView.bt_delete.addActionListener(this);
		mainView.bt_update.addActionListener(this);
		mainView.bt_exit.addActionListener(this);

		// inputForm 연결자(감시자) 등록
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
		});// 테이블의 1개의 row 선택시만 수정버튼 활성화
		
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
	public void actionPerformed(ActionEvent e) {// 이벤트 핸들러(처리부)
		Object obj = e.getSource();
		

		if (obj == mainView.bt_insert) {// 1. 메인에서 '입력'버튼 클릭
										// ------> 데이터 입력폼을 원했다면
			// 4. 프레임이동
			inputForm.initForm();
			mainView.setVisible(false);
			inputForm.setVisible(true);

			// 폼 타이틀 변경
			inputForm.setTitle("입력폼");
			mainView.updateButtonStateFalse();
			mainView.deleteButtonStateTrue();

		} else if (obj == mainView.bt_delete) {// 1. 메인에서 '삭제'버튼 클릭

			String deleteNoStr = mainView.showInput("삭제를 원하는 번호를 입력하세요");
			int deleteNo = 0;
			
			if (deleteNoStr == null)
				return;
			
			if (mainView.showConfirm("정말로 삭제하시겠습니까?")) {
				
				if (deleteNoStr != null && deleteNoStr.equals("")) {
					mainView.showMessage("번호가 입력되지 않았습니다");
				} else if (deleteNoStr != null && deleteNoStr.matches("^[1-9]*$")) {
					deleteNo = Integer.parseInt(deleteNoStr);
					if (model.delete(deleteNo))
						mainView.showMessage("삭제되었습니다.");
					else
						mainView.showMessage("존재하지 않는 번호입니다.");
				} else {
					mainView.showMessage("1이상의 숫자를 입력하세요");
				}
				
			} else {
				return;
			}

			mainView.displayTable(model.selectAll());// 벡터의 현재내용을 JTable에 출력
			mainView.updateButtonStateFalse();

		} else if (obj == mainView.bt_update) {// 1. 메인에서 '수정'버튼 클릭
			// 분석결과: 이전정보를 변경하겠다!!
			// 필요한것? 이전정보 얻기. 정보를 뿌려줄 폼이 필요!!
			
			if(!isRowSelected()){
				//수정 전에 행 선택 안할경우, 버튼 자체를 막아놔서 거의 쓰이지는 않지만
				//만약을 위해 넣어놓은 코드임
				mainView.showMessage("수정할 행을 선택해주세요");
				return;
			}
			// 선택한 행의 데이터를 폼으로 가져오기

			int row = mainView.table.getSelectedRow();
			int no = (int) mainView.table.getValueAt(row, 0);
			Person p = model.select(no);

			inputForm.initForm(p);
			// 4. 프레임이동
			mainView.setVisible(false);
			inputForm.setVisible(true);

			mainView.updateButtonStateFalse();

		} else if (obj == mainView.bt_exit) {// 4. 메인에서 '종료'버튼 클릭

			System.exit(0);

		} else if (obj == inputForm.bt_submit) {// 5. 폼에서 '입력'버튼 클릭
			// 1.입력폼에서 '입력'버튼을 클릭했다면
			// 1.수정폼에서 '수정'버튼을 클릭했다면
			String name = inputForm.tf_name.getText().trim();// 2. //공백제거
			String ageStr = inputForm.tf_age.getText();
			String job = inputForm.tf_job.getText();// 2.
			int age;
			if (isEmpty(name, ageStr, job)) {
				return;
			} else {
				age = Integer.parseInt(ageStr);// 2.
			}

			if (inputForm.getTitle().equals("입력폼")) {
				cntNo++;// 1 증가번호
				Person p = new Person(cntNo, name, age, job);// 3.
				model.insert(p);// 3_1.
			} else {// inputForm.getTitle()=="수정폼"

				int row = mainView.table.getSelectedRow();
				int updateNo = (int) mainView.table.getValueAt(row, 0);
				Person old_p = model.select(updateNo);
				Person update_p = new Person(updateNo, name, age, job);
				model.update(old_p, update_p);

			}

			// Vector<Person> v = model.selectAll();//3_2.
			// mainView.displayTable(v);
			mainView.displayTable(model.selectAll());// 벡터의 현재내용을 JTable에 출력

			// 4. 프레임이동
			mainView.setVisible(true);
			inputForm.setVisible(false);

		} else if (obj == inputForm.bt_cancel) {

			// 4. 프레임이동
			mainView.setVisible(true);
			inputForm.setVisible(false);

		}

	}

	private boolean isEmpty(String name, String ageStr, String job) {
		if(name.equals("")){
		   JOptionPane.showMessageDialog(inputForm, "이름입력!!");
		   inputForm.tf_name.requestFocus();
		}else if(ageStr.length()==0){
			JOptionPane.showMessageDialog(inputForm, "나이입력!!");
			inputForm.tf_age.requestFocus();
		}else if(job.length()<1){
			JOptionPane.showMessageDialog(inputForm, "직업입력!!");
			inputForm.tf_job.requestFocus();
		}else{
		   //이름,나이,직업이 전부 입력되었다면
			return false;
		}
		return true;
	}// 폼 빈곳 확인
	
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
