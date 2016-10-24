package board.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.bean.GuestBean;

public class GuestDAO {
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public GuestDAO() {
		try {
			Context ctx = new InitialContext();
			Context tomCtx = (Context) ctx.lookup("java:comp/env");
			ds = (DataSource) tomCtx.lookupLink("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public boolean insert(GuestBean guest) {
		connect();
		try {
			String sql = "insert into guest (id,name,email,pass,tel,gdate,contents) values (guest_seq.nextval,?,?,?,?,sysdate,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, guest.getName());
			pstmt.setString(2, guest.getEmail());
			pstmt.setString(3, guest.getPass());
			pstmt.setString(4, guest.getTel());
			pstmt.setString(5, guest.getContents());

			int t = pstmt.executeUpdate();
			if (t != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public void delete() {
	}

	public boolean update(GuestBean user) {
		connect();
		try {
			String sql = "update guest set name=?,email=?,tel=?,pass=?,contents=? where id=?";
			System.out.println("id: " + user.getId());
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getTel());
			pstmt.setString(4, user.getPass());
			pstmt.setString(5, user.getContents());
			pstmt.setInt(6, user.getId());
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

	public GuestBean select(int id) {
		connect();
		GuestBean guest = null;
		try {
			String sql = "select id,name,email,pass,tel,gdate,contents from guest where id=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				guest = new GuestBean();
				guest.setName(rs.getString("name"));
				guest.setEmail(rs.getString("email"));
				guest.setPass(rs.getString("pass"));
				guest.setTel(rs.getString("tel"));
				guest.setGdate(rs.getDate("gdate"));
				guest.setContents(rs.getString("contents"));
				guest.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return guest;
	}

	public List<GuestBean> listBoard(int start, int end) {
		connect();

		List<GuestBean> list = new ArrayList<>();

		try {
			// String sql = "select id,name,pass,tel,gdate,contents from guest
			// order by id desc";
			String sql = "select id,name,pass,tel,gdate,contents"
					+ " from (select id,name,pass,tel,gdate,contents, rownum rn"
					+ "       from ( select id,name,pass,tel,gdate,contents" + "              from guest"
					+ "              order by id desc))" + " where rn between ? and ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				GuestBean guest = new GuestBean();
				guest.setId(rs.getInt("id"));
				guest.setName(rs.getString("name"));
				guest.setPass(rs.getString("pass"));
				guest.setTel(rs.getString("tel"));
				guest.setGdate(rs.getDate("gdate"));
				guest.setContents(rs.getString("contents"));
				list.add(guest);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}

	public int selectCount() {// 목록(list.jsp) 출력할 데이터 검색
		connect();
		int cnt = 0;
		try {
			String sql = "select count(*) from guest";
			pstmt = conn.prepareStatement(sql); // sql문 전달
			rs = pstmt.executeQuery(); // sql문 실행
			if (rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return cnt;
	}// selectCount

	public boolean delete(int id) {
		connect();
		try {
			String sql = "delete guest where id=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);
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

	void connect() {
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
