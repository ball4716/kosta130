package com.kosta._0830;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NameMenu3 {
	// �̸� �����͸� �����ϴ� �����
	// Vector ----> DB ���̺�!!(���̺��: names)

	Connection conn;
	Statement stmt;
	ResultSet rs;

	public NameMenu3() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}//������: Ư�� ---> �ѹ� ����, ���� �۾�
	

	public void insert(String name) {// �̸��Է�,����
		try {
			connect();
			stmt = conn.createStatement();
			String sql = "insert into names values ('"+name+"')";
			//---> insert into names values (ȫ�浿); (X)
			//---> insert into names values ('ȫ�浿'); (O)
			//---> insert into names value (13); name �÷��� number��� (O)
			
			stmt.executeUpdate(sql);//�������
			System.out.println("#�Է¼���!!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public void selectAll() {// ��ü�̸����,�˻�
		try {
			connect();
			stmt = conn.createStatement();
			String sql = "select * from names";
			
			rs = stmt.executeQuery(sql);
			System.out.println("#��ü���");
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

	public void delete(String delName) {// �̸�����
		try {
			connect();
			stmt = conn.createStatement();
			String sql = "delete from names where name = '"+delName+"'";
			
			int t = stmt.executeUpdate(sql);
			if(t>0){
				System.out.println(delName+" �� �����Ǿ����ϴ�.");
			} else {
				System.out.println("������ �����Ͱ� �����ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public void update(String oldName, String newName) {// �̸�����
		try {
			connect();
			stmt = conn.createStatement();
			String sql = "update names set name = '"+newName+"' where name = '"+oldName+"'";
			
			int t = stmt.executeUpdate(sql);
			if(t>0){
				System.out.println(oldName+"�� "+newName+"���� ����Ǿ����ϴ�.");
			} else {
				System.out.println("������ �����Ͱ� �����ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// �̸� ���������� �����ϴ� �޼ҵ�
	public boolean existName(String searchName) {// �̸��� �����ϸ� true����

		return false;
	}// existName
	
	private void connect(){//���ᰴü ����
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "scott", "tiger");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void disconnect(){//DB�ڿ� ��ȯ
		try {
			if(rs != null) rs.close();//�ڿ���ȯ
			if(stmt != null) stmt.close();//�ڿ���ȯ
			if(conn != null) conn.close();//�ڿ���ȯ
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}