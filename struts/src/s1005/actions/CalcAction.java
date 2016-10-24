package s1005.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import s1005.model.Calculator;

public class CalcAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		/*
        execute == Controller(흐름제어, 분석)
        
        1. 사용자가 입력한 데이터 얻어오기
        2. Model클래스 객체생성
        3. 결과데이터를 영역(request,session)에 저장
           ==> 뷰와 공유
        4. 이동할 페이지 설정(ActionForward)
    */

		String su1Str = request.getParameter("su1");
		String su2Str = request.getParameter("su2");
		String oper = request.getParameter("oper");
		
		Calculator cal = null;

		int su1;
		int su2;
		HttpSession session = request.getSession();
		
		if(!(su1Str.matches("[0-9]+") && su2Str.matches("[0-9]+"))){
			session.setAttribute("result", "숫자만 입력 가능합니다!!");
		}else if(su2Str.equals("0") && oper.equals("/")){
			session.setAttribute("result", "0으로 나눌 수 없습니다!!");
		}else{
			su1 = Integer.parseInt(su1Str);
			su2 = Integer.parseInt(su2Str);
			cal = new Calculator(su1, su2, oper);
		}

		ActionForward forward;

		if (cal == null) {
			forward = mapping.findForward("fail");
		} else {
			forward = mapping.findForward("success");
			String result = cal.getResult();
			request.setAttribute("result", result);
		}
		return forward;
	}
}
