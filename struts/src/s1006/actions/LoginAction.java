package s1006.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import s1005.beans.UserInfo;
import s1005.model.LoginProcess;
import s1006.forms.LoginActionForm;

public class LoginAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//(��ȿ�� �˻縦 ����ģ)������ ������
		//����: request.gejtParameter("uerid"); ����:form.Userid();
		
		LoginActionForm laf = (LoginActionForm) form;
		String userid = laf.getUserid();
		String userpwd = laf.getUserpwd();
		
		//�𵨰�ü����, ȣ��
		LoginProcess lp = new LoginProcess();
		UserInfo info = lp.login(userid, userpwd);
		
		ActionForward forward;
		if(info!=null){//���̵� ����, �����ġ
			//�α��� ������ ���� ���� ����
			request.getSession().setAttribute("info", info);
			forward = mapping.findForward("success");
		}else{//���̵� ������ �Ǵ� ��� ����ġ
			//�α��� ���и� ����
			ActionMessages msgs = new ActionMessages();//�޽����� ��� �ٱ���
			msgs.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("invalidlogin"));
			
			saveMessages(request,msgs);//�޽����ٱ��ϸ� �����ӿ�ũ���� ����(�˸�)
			forward = mapping.getInputForward();
		}
		
		return forward;
	}
}
