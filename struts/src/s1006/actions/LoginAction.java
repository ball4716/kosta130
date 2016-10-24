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
		//(유효성 검사를 끝마친)데이터 얻어오기
		//이전: request.gejtParameter("uerid"); 현재:form.Userid();
		
		LoginActionForm laf = (LoginActionForm) form;
		String userid = laf.getUserid();
		String userpwd = laf.getUserpwd();
		
		//모델객체생성, 호출
		LoginProcess lp = new LoginProcess();
		UserInfo info = lp.login(userid, userpwd);
		
		ActionForward forward;
		if(info!=null){//아이디 존재, 비번일치
			//로그인 성공에 대한 세션 적용
			request.getSession().setAttribute("info", info);
			forward = mapping.findForward("success");
		}else{//아이디 비존재 또는 비번 불일치
			//로그인 실패를 전달
			ActionMessages msgs = new ActionMessages();//메시지를 담는 바구니
			msgs.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("invalidlogin"));
			
			saveMessages(request,msgs);//메시지바구니를 프레임워크에게 전달(알림)
			forward = mapping.getInputForward();
		}
		
		return forward;
	}
}
