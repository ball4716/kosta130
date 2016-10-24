package s1006.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginActionForm extends ActionForm{
	//폼안에 입력된 데이터에 대한 유효성 검사
	private String userid;
	private String userpwd;
	
	
	
	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public String getUserpwd() {
		return userpwd;
	}



	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}



	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		// 세터메소드를 통해 초기화된 데이터에 대한 유효성 검사
		
		 ActionErrors errs = new ActionErrors();//에러메시지 담는 바구니(빈바구니)
		
		//아이디 ===> 빈값, 공백을 포함한 아이디 체크(예:"gil dong"," gildong")
		if(userid==null || userid.length()==0){//빈 값 체크
			//errs.add("뷰와 공유할 키값", new ActionMessage("properties파일에 존재하는 키값"));
			errs.add("errorid", new ActionMessage("invalidid","아이디 입력!!"));
		}else if(userid.indexOf(" ")>-1 || userid.indexOf("\t")>-1 || userid.indexOf("\n")>-1){
			//공백 체크
			errs.add("errorid", new ActionMessage("invalidid","공백을 포함할 수 없습니다!!"));
		}
		
		//비번 ===> 빈값
		if(userpwd==null || userpwd.length()==0){//빈값체크
			errs.add("errorpwd", new ActionMessage("invalidpass"));
		}
		return errs;
	}
}
