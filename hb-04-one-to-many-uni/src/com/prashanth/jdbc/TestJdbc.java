package com.prashanth.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String dbUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			System.out.println("Connecting to database: "+dbUrl);
			Connection myConn = DriverManager.getConnection(dbUrl,user,pass);
			System.out.println("Connection Success");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
