package com.jspiders.studentsapp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.Properties;


public class MyFirstJdbc {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException  {
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			//1. load the Driver.
			/*Driver 	d = new Driver();
			DriverManager.registerDriver(d);
			*/
			Class.forName("com.mysql.jdbc.Driver");
		FileReader fr=new FileReader("C:\\Users\\PRIYANKA\\Desktop\\abc.properties");
		Properties props=new Properties();
		props.load(fr);
		
			
			//2.Get the db Connection via Driver
			String dbUrl="jdbc:mysql://localhost:3306/bece26?";
			con=DriverManager.getConnection(dbUrl,props);
			
			//3.Issue SQl Queries via Connection
			String query="select * from students_info where regno=?";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(args[0]));
			/*pstmt.setString(2, args[1]);
			pstmt.setString(3,args[2]);
			pstmt.setString(4, args[3]);*/
			 rs=pstmt.executeQuery();
			
			//4.Process the results returned by Sql Queries
			if(rs.next()) {
				
			int rg=	rs.getInt("regno");
			String fn=rs.getString("firstname");
			String mn=rs.getString("middlename");
			String ln=rs.getString("lastname");
			System.out.println(rg);
			System.out.println(fn);
			System.out.println(mn);
			System.out.println(ln);
			}else {
				System.out.println("fail to login");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//5.close All jdbc objects
		finally {
			if(con!=null) {
				con.close();
			}if(pstmt!=null) {
				pstmt.close();
			}if(rs!=null) {
				rs.close();
			}
		}
	}

}
