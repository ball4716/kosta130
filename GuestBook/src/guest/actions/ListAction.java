package guest.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import guest.dao.GuestDAO;
import guest.dto.Guest;

public class ListAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//전체 게시물 조회
		
		GuestDAO dao = new GuestDAO();
		List<Guest> list = dao.selectAll();
		
		request.setAttribute("list", list);
		
		return mapping.findForward("success");
	}
}
