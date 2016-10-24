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
        execute == Controller(�帧����, �м�)
        
        1. ����ڰ� �Է��� ������ ������
        2. ModelŬ���� ��ü����
        3. ��������͸� ����(request,session)�� ����
           ==> ��� ����
        4. �̵��� ������ ����(ActionForward)
    */

		String su1Str = request.getParameter("su1");
		String su2Str = request.getParameter("su2");
		String oper = request.getParameter("oper");
		
		Calculator cal = null;

		int su1;
		int su2;
		HttpSession session = request.getSession();
		
		if(!(su1Str.matches("[0-9]+") && su2Str.matches("[0-9]+"))){
			session.setAttribute("result", "���ڸ� �Է� �����մϴ�!!");
		}else if(su2Str.equals("0") && oper.equals("/")){
			session.setAttribute("result", "0���� ���� �� �����ϴ�!!");
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
