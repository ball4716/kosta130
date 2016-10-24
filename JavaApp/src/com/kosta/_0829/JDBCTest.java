package com.kosta._0829;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class JDBCTest {
	// ����) 30�� �μ��� �ٹ��ϴ� ����� �����ȣ, �����, �Ի����� ��ȸ, ����Ͻÿ�.
	Connection conn;
	Statement stmt;
	// ------------------sql����(DML)--------------------

	ResultSet rs;
	// ------------------sql����(DQL)--------------------

	public JDBCTest() {
		try {
			// 1. ����̹��ε�(��ǰ�� ����)
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection��ü ����(����: DB�� �ּ�,��Ʈ,sid,����user,���)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");

			// 3. Statement ��ü ����(���� sql�� ����!!)
			stmt = conn.createStatement();
			String sql = "select empno, ename, hiredate from emp where deptno=20";
			ResultSet rs = stmt.executeQuery(sql);// ��ȸ: executeQuery, ����:
													// executeUpdate

			/*
			 * <Result Set rs ----> 6�� 3�� >
			 * 
			 * EMPNO ENAME HIREDATE ---------- -------------------- --------
			 * 7499 ALLEN 81/02/20 rs.next(); 7521 WARD 81/02/22 rs.next(); 7654
			 * MARTIN 81/09/28 rs.next(); 7698 BLAKE 81/05/01 rs.next(); 7844
			 * TURNER 81/09/08 rs.next(); 7900 JAMES 81/12/03 rs.next();
			 */

			// rs.next();//�� �� ������ ---> ���� ��(�����)�� ������ true����
			// rs.next()�� �ַ� if��(������� �ִ� 1�� primary key��) �Ǵ� while��(������� 2���̻�)��
			// �Բ� ���
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				Date hiredate = rs.getDate("hiredate");

				System.out.println("���:" + empno + ", �����:" + ename + ", �Ի���:" + hiredate);
			}
			/*rs.next();// �� �� ������
			empno = rs.getInt("empno");
			ename = rs.getString("ename");
			hiredate = rs.getDate("hiredate");

			System.out.println("���:" + empno + ", �����:" + ename + ", �Ի���:" + hiredate);

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
