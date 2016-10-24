package com.kosta._0831.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.kosta._0831.model.PersonDAO;
import com.kosta._0831.model.PersonDTO;
import com.kosta._0831.view.InputForm;
import com.kosta._0831.view.MainView;
import com.kosta._0831.view.UpForm;

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
	
	int tmpNo;//수정번호를 저장.
	
	public Controller() {
		view_main = new MainView();
		/*PersonDAO dao = new PersonDAO();
		ArrayList<PersonDTO> list = dao.selectAll();
		view_main.displayTable(list);*/
		view_main.displayTable(new PersonDAO().selectAll());
		view_form = new InputForm();
		view_upform = new UpForm();
		
		eventUp();
	}//생성자
	
	private void eventUp(){
		//메인뷰
		view_main.bt_insert.addActionListener(this);
		view_main.bt_delete.addActionListener(this);
		view_main.bt_update.addActionListener(this);
		view_main.bt_exit.addActionListener(this);
		
		//입력폼
		view_form.bt_cancel.addActionListener(this);
		view_form.bt_submit.addActionListener(this);
		
		//수정폼
		view_upform.bt_cancel.addActionListener(this);
		view_upform.bt_submit.addActionListener(this);
	}//eventUp
	
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
				//JOptionPane.showMessageDialog(view_form, "입력값을 확인하세요!!");
				view_form.showMsg("입력값을 확인하세요!!");
				view_form.initForm();
			}
		} else if(obj == view_main.bt_delete){//1. 메인: 삭제버튼클릭(DB 행삭제)
			String no = view_main.showInput("삭제할 번호:");
			System.out.println("삭제번호:"+no);
			PersonDAO dao = new PersonDAO();
			boolean flag = dao.delete(Integer.parseInt(no));
			if(flag){//삭제가 잘 되었다면
				//----> 클라이언트에게 삭제된 결과를 보여줘야지!
				view_main.displayTable(dao.selectAll());//새로운 데이터 갱신결과
			} else {//삭제가 안되었다면
				//----> 일치되는 행을 못찾았다!! : 번호가 존재 x
				view_main.showMsg("일치하는 번호가 없습니다!!");
			}
		} else if(obj == view_main.bt_update){//메인: 수정버튼 클릭(수정폼 원하는구나!!)
			//(뷰로부터) 수정번호 얻어오기
			int row = view_main.table.getSelectedRow();//JTable 선택된 행 인덱스
			
			//만약 JTable에서 선택된 행이 없다면 -1리턴
			if(row == -1){
				view_main.showMsg("수정할 행을 선택하세요!");
				return;
			}
			
			int upNo = Integer.parseInt(""+view_main.table.getValueAt(row, 0));
			
			tmpNo = upNo;
			
			//수정번호에 대한(모델로부터) 데이터를 얻어오기
			PersonDAO dao = new PersonDAO();
			PersonDTO dto = dao.select(upNo); //번호에 해당하는 사람정보(PersonDTO)를 얻어오기
			
			view_upform.tf_name.setText(dto.getName());  
			view_upform.tf_age.setText(dto.getAge()+"");//setText(13+"")  
			view_upform.tf_job.setText(dto.getJob());  
			
			//1.메인뷰 ---> 수정폼이동
				//---> setVisible();
			view_main.setVisible(false);
			view_upform.setVisible(true);
			//2.수정폼에 뿌려줄 데이터를 검색
				//---> DAO	select(원하는 번호);
			//입력폼은 빈칸의 출력, 수정폼은 채워진 칸의 출력
			
			/*
			 		int upNo = Integer.parseInt(Object.toString());
			 		int upNo = Integer.parseInt((String)Object);
			 		
			 	JDK5 ---> AutoBoxing(클래스로 변환), UnBoxing(기본자료형으로 변환)
			 	
			 		int su1 = new Integer(13); //언박싱
			 		
			 		Integer su2 = 15; //오토박싱
			 */
			// int = (Integer)Object
		} else if (obj == view_upform.bt_cancel){//수정폼: 취소버튼 클릭
			//4.
			view_upform.setVisible(false);
			view_main.setVisible(true);
		} else if (obj == view_upform.bt_submit){//수정폼: 수정버튼클릭
			//사용자가 변경된 내용으로 DB수정을 원하는구나!!
			String age = view_upform.tf_age.getText();
			String job = view_upform.tf_job.getText();
			
			//age와 job을 클래스로 묶어주는 작업
			PersonDTO dto = new PersonDTO();//no,name,age,job ---> 0,null,0,null
			dto.setAge(Integer.parseInt(age));//---> 0,null,18,null
			dto.setJob(job);//---> 0,null,18,"장군"
			dto.setNo(tmpNo);
			
			PersonDAO dao = new PersonDAO();
			if(dao.update(dto)){
				view_main.displayTable(dao.selectAll());
				//(DB)변경된 내용을 JTable 뷰에 반영
				view_upform.setVisible(false);
				view_main.setVisible(true);
			} else {
				view_upform.showMsg("수정실패!!");
			}
		} else if (obj == view_main.bt_exit){
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new Controller();
	}
}
