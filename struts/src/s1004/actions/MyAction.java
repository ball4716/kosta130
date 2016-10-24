package s1004.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class MyAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("MyAction: execute()");
		/*
		 <Action클래스에 들어가는 코드>
		 1. request.getParameter();
		 2. Model m = new Model(); ★Action클래스의 핵심
		 	변수 = m.method();
		 3. 영역변수.setAttribute("키값",변수데이터);
		 4. 페이지 이동(이동할 페이지에 대한 정보 전달)
		 	ActionForward: 액션을 실행후 이동할 페이지에 대한 정보를 담는 클래스
		 */
		
		//3.
		request.setAttribute("msg", "몸에 좋은 에메스지");
		HttpSession session = request.getSession();
		session.setAttribute("msg", "건강챙기세요!!");
		
		//4.
		ActionForward forward;
		//forward = mapping.findForward("suc");
		forward = mapping.findForward("success");
		//ActionMapping mapping : struts-config.xml에 정의된 매핑정보를 얻는 클래스
		
		return forward;
	}//execute
}
