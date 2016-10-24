package guest.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import guest.dao.GuestDAO;
import guest.dto.Guest;

public class GuestAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// ���Է� ��û action="insert"
		// �ۼ����� ��û action="upform"
		// �ۼ��� ��û action="update"
		// �ۻ��� ��û action="delete"
		GuestDAO dao = new GuestDAO();

		String action = request.getParameter("action");
		ActionForward forward = mapping.findForward("list");

		if (action.equals("insert")) {// DB�Է¿�û
			Guest guest = new Guest(0, request.getParameter("name"), request.getParameter("pass"),
					request.getParameter("email"), request.getParameter("tel"), request.getParameter("contents"), null);

			if (dao.insert(guest)) {
				forward = mapping.findForward("success");
			}
		} else if (action.equals("upform")) {
			forward = mapping.findForward("upform");
			int id=Integer.parseInt(request.getParameter("id"));
			Guest guest = dao.select(id);
			request.setAttribute("guest", guest);
			request.setAttribute("id", id);
			request.getSession().setAttribute("pass", guest.getPass());
		} else if (action.equals("update")) {
			Guest guest = new Guest(Integer.parseInt(request.getParameter("id")), request.getParameter("name"),
					request.getParameter("pass"), request.getParameter("email"), request.getParameter("tel"),
					request.getParameter("contents"), null);
			if(dao.update(guest))
				System.out.println("����:"+guest.getId());
			else
				System.out.println("����:"+guest.getId());
		} else if (action.equals("delete")){
			int id = Integer.parseInt(request.getParameter("id"));
			if(dao.delete(id))
				System.out.println("����:"+id);
			else
				System.out.println("����:"+id);
		}
		return forward;
	}
}
