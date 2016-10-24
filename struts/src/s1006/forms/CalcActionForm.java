package s1006.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class CalcActionForm extends ActionForm{
	private String su1;
	private String su2;
	private String oper;
	
	public String getSu1() {
		return su1;
	}
	public void setSu1(String su1) {
		this.su1 = su1;
	}
	public String getSu2() {
		return su2;
	}
	public void setSu2(String su2) {
		this.su2 = su2;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errs = new ActionErrors();//에러메시지 담는 바구니(빈바구니)
		//request.getSession().removeAttribute("result");
		
		if(su1==null || su2==null || su1.length()==0 || su2.length()==0){
			errs.add("is_empty_error", new ActionMessage("is_empty_error"));
			
		}else if(!(su1.matches("[0-9]+") && (su2.matches("[0-9]+")))){
			errs.add("is_not_num_error", new ActionMessage("is_not_num_error"));
		}else if(su2.equals("0") && oper.equals("/")){
			errs.add("by_zero_error", new ActionMessage("by_zero_error"));
		}
		return errs;
	}
}
