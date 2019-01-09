package com.jspiders.studentsapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class Delete {

	public static void main(String[] args) throws SQLException {
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			//1.Load the driver
			Driver d=new Driver();
			DriverManager.registerDriver(d);
			
			
			//2. Get the db connection via Driver
			
			String dburl="jdbc:mysql://localhost:3306/bece26?user=root&password=root";
		 con=DriverManager.getConnection(dburl);
		 
		 //3. Issue sql queries via connection
		 
		 String query="select * from students_info where regno=?";
		 pstmt= con.prepareStatement(query);
		 pstmt.setInt(1,Integer.parseInt( args[0]));
		rs = pstmt.executeQuery();
		
		//4.process the results returned by sql queries
		
		
		if(rs.next()) {
			
		int regno=	rs.getInt("regno");
		String fs=	rs.getString("firstname");
		System.out.println(regno);
		System.out.println(fs);
			
		}else {
			System.out.println("fail to delete");
		}
		 
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//5.close all the jdbc objects
		finally {
			if(con!=null) {
				con.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
		
		}
		

	}

}
