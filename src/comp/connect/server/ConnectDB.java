package comp.connect.server;

import java.sql.*;

public class ConnectDB 
{
	static Connection con =null;
	 public static Connection connect()
	 {
		 if(con==null)
		 {
		 
			 try 
			 {
				Class.forName("com.mysql.jdbc.Driver");
				 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rem_db", "root", "");
				
				
			 } 
			 catch (Exception e) 
			 {
				System.out.println("Something wents Wrong......");
				e.printStackTrace();
			 }
		 }
		 return con;
	 }
	 
}
