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

public class PersonDAO {// ★ DAO (DataBase Access Object)
	// DAO: 데이터베이스를 액세스하는 자바 객체

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

	private void connect() {// 연결객체 생성
		try {
			conn = DriverManager.getConnection(pro.getProperty("url"), pro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void disconnect() {// DB관련 객체 반환
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

	public boolean insert(PersonDTO person) {// 행추가
		connect();
		try {
			stmt = conn.createStatement();
			// String sql="insert into person values (1, '홍길동', 13, '학생')";
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

	public void delete() {// 특정행 삭제

	}

	public void update() {// 행안의 특정데이터 수정

	}

	public void select() {// 특정행 조회

	}

	public ArrayList<PersonDTO> selectAll() {// 전체행 조회
		connect();// conn객체생성
		ArrayList<PersonDTO> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			String sql = "select no,name,age,job from person";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {// rs.next(): 결과행이 있다면 true 리턴
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
