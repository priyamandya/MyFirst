package com.jspiders.studentsapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.SynchronousQueue;

import com.mysql.jdbc.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CreateProfile {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//1. Load the Driver
			Driver d=new Driver();
			DriverManager.registerDriver(d);

			//2. Get the db connection via Driver

			String dbUrl="jdbc:mysql://localhost:3306/bece26?user=root&password=root";
			con=DriverManager.getConnection(dbUrl);

			//3. Issue sql queries via connection

			String query="select * from students_info where regno=?";

			pstmt=con.prepareStatement(query);
			pstmt.setInt(1,Integer.parseInt(args[0]));
			/*pstmt.setString(2,args[1]);
			pstmt.setString(3, args[2]);
			pstmt.setString(4,args[3]);*/
			//int count=pstmt.executeUpdate();
			rs=pstmt.executeQuery();


			//4. Process the results returned by sql queries

			if(rs.next()) {
				
				int rg=	rs.getInt("regno");
				String fn=rs.getString("firstname");
				String mn=	rs.getString("middlename");
				String ln=	rs.getString("lastname");
				System.out.println(rg);
				System.out.println(fn);
				System.out.println(ln);
				System.out.println(mn);
			}else {
				System.out.println("fail to login....");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		//5. close all the jdbc objects.
		finally {
			if(con!=null) {
				con.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(rs!=null) {
				rs.close();
			}
		}
	}

}
