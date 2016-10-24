package s1005.forms;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class MyActionForm extends ActionForm{
	//사용자가 입력한 데이터에 대한 유효성 검사
	private String username;//반드시 input의 name과 일치시킬 것!!
	private String userage;
	
	public String getUserage() {
		return userage;
	}

	public void setUserage(String userage) {
		this.userage = userage;
	}

	public String getUsername(){
		System.out.println("getUsername()");
		return username;
	}
	
	public void setUsername(String username){
		System.out.println("setUsername() : "+username);
		this.username = username;
	}
	
/*	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		//초기화 작업, 선행 작업
		System.out.println("reset()");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}*/
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		//유효성 검사
		System.out.println("validate()");
		
		System.out.println("userage: "+userage);
		
		ActionErrors errors = new ActionErrors();
		//errors: 에러메시지를 담는 바구니 ==> 빈 바구니
		
		//에러메시지 담기!!
		//errors.add(String key1, new ActionMessage(String key2);
		//key1: 뷰와 공유할 키값
		//key2: application.properties파일에 정의된 속성명
		
/*		if(userage > 100){
			System.out.println("만수무강하세요!");
		}*/
		
		if(username.length()==0)//입력된 값이 없다면
			errors.add("err", new ActionMessage("testError"));
		
		
		return errors;//빈 바구니 리턴시 에러 없음을 표현 : 데이터들이 전부 유효하다
		//return null;//null 리턴시 에러 없음을 표현
	}

}
