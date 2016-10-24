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

public class UserInfoDAO {// DB�� ���� �׼����ϴ� �ڹٰ�ü

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
	}// ������

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

	public boolean insert(UserInfo user) {// ȸ������
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

			pstmt.executeUpdate();// insert ���� ��û!!
			// ---> executeUpdate(): ����--> ����,������ ���� ����(�Էµ� �హ�� ����X)
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public boolean delete(String id) {// Ư�� ȸ�� �Ѹ��� ����
		return false;
	}

	public boolean update(UserInfo user) {// ȸ�� ���� ����
		connect();
		String sql = "update userinfo set ";
		return false;
	}

	public UserInfo find(String findId) {// ȸ������ �������� �ѷ��� ������ �˻�
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

	public List<UserInfo> findAll() {// JTable(����â)�� �ѷ��� ��ü UserInfo������ �˻�
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

	public boolean findLogin(String id, String pass) {// �α���(id,pass) �˻�
		try {
			/*
			 * sql��?
			 * 
			 * <ȸ�� 1000��> String sql="select count(*) from userinfo"; //1000�� 8��
			 * String sql="select id,pass from userinfo"; //1000�� 2�� String
			 * sql="select id,pass from userinfo where id=id";//1�� 2��
			 * 
			 * String sql="select pass from userinfo where id=id";//1�� 1��
			 * 
			 * String
			 * sql="select count(*) from userinfo where id=id and pass=pass";
			 */
			connect();
			String sql = "select count(*) cnt from userinfo where id=? and pass=?";
			pstmt = conn.prepareStatement(sql);
			// ��: ���̵�===> a' or 1=1-- , ���==> �ƹ��ų�
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			rs.next();
			// rs.getInt("count(*)");//����: �Ķ���Ϳ� �÷�����, �Լ��� ��� �Ұ�!!
			// rs.getInt(1) ---> ��� ����
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

	public String findLogin3(String id) {// �α���(id,pass) �˻�
		connect();
		String pass = null;
		try {
			String sql = "select pass from userinfo where id=?";
			pstmt = conn.prepareStatement(sql);
			// ��: ���̵�===> a' or 1=1-- , ���==> �ƹ��ų�
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {// ���̵� �����Ѵٸ�
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
