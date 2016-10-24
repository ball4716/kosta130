package com.kosta._0829;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class JDBCTest {
	// 문제) 30번 부서에 근무하는 사원의 사원번호, 사원명, 입사일을 조회, 출력하시오.
	Connection conn;
	Statement stmt;
	// ------------------sql업무(DML)--------------------

	ResultSet rs;
	// ------------------sql업무(DQL)--------------------

	public JDBCTest() {
		try {
			// 1. 드라이버로딩(제품군 선택)
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection객체 생성(연결: DB의 주소,포트,sid,계정user,비번)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");

			// 3. Statement 객체 생성(실제 sql문 실행!!)
			stmt = conn.createStatement();
			String sql = "select empno, ename, hiredate from emp where deptno=20";
			ResultSet rs = stmt.executeQuery(sql);// 조회: executeQuery, 조작:
													// executeUpdate

			/*
			 * <Result Set rs ----> 6행 3열 >
			 * 
			 * EMPNO ENAME HIREDATE ---------- -------------------- --------
			 * 7499 ALLEN 81/02/20 rs.next(); 7521 WARD 81/02/22 rs.next(); 7654
			 * MARTIN 81/09/28 rs.next(); 7698 BLAKE 81/05/01 rs.next(); 7844
			 * TURNER 81/09/08 rs.next(); 7900 JAMES 81/12/03 rs.next();
			 */

			// rs.next();//한 행 얻어오기 ---> 얻어올 행(결과행)이 있을때 true리턴
			// rs.next()는 주로 if문(결과행이 최대 1개 primary key등) 또는 while문(결과행이 2개이상)과
			// 함께 사용
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				Date hiredate = rs.getDate("hiredate");

				System.out.println("사번:" + empno + ", 사원명:" + ename + ", 입사일:" + hiredate);
			}
			/*rs.next();// 한 행 얻어오기
			empno = rs.getInt("empno");
			ename = rs.getString("ename");
			hiredate = rs.getDate("hiredate");

			System.out.println("사번:" + empno + ", 사원명:" + ename + ", 입사일:" + hiredate);

			System.out.println(rs.next());
			System.out.println(rs.next());
			System.out.println(rs.next());
			System.out.println(rs.next());
			System.out.println(rs.next());
			System.out.println(rs.next());*/

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new JDBCTest();
	}
}
