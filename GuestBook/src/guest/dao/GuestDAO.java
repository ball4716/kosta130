package guest.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import guest.dto.Guest;
import iba.SqlMapConfig;

public class GuestDAO {
	SqlMapClient smc;
	

	public GuestDAO() {
		smc = SqlMapConfig.getSqlMapInstance();
	}
	
	public boolean insert(Guest guest){
		try {
			smc.insert("guest.insert",guest);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(int id){
		try {
			int t = smc.delete("guest.delete", id);
			if(t==1)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(Guest guest){
		try {
			int t = smc.update("guest.update", guest);
			if(t==1)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Guest select(int id){//수정폼에 출력
		Guest guest =null;
		try {
			guest = (Guest) smc.queryForObject("guest.select",id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return guest;
	}
	
	public List<Guest> selectAll(){//리스트에 출력
		List<Guest> list = null;
		try {
			list = smc.queryForList("guest.selectAll");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
