package t0929;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GuestController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   /*
        <컨트롤러 역할>
        1. 사용자 요청(URL주소요청) 분석
           if(action.equals("form"))
        2. 사용자 입력한 데이터 얻어오기
           request.getParameter("name");
        3. 모델 클래스 객체 생성, 호출
           Dao d = new Dao();
              d.insert(bean);
        4. 데이터를 (영역)저장
           request.setAttribute(String key,Object value);
        5. 페이지 이동
           forward();
           redirect();
		    */
		req.setCharacterEncoding("UTF-8");
		
		String action = req.getParameter("action");

		HttpSession session=req.getSession();
		
		if(action==null){
			resp.sendRedirect("control?action=list");
		}else if(action.equals("list")){
			GuestDAO dao = new GuestDAO();
			//페이지 정보 얻어오기
			String pageStr = req.getParameter("page");
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
			
			req.setAttribute("list", dao.listBoard(start,end));
			req.setAttribute("page", page);//현재페이지
			req.setAttribute("totalPage", totalPage);//전체페이지
			req.getRequestDispatcher("0929/list.jsp").forward(req, resp);
		}else if(action.equals("inputForm")){
			req.getRequestDispatcher("0929/inputForm.jsp").forward(req, resp);
		}else if(action.equals("insert")){
			GuestDAO dao = new GuestDAO();
			
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String tel = req.getParameter("tel");
			String pass = req.getParameter("pass");
			String contents = req.getParameter("contents");
			GuestBean guest = new GuestBean(0, name, pass, email, tel, contents, null);
			if(dao.insert(guest))
				resp.sendRedirect("control?action=list");
			else
				resp.sendRedirect("control?action=inputForm");
		}else if(action.equals("edit")){
			GuestDAO dao = new GuestDAO();
			
			int id = Integer.parseInt(req.getParameter("id"));
			
			session.setAttribute("guest", dao.select(id));
			
			req.getRequestDispatcher("0929/editForm.jsp").forward(req, resp);
		}else if(action.equals("update")){
			GuestDAO dao = new GuestDAO();
			
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String tel = req.getParameter("tel");
			String pass = req.getParameter("pass");
			String contents = req.getParameter("contents");
			
			GuestBean guest = new GuestBean();
			guest.setId(id);
			guest.setName(name);
			guest.setEmail(email);
			guest.setTel(tel);
			guest.setPass(pass);
			guest.setContents(contents);
			
			if(dao.update(guest))
				resp.sendRedirect("control?action=list");
			/*else
				resp.sendRedirect("control?action=edit");*/
		}else if(action.equals("delete")){
			GuestDAO dao = new GuestDAO();
			
			int id = Integer.parseInt(req.getParameter("id"));
			
			if(dao.delete(id))
				resp.sendRedirect("control?action=list");
		}
	}
}
