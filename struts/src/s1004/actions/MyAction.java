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
		 <ActionŬ������ ���� �ڵ�>
		 1. request.getParameter();
		 2. Model m = new Model(); ��ActionŬ������ �ٽ�
		 	���� = m.method();
		 3. ��������.setAttribute("Ű��",����������);
		 4. ������ �̵�(�̵��� �������� ���� ���� ����)
		 	ActionForward: �׼��� ������ �̵��� �������� ���� ������ ��� Ŭ����
		 */
		
		//3.
		request.setAttribute("msg", "���� ���� ���޽���");
		HttpSession session = request.getSession();
		session.setAttribute("msg", "�ǰ�ì�⼼��!!");
		
		//4.
		ActionForward forward;
		//forward = mapping.findForward("suc");
		forward = mapping.findForward("success");
		//ActionMapping mapping : struts-config.xml�� ���ǵ� ���������� ��� Ŭ����
		
		return forward;
	}//execute
}
