package s1018.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import iba.SqlMapConfig;
import s1018.dto.Emp;

public class EmpDAO {
	SqlMapClient smc;
	
	public EmpDAO() {
		smc = SqlMapConfig.getSqlMapInstance();
	}
	
	public List<Emp> select(){
		List<Emp> list = null;
		try {
			list = smc.queryForList("s1018.select");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
