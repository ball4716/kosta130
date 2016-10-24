package com.kosta._0830;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCTest {
	public static void main(String[] args) throws Exception{
		Properties pro = new Properties();
			pro.load(new FileReader("conn/conn.properties"));
			
		//드라이버 로딩(제품군 선택)
		Class.forName(pro.getProperty("driver"));
		
		//연결객체 생성하기
		/*Connection conn = DriverManager.getConnection(pro.getProperty("url"),
													  pro.getProperty("user"),
													  pro.getProperty("pass"));*/
		Connection conn = DriverManager.getConnection(pro.getProperty("url"),
													  pro);
		
		//DriverManager.getConnection(String url, String user, String password);
		//DriverManager.getConnection(String url, Properties info);
		
		System.out.println("DB연결 성공!!");
	}
}
