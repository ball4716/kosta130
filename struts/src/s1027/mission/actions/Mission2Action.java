package s1027.mission.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import s1005.model.Calculator;

public class Mission2Action extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String su1 = request.getParameter("su1");
		String su2 = request.getParameter("su2");
		String oper = request.getParameter("oper");
		
		String state=null;
		String result;
		if(su1.trim().equals("") ||
				su2.trim().length()==0){
			result="두개의 수를 입력!!";
		}else if(!su1.matches("[\\d]+")|| 
				 !su2.matches("[\\d]+")){
			result="숫자만 입력!!";
		}else if(oper.equals("/") && su2.equals("0")){
			result="0으로 나눌 수 없습니다!!";
		}else{
			state="success";
			Calculator calc = new Calculator( Integer.parseInt(su1),
					Integer.parseInt(su2),
					oper);
			result= calc.getResult();		
		}
		
		request.setAttribute("result", result);
		request.setAttribute("state", state);
		
		return mapping.findForward("success");
	}
}








