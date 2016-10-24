package s1006.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import s1006.forms.CalcActionForm;
import s1006.model.Calculator;

public class CalcAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 1.데이터 얻어오기
		 	- request.getParameter("name"); ===> Action만 사용하는 경우
		 	- ((자식)form).getName(); ==> ActionForm과 Action을 사용하는 경우
		 2. 모델 객체 생성, 호출
		 	Model m = new Model(); ==> DAO dao = new DAO();
		 	데이터 = m.method(); ==> Bean b = dao.select();
		 	
		 3. (뷰와 공유할)데이터 (영역)저장
		 	request.setAttribute("키값", 데이터 or b);
		 	==> forward이동
		 	session.setAttribute("키값", 데이터 or b);
		 	==> redirect이동
		 	
		 4. 이동할 페이지 정보를 전달
		 	ActionForward forward;
		 				forward = mapping.findForward("XML에 정의된 forward명);
		 				forward = mapping.getInputForward();
		 							==> <action>태그에 input 속성이 정의된 경우
		 							
		 				return forward;
		 */
		CalcActionForm caf = (CalcActionForm) form;
		
		int su1 = Integer.parseInt(caf.getSu1());
		int su2 = Integer.parseInt(caf.getSu2());
		String oper = caf.getOper();
		
		
		Calculator cal = new Calculator(su1, su2, oper);
		String result = cal.getResult();
		request.setAttribute("result", result);
		
		ActionForward forward;
		forward = mapping.findForward("resultDone");
		
		
		
		return forward;
	}
}
