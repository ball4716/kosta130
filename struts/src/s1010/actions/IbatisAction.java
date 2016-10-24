package s1010.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ibatis.sqlmap.client.SqlMapClient;

import iba.SqlMapConfig;

public class IbatisAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));
		
		SqlMapClient sqlMap = SqlMapConfig.getSqlMapInstance();
		
		List<String> list = sqlMap.queryForList("test.select",deptNo);
		
		request.setAttribute("deptNo", deptNo);
		request.setAttribute("list", list);
		
		return mapping.findForward("success");
	}
}
