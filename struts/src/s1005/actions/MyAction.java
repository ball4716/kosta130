package s1005.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import s1005.forms.MyActionForm;

public class MyAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("execute()");
		
		//���� �Էµ� ������ ������
		//==> request.getParameter("name") ��ſ� getName()�޼ҵ带 ���
		//ActionForm form = new MyActionForm();
		MyActionForm myForm = (MyActionForm) form;
		
		String username = myForm.getUsername();
		int userage = Integer.parseInt(myForm.getUserage());
		System.out.println("���̸� �� �޾ҽ��ϴ�: "+userage);
		request.setAttribute("username", username);
		
		return mapping.findForward("result");
		//��� ȭ�� ����
	}
}
