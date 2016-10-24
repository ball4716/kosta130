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
			//1. Driver loading(��ǰ�� ����)
			//Class.forName(String className);
			Class.forName("oracle.jdbc.driver.OracleDriver");//ClassNotFoundException
			
			//2. Connection��ü ����(DB����õ�)
			//conn = DriverManager.getConnection(String url, String user, String password);
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger"); //SQLException
			
			System.out.println("DB���� ����!!");
			
			//------------------------------------------------------------------------------------------
			
			//3. Statement��ü ����(��? sql���� �����ϴ� �޼ҵ尡 ��ġ)
			stmt = conn.createStatement();
			
			//����)dept_copy���̺��� 10���μ��� 30�� �μ��� �����Ͻÿ�.
			//stmt.executeUpdate(String sql);
			String sql = "delete from dept_copy where deptno in (10,30)";//���ڿ� ������ �����ݷ��� ���� �ʴ´�
			int t = stmt.executeUpdate(sql);//t: ���� �Ǵ� ������ ���� ������ ����!!, ��Ŭ������ ����Ŀ��
			if(t>0){
				System.out.println("���� ����!!");
			} else {
				System.out.println("���� ����!!");
			}
			
			//����)dept_copy���̺�: 20�� �μ��� �μ���ȣ, �μ���, �μ���ġ�� ����Ͻÿ�
			sql = "select deptno no, dname, loc from dept_copy where deptno=20";
			rs = stmt.executeQuery(sql);
			//rs: ������� ��ü(�࿭�����͸� ��� ��ü)
			//1.�� ������ 2.�� ���� ������ ������ get�ڷ���()
			//---------�౸�ϱ�---------------
			rs.next();
			//rs.getInt(int columnIndex);
			//rs.getInt(String columnLabel)
			//----------(�Ѱ��� �೻��)�������� ���ϱ�-----------
			int deptno = rs.getInt("no");//rs.getInt(1);
			String dname = rs.getString("dname");//rs.getString(2);
			String location = rs.getString("loc");//rs.getString(3);
			
			System.out.println(deptno+"�μ��� �μ����� "+dname+"�̰� ��ġ�� "+location+"�Դϴ�");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//������

	public static void main(String[] args) {
		new FirstJDBC();
	}
}
