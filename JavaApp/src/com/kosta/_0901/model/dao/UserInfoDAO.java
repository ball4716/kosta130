package com.kosta._0901.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kosta._0901.model.dto.UserInfo;

public class UserInfoDAO {// DB를 직접 액세스하는 자바객체

	Properties pro;
	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;

	public UserInfoDAO() {
		try {
			pro = new Properties();
			pro.load(new FileReader("conn/conn.properties"));
			Class.forName(pro.getProperty("driver"));
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}// 생성자

	public void connect() {
		try {
			conn = DriverManager.getConnection(pro.getProperty("url"), pro);
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

	public boolean insert(UserInfo user) {// 회원가입
		connect();
		try {
			String sql = "insert into userinfo values (?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPass());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getSsn1());
			pstmt.setString(5, user.getSsn2());
			pstmt.setString(6, user.getPhone());
			pstmt.setString(7, user.getAddr());
			pstmt.setString(8, user.getJob());

			pstmt.executeUpdate();// insert 실행 요청!!
			// ---> executeUpdate(): 리턴--> 수정,삭제된 행의 갯수(입력된 행갯수 리턴X)
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public boolean delete(String id) {// 특정 회원 한명을 삭제
		return false;
	}

	public boolean update(UserInfo user) {// 회원 정보 수정
		connect();
		String sql = "update userinfo set ";
		return false;
	}

	public UserInfo find(String findId) {// 회원정보 수정폼에 뿌려질 데이터 검색
		connect();
		try {
			String sql = "select * from userinfo where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, findId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				UserInfo user = new UserInfo(rs.getString("id"), rs.getString("pass"), rs.getString("name"),
						rs.getString("ssn1"), rs.getString("ssn2"), rs.getString("phone"), rs.getString("phone"),
						rs.getString("job"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	public List<UserInfo> findAll() {// JTable(서비스창)에 뿌려줄 전체 UserInfo데이터 검색
		connect();
		try {
			String sql = "select * from userinfo";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			List<UserInfo> list = new ArrayList<>();
			while (rs.next()) {
				UserInfo user = new UserInfo(rs.getString("id"), rs.getString("pass"), rs.getString("name"),
						rs.getString("ssn1"), rs.getString("ssn2"), rs.getString("phone"), rs.getString("addr"),
						rs.getString("job"));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	public boolean findLogin(String id, String pass) {// 로그인(id,pass) 검사
		try {
			/*
			 * sql문?
			 * 
			 * <회원 1000명> String sql="select count(*) from userinfo"; //1000행 8열
			 * String sql="select id,pass from userinfo"; //1000행 2열 String
			 * sql="select id,pass from userinfo where id=id";//1행 2열
			 * 
			 * String sql="select pass from userinfo where id=id";//1행 1열
			 * 
			 * String
			 * sql="select count(*) from userinfo where id=id and pass=pass";
			 */
			connect();
			String sql = "select count(*) cnt from userinfo where id=? and pass=?";
			pstmt = conn.prepareStatement(sql);
			// 뷰: 아이디===> a' or 1=1-- , 비번==> 아무거나
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			rs.next();
			// rs.getInt("count(*)");//에러: 파라미터에 컬럼명사용, 함수명 사용 불가!!
			// rs.getInt(1) ---> 사용 가능
			int cnt = rs.getInt("cnt");
			if (cnt > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return false;
	}

	public String findLogin3(String id) {// 로그인(id,pass) 검사
		connect();
		String pass = null;
		try {
			String sql = "select pass from userinfo where id=?";
			pstmt = conn.prepareStatement(sql);
			// 뷰: 아이디===> a' or 1=1-- , 비번==> 아무거나
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {// 아이디가 존재한다면
				pass = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return pass;
	}// findLogin3

}
