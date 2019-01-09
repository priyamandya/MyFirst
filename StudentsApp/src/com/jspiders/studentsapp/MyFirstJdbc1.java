package com.jspiders.studentsapp;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class MyFirstJdbc1 {

	public static void main(String[] args) {
	
		
		
		
		
		try {
			//1.Load the Driver
			Driver  d = new Driver();
			DriverManager.registerDriver(d);
			
			
			//2.Get the db connection via Driver
			//3.Issue SqL Queries via connection
			//4.Process the results returned by sql Queries

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				//5.close all jdbc objects

	}

}
