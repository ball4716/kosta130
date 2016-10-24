package s1011.actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ibatis.sqlmap.client.SqlMapClient;

import iba.SqlMapConfig;
import s1011.beans.Emp;

public class EmpAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		SqlMapClient sqlMap = SqlMapConfig.getSqlMapInstance();
		
		//sqlMap.queryForObject("xml내의 네임스페이스명.id명", 전달데이터);
		Emp emp = (Emp) sqlMap.queryForObject("semp.select", 7788);//결과행 1행
		request.setAttribute("emp", emp);
		
		List<Emp> list = sqlMap.queryForList("semp.selectAll");//결과행 2행 이상
		request.setAttribute("list", list);
		
		Emp emp3 = new Emp();
		emp3.setDeptno(20);
		emp3.setSal(2000);
		List<Emp> list3 = sqlMap.queryForList("semp.selectEx3", emp3);
		request.setAttribute("list3", list3);
		
		Emp emp4 = new Emp();
		emp4.setDeptno(20);
		emp4.setSal(2000);
		List<Emp> list4 = sqlMap.queryForList("semp.selectEx4", emp4);
		request.setAttribute("list4", list4);
		
		Map<String,Object> map = new HashMap<>();
		map.put("dno", 30);
		map.put("pattern", "%A%");
		
		List<Emp> list5 = sqlMap.queryForList("semp.selectEx5", map);
		request.setAttribute("list5", list5);
		
		
		Emp emp6 = new Emp();
		emp6.setDeptno(20);
		
		List<Emp> listCommon = sqlMap.queryForList("semp.selectCommon",emp6);
		request.setAttribute("listCommon", listCommon);
		
		return mapping.findForward("success");
	}
}
