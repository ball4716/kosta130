package com.kosta.myapp;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class OracleConnectionTest{
	@Test
	public void testConnection() throws ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	      try(Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","scott","tiger")) {
			System.out.println("CONN="+conn);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}