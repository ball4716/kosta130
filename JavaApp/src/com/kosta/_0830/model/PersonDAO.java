package com.kosta._0830.model;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class PersonDAO {// �� DAO (DataBase Access Object)
	// DAO: �����ͺ��̽��� �׼����ϴ� �ڹ� ��ü

	Connection conn;
	Statement stmt;
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

	public void delete() {// Ư���� ����

	}

	public void update() {// ����� Ư�������� ����

	}

	public void select() {// Ư���� ��ȸ

	}

	public ArrayList<PersonDTO> selectAll() {// ��ü�� ��ȸ
		connect();// conn��ü����
		ArrayList<PersonDTO> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			String sql = "select no,name,age,job from person";
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
