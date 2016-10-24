package com.kosta._0912;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class HaksaDAO {//DB를 직접 액세스하는 자바 객체
	Properties pro;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public HaksaDAO() {
		try {
			pro = new Properties();
			pro.load(new FileReader("conn/conn.properties"));
			Class.forName(pro.getProperty("driver"));
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}//생성자
	
	public void connect(){
		try {
			conn = DriverManager.getConnection(pro.getProperty("url"),pro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect(){
		try {
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(rs!=null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean insert(HaksaDTO haksa){
		connect();
		try {
			String sql = "insert into Haksa values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, haksa.getName());
			pstmt.setInt(2, haksa.getAge());
			pstmt.setString(3, haksa.getInfo());
			pstmt.setInt(4, haksa.getJobno());
			
			if(pstmt.executeUpdate()>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
	
	public void delete(){
		
	}
	
	public void select(){
		
	}
	
	public String selectJob(int jobno){
		connect();
		String job = null;
		try {
			String sql = "select jobname from Job where jobno = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, jobno);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				job = rs.getString("jobname");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return job;
	}
	
	public void selectAll(){
		
	}
}
