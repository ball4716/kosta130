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

public class PersonDAO {// ★ DAO (DataBase Access Object)
	// DAO: 데이터베이스를 액세스하는 자바 객체

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

	public boolean delete(int delNo) {// 특정행 삭제
		connect();
		try {
			stmt = conn.createStatement();// 실행할 준비
			// String sql = "delete from person where no = 3";
			String sql = "delete from person where no = " + delNo;
			int t = stmt.executeUpdate(sql);// 삭제 실행 시점
			// t: 삭제 또는 수정된 행의 개수
			System.out.println("t=" + t);
			if (t == 1)
				return true;// 번호에 대한 한개의 행 삭제를 잘했다라면~
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public boolean update(PersonDTO dto) {// 행안의 특정데이터 수정
		connect();
		try {
			// String sql = "update person set age=18, job='장군', where no=5";
			String sql = "update person set age=?, job=? where no=?";
			pstmt = conn.prepareStatement(sql);// sql문을 update문 execute 실행전에 미리
												// 전달!!
			pstmt.setInt(1, dto.getAge());
			pstmt.setString(2, dto.getJob());
			pstmt.setInt(3, dto.getNo());

			int t = pstmt.executeUpdate();// 실제 update실행 시점!
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

	public PersonDTO select(int upNo) {// 특정행 조회 ---> 수정폼에 뿌려질 데이터를 조회
		connect();
		try {
			String sql = "select name,age,job from person where no=?";
			pstmt = conn.prepareStatement(sql);
			// Statement 객체를 생성할때 sql문을 DB에 미리 전달
			// ※주의: bind변수의 수만큼 데이터 설정하는 set 메소드를 호출!!
			// pstmt.setInt(int parameterIndex(물음표의순서), int x데이터);
			pstmt.setInt(1, upNo);
			rs = pstmt.executeQuery();// 실행시점
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
				 * else {//where절에서 일치하는 no를 찾지 못햇음!! return null; }
				 */
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}// select

	public ArrayList<PersonDTO> selectAll() {// 전체행 조회
		connect();// conn객체생성
		ArrayList<PersonDTO> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			String sql = "select no,name,age,job from person order by no";
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
