package com.kosta._0830;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NameMenu3 {
	// 이름 데이터를 저장하는 저장소
	// Vector ----> DB 테이블!!(테이블명: names)

	Connection conn;
	Statement stmt;
	ResultSet rs;

	public NameMenu3() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}//생성자: 특성 ---> 한번 실행, 선행 작업
	

	public void insert(String name) {// 이름입력,저장
		try {
			connect();
			stmt = conn.createStatement();
			String sql = "insert into names values ('"+name+"')";
			//---> insert into names values (홍길동); (X)
			//---> insert into names values ('홍길동'); (O)
			//---> insert into names value (13); name 컬럼이 number라면 (O)
			
			stmt.executeUpdate(sql);//실행시점
			System.out.println("#입력성공!!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public void selectAll() {// 전체이름출력,검색
		try {
			connect();
			stmt = conn.createStatement();
			String sql = "select * from names";
			
			rs = stmt.executeQuery(sql);
			System.out.println("#전체목록");
			System.out.println("=======");
			
			while(rs.next()){
				System.out.println(rs.getString("name"));
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public void delete(String delName) {// 이름삭제
		try {
			connect();
			stmt = conn.createStatement();
			String sql = "delete from names where name = '"+delName+"'";
			
			int t = stmt.executeUpdate(sql);
			if(t>0){
				System.out.println(delName+" 이 삭제되었습니다.");
			} else {
				System.out.println("삭제할 데이터가 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public void update(String oldName, String newName) {// 이름수정
		try {
			connect();
			stmt = conn.createStatement();
			String sql = "update names set name = '"+newName+"' where name = '"+oldName+"'";
			
			int t = stmt.executeUpdate(sql);
			if(t>0){
				System.out.println(oldName+"이 "+newName+"으로 변경되었습니다.");
			} else {
				System.out.println("변경할 데이터가 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 이름 존재유무를 리턴하는 메소드
	public boolean existName(String searchName) {// 이름이 존재하면 true리턴

		return false;
	}// existName
	
	private void connect(){//연결객체 생성
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "scott", "tiger");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void disconnect(){//DB자원 반환
		try {
			if(rs != null) rs.close();//자원반환
			if(stmt != null) stmt.close();//자원반환
			if(conn != null) conn.close();//자원반환
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}