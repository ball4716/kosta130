package s1027.mission.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import s1027.dao.EmpDAO;
import s1027.dto.Emp;

public class Mission3Action extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String search = request.getParameter("search");//"ename" ¶Ç´Â "deptno"
		String keyword = request.getParameter("keyword");
		
		EmpDAO dao = new EmpDAO();
		List<Emp> list;
		System.out.println(search);
		if(search.equals("ename")){
			list = dao.selectEmpInfo("%"+keyword+"%", 0);
		}else{
			list = dao.selectEmpInfo(null, Integer.parseInt(keyword));
		}
		
		request.setAttribute("list", list);
		
		return mapping.findForward("success");
	}
}
