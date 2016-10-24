package s1017.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import iba.SqlMapConfig;

public class EmpDAO {
	SqlMapClient smc;
	
	public EmpDAO() {
		smc = SqlMapConfig.getSqlMapInstance();
	}
	
	public List<String> select(String keyword){
		List<String> list=null;
		try {
			list = smc.queryForList("ajax.select",keyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
