package s1005.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import s1005.beans.UserInfo;
import s1005.model.LoginProcess;

public class LoginAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//login.do 요청시 처리할 내용
		
		//사용자 입력 데이터 얻어오기
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		
		//모델객체생성
		LoginProcess lp = new LoginProcess();
		UserInfo info = lp.login(userid, userpwd);
		
		ActionForward forward;
		
		if(info == null){//아이디 존재X, 비번 일치X
			//실패 페이지 이동
			forward = mapping.findForward("fail");
		}else{//아이디 존재, 비번 일치
			//성공 페이지 이동
			forward = mapping.findForward("success");
			HttpSession session = request.getSession();
			session.setAttribute("info", info);
		}
		
		return forward;
	}
}
