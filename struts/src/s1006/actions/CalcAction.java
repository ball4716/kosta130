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
		 1.������ ������
		 	- request.getParameter("name"); ===> Action�� ����ϴ� ���
		 	- ((�ڽ�)form).getName(); ==> ActionForm�� Action�� ����ϴ� ���
		 2. �� ��ü ����, ȣ��
		 	Model m = new Model(); ==> DAO dao = new DAO();
		 	������ = m.method(); ==> Bean b = dao.select();
		 	
		 3. (��� ������)������ (����)����
		 	request.setAttribute("Ű��", ������ or b);
		 	==> forward�̵�
		 	session.setAttribute("Ű��", ������ or b);
		 	==> redirect�̵�
		 	
		 4. �̵��� ������ ������ ����
		 	ActionForward forward;
		 				forward = mapping.findForward("XML�� ���ǵ� forward��);
		 				forward = mapping.getInputForward();
		 							==> <action>�±׿� input �Ӽ��� ���ǵ� ���
		 							
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
