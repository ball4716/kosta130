package t0927;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class EmpDAO2 {
	DataSource ds;
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public EmpDAO2() {
		try {
			Context ctx = new InitialContext();
			Context tomCtx = (Context)ctx.lookup("java:comp/env");
			ds = (DataSource)tomCtx.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private void connect() {
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void disconnect() {
		try {
			if(rs!=null) pstmt.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Emp> selectEmp(){
		connect();
		List<Emp> list = new ArrayList<>();
		try {
			String sql = "select empno, ename, sal from emp";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				list.add(new Emp(rs.getInt("empno"),
						rs.getString("ename"),
						rs.getInt("sal"),null,null));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return list;
	}
}
