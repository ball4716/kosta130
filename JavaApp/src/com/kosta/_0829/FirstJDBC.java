package com.kosta._0829;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstJDBC {
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public FirstJDBC() {
		try {
			//1. Driver loading(제품군 선택)
			//Class.forName(String className);
			Class.forName("oracle.jdbc.driver.OracleDriver");//ClassNotFoundException
			
			//2. Connection객체 생성(DB연결시도)
			//conn = DriverManager.getConnection(String url, String user, String password);
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger"); //SQLException
			
			System.out.println("DB연결 성공!!");
			
			//------------------------------------------------------------------------------------------
			
			//3. Statement객체 생성(왜? sql문을 실행하는 메소드가 위치)
			stmt = conn.createStatement();
			
			//문제)dept_copy테이블에서 10번부서와 30번 부서를 삭제하시오.
			//stmt.executeUpdate(String sql);
			String sql = "delete from dept_copy where deptno in (10,30)";//문자열 내에서 세미콜론은 찍지 않는다
			int t = stmt.executeUpdate(sql);//t: 삭제 또는 수정된 행의 갯수가 리턴!!, 이클립스는 오토커밋
			if(t>0){
				System.out.println("삭제 성공!!");
			} else {
				System.out.println("삭제 실패!!");
			}
			
			//문제)dept_copy테이블: 20번 부서의 부서번호, 부서명, 부서위치를 출력하시오
			sql = "select deptno no, dname, loc from dept_copy where deptno=20";
			rs = stmt.executeQuery(sql);
			//rs: 결과집합 객체(행열데이터를 담는 객체)
			//1.행 얻어오기 2.행 안의 데이터 얻어오기 get자료형()
			//---------행구하기---------------
			rs.next();
			//rs.getInt(int columnIndex);
			//rs.getInt(String columnLabel)
			//----------(한개의 행내의)열데이터 구하기-----------
			int deptno = rs.getInt("no");//rs.getInt(1);
			String dname = rs.getString("dname");//rs.getString(2);
			String location = rs.getString("loc");//rs.getString(3);
			
			System.out.println(deptno+"부서의 부서명은 "+dname+"이고 위치는 "+location+"입니다");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//생성자

	public static void main(String[] args) {
		new FirstJDBC();
	}
}
