package board.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import board.bean.GuestBean;
import board.dao.GuestDAO;


public class GuestAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		
		HttpSession session = request.getSession();
		
		ActionForward forward = mapping.findForward("none");
		
		if(action==null || action.equals("list")){
			GuestDAO dao = new GuestDAO();
			//페이지 정보 얻어오기
			String pageStr = request.getParameter("page");
			int page = 1;
			
			int pageRowCnt=10;//한페이지에 보여줄 행(레코드의 수);
			
			if(pageStr !=null){
				page = Integer.parseInt(pageStr);
			}
			
			int end = page*pageRowCnt;
			int start = end-(pageRowCnt-1);
			
			int totalRecord=dao.selectCount();
			int totalPage=totalRecord/10;
			if(totalRecord%10 > 0)
				totalPage++;
			
			request.setAttribute("list", dao.listBoard(start,end));
			request.setAttribute("page", page);//현재페이지
			request.setAttribute("totalPage", totalPage);//전체페이지
			
			forward = mapping.findForward("showLIST");
		}else if(action.equals("insert")){
			GuestDAO dao = new GuestDAO();
			System.out.println("dao:"+dao);
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String tel = request.getParameter("tel");
			String pass = request.getParameter("pass");
			String contents = request.getParameter("contents");
			GuestBean guest = new GuestBean(0, name, pass, email, tel, contents, null);
			if(dao.insert(guest)){
				/*forward = mapping.findForward("showLIST");*/
				response.sendRedirect("control.do?action=list");
			}else{
				forward = mapping.findForward("insertFAIL");
			}
		}else if(action.equals("edit")){
			GuestDAO dao = new GuestDAO();
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			session.setAttribute("guest", dao.select(id));
			forward = mapping.findForward("edit");
			
			/*request.getRequestDispatcher("0929/editForm.jsp").forward(request, response);*/
		}else if(action.equals("update")){
			GuestDAO dao = new GuestDAO();
			
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String tel = request.getParameter("tel");
			String pass = request.getParameter("pass");
			String contents = request.getParameter("contents");
			
			GuestBean guest = new GuestBean();
			guest.setId(id);
			guest.setName(name);
			guest.setEmail(email);
			guest.setTel(tel);
			guest.setPass(pass);
			guest.setContents(contents);
			
			if(dao.update(guest))
				response.sendRedirect("control.do?action=list");
			else
				forward = mapping.findForward("edit");
		}else if(action.equals("delete")){
			GuestDAO dao = new GuestDAO();
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			if(dao.delete(id))
				response.sendRedirect("control.do?action=list");
			else
				forward = mapping.findForward("delete");
		}
		
		return forward;
	}
}