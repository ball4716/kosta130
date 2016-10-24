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
		
		//폼에 입력된 데이터 얻어오기
		//==> request.getParameter("name") 대신에 getName()메소드를 사용
		//ActionForm form = new MyActionForm();
		MyActionForm myForm = (MyActionForm) form;
		
		String username = myForm.getUsername();
		int userage = Integer.parseInt(myForm.getUserage());
		System.out.println("나이를 잘 받았습니다: "+userage);
		request.setAttribute("username", username);
		
		return mapping.findForward("result");
		//결과 화면 없음
	}
}
