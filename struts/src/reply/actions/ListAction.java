package reply.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import reply.dao.ReplyDAO;
import reply.dto.Reply;

public class ListAction extends Action{//목록출력 요청
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ReplyDAO dao = new ReplyDAO();
		List<Reply> list = dao.findAll();
		request.setAttribute("list", list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("list = "+list.get(i).getNo());
			System.out.println(list.get(i).getName());
			System.out.println(list.get(i).getContent());
		}
		return mapping.findForward("success");
	}
}
