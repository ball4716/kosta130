package com.kosta._0831.model;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class PersonDAO {// �� DAO (DataBase Access Object)
	// DAO: �����ͺ��̽��� �׼����ϴ� �ڹ� ��ü

	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	Properties pro;

	public PersonDAO() {
		try {
			pro = new Properties();
			pro.load(new FileReader("conn/conn.properties"));
			Class.forName(pro.getProperty("driver"));
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

	private void connect() {// ���ᰴü ����
		try {
			conn = DriverManager.getConnection(pro.getProperty("url"), pro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void disconnect() {// DB���� ��ü ��ȯ
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean insert(PersonDTO person) {// ���߰�
		connect();
		try {
			stmt = conn.createStatement();
			// String sql="insert into person values (1, 'ȫ�浿', 13, '�л�')";
			String sql = "insert into person values (person_seq.nextval,'" + person.getName() + "'," + person.getAge()
					+ ",'" + person.getJob() + "')";
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}// insert

	public boolean delete(int delNo) {// Ư���� ����
		connect();
		try {
			stmt = conn.createStatement();// ������ �غ�
			// String sql = "delete from person where no = 3";
			String sql = "delete from person where no = " + delNo;
			int t = stmt.executeUpdate(sql);// ���� ���� ����
			// t: ���� �Ǵ� ������ ���� ����
			System.out.println("t=" + t);
			if (t == 1)
				return true;// ��ȣ�� ���� �Ѱ��� �� ������ ���ߴٶ��~
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public boolean update(PersonDTO dto) {// ����� Ư�������� ����
		connect();
		try {
			// String sql = "update person set age=18, job='�屺', where no=5";
			String sql = "update person set age=?, job=? where no=?";
			pstmt = conn.prepareStatement(sql);// sql���� update�� execute �������� �̸�
												// ����!!
			pstmt.setInt(1, dto.getAge());
			pstmt.setString(2, dto.getJob());
			pstmt.setInt(3, dto.getNo());

			int t = pstmt.executeUpdate();// ���� update���� ����!
			//
			if (t == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}//

	public PersonDTO select(int upNo) {// Ư���� ��ȸ ---> �������� �ѷ��� �����͸� ��ȸ
		connect();
		try {
			String sql = "select name,age,job from person where no=?";
			pstmt = conn.prepareStatement(sql);
			// Statement ��ü�� �����Ҷ� sql���� DB�� �̸� ����
			// ������: bind������ ����ŭ ������ �����ϴ� set �޼ҵ带 ȣ��!!
			// pstmt.setInt(int parameterIndex(����ǥ�Ǽ���), int x������);
			pstmt.setInt(1, upNo);
			rs = pstmt.executeQuery();// �������
			if (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String job = rs.getString("job");

				PersonDTO dto = new PersonDTO();
				dto.setName(name);
				dto.setAge(age);
				dto.setJob(job);

				return dto;
			} /*
				 * else {//where������ ��ġ�ϴ� no�� ã�� ������!! return null; }
				 */
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}// select

	public ArrayList<PersonDTO> selectAll() {// ��ü�� ��ȸ
		connect();// conn��ü����
		ArrayList<PersonDTO> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			String sql = "select no,name,age,job from person order by no";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {// rs.next(): ������� �ִٸ� true ����
				int no = rs.getInt("no");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String job = rs.getString("job");
				
				PersonDTO person = new PersonDTO(no, name, age, job);
				list.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}

}
