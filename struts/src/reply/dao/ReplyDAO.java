package reply.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import iba.SqlMapConfig;
import reply.dto.Reply;

public class ReplyDAO {
	
	SqlMapClient sqlMap;
	
	public ReplyDAO() {
		sqlMap = SqlMapConfig.getSqlMapInstance();
	}
	
	public boolean insert(Reply reply){
		try {
			sqlMap.insert("reply.add",reply);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(int no){
		try {
			int t = sqlMap.delete("reply.delete",no);
			if(t==1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean update(Reply reply){
		try {
			int t = sqlMap.update("reply.update", reply);
			if(t==1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public Reply find(int no){
		Reply reply=null;
		try {
			reply = (Reply) sqlMap.queryForObject("reply.find", no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reply;
	}
	public List<Reply> findAll(){
		List<Reply> list=null;
		try {
			list = sqlMap.queryForList("reply.findAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
