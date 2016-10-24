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
		//login.do ��û�� ó���� ����
		
		//����� �Է� ������ ������
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		
		//�𵨰�ü����
		LoginProcess lp = new LoginProcess();
		UserInfo info = lp.login(userid, userpwd);
		
		ActionForward forward;
		
		if(info == null){//���̵� ����X, ��� ��ġX
			//���� ������ �̵�
			forward = mapping.findForward("fail");
		}else{//���̵� ����, ��� ��ġ
			//���� ������ �̵�
			forward = mapping.findForward("success");
			HttpSession session = request.getSession();
			session.setAttribute("info", info);
		}
		
		return forward;
	}
}
