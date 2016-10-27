package s1027.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import iba.SqlMapConfig;
import s1027.dto.Emp;

public class EmpDAO {
	SqlMapClient sqlMap;

	public EmpDAO() {
		sqlMap = SqlMapConfig.getSqlMapInstance();
	}

	public List<Emp> selectEmpInfo(String ename, int deptno) {
		List<Emp> list = null;
		Map<String, Object> map = new HashMap<>();
		if (ename != null) {
			map.put("ename", ename);
		} else {
			map.put("deptno", deptno);
		}
		try {
			list = sqlMap.queryForList("jqueryEmp.select", map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<String> selectSido() {
		List<String> list = null;

		try {
			list = sqlMap.queryForList("jqueryEmp.sido");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public List<String> selectGugun(String info) {
		List<String> list = null;

		try {
			list = sqlMap.queryForList("jqueryEmp.gugun", info);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public List<String> selectDong(String info) {
		List<String> list = null;

		try {
			list = sqlMap.queryForList("jqueryEmp.dong", info);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
}
