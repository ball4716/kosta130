package t0921.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import t0921.dto.Emp;

public class EmpDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	Properties pro;

	public EmpDAO(String path) {
		try {
			pro = new Properties();
			//String path2 = this.getClass().getResource("").getPath();
			//pro.load(new FileReader(path2.substring(1,path2.indexOf("/WEB-INF"))+"/conn/conn.properties"));
			pro.load(new FileReader(path+"/conn/conn.properties"));
			Class.forName(pro.getProperty("driver"));
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

	// �����ȣ, �����, �Ի���, �޿�, �μ���
	public List<Emp> selectAll() {
		List<Emp> list= new ArrayList<>();
		connect();
		try {
			String sql = "select empno, ename, hiredate, sal, dname from emp natural join dept";
			
			pstmt = conn.prepareStatement(sql);//sql���� DB���� �̸� ����
			rs = pstmt.executeQuery();//�����û
			
			while(rs.next()){
				list.add(new Emp(rs.getInt("empno"),
						rs.getString("ename"),
						rs.getDate("hiredate"),
						rs.getInt("sal"),
						rs.getString("dname")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return list;
	}

	public void connect() {
		try {
			conn = DriverManager.getConnection(pro.getProperty("url"),pro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
