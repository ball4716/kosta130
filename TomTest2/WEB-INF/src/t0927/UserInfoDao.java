package t0927;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserInfoDao {
	DataSource ds;

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public UserInfoDao() {
		try {
			Context ctx = new InitialContext();
			Context tomCtx = (Context) ctx.lookup("java:comp/env");
			ds = (DataSource) tomCtx.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public boolean insert(UserInfo user) {
		connect();
		String sql = "insert into userinfo (id,pass,name,jumin,birth,zip,addr,email,job)"
				+ "values (?,?,?,?,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPass());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getJumin());
			pstmt.setString(5, user.getBirth());
			pstmt.setString(6, user.getZip());
			pstmt.setString(7, user.getAddr());
			pstmt.setString(8, user.getEmail());
			pstmt.setString(9, user.getJob());

			pstmt.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public String selectLogin(UserInfo user) {
		connect();
		String sql = "select pass from userinfo where id=?";
		String result = "failId";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user.getId());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (user.getPass().equals(rs.getString("pass")))
					result = "success";
				else
					result = "failPass";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// ID,PASS,NAME,JUMIN,BIRTH,ZIP,ADDR,EMAIL,JOB
	public UserInfo select(String id) {// 수정폼에 출력할 단행 데이터를 얻어오기
		connect();
		UserInfo user = null;
		try {
			String sql = "select pass,name,jumin,birth,zip,addr,email,job " + "from userinfo where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {// 조건절 아이디에 해당하는 행이 존재한다면
				user = new UserInfo(id, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return user;
	}
	
	public boolean existId(String id) {// 아이디 존재 여부
		connect();
		try {
			String sql = "select count(*) cnt from userinfo where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			int cnt = rs.getInt(1);
			if(cnt==1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public boolean delete(String id) {
		connect();
		try {
			String sql = "delete from userinfo where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			int t = pstmt.executeUpdate();
			if (t == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public boolean update(UserInfo user) throws SQLException {
		connect();

		String sql = "update userinfo set pass=?, zip=?, addr=?, email=?, job=? where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getPass());
		pstmt.setString(2, user.getZip());
		pstmt.setString(3, user.getAddr());
		pstmt.setString(4, user.getEmail());
		pstmt.setString(5, user.getJob());
		pstmt.setString(6, user.getId());
		int t = pstmt.executeUpdate();
		System.out.println("업데이트된 행의 수:"+t);
		System.out.println("id:"+user.getId());
		disconnect();
		if (t == 1)
			return true;
		return false;
	}//update

	public void connect() {
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
