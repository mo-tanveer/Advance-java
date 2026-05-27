
//How to connect JDBC

package com.app;
import java.sql.Connection;
import java.sql.DriverManager;

public class FirstActivity {
public static void main(String args[])
{
   try {
	   
	   Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mlk?autoReconnect=true&useSSL=false","root","boot");
	   
	   if(!cn.isClosed());
	   {
		   System.out.println("Database server connected...");
	   }
	   
   }catch(Exception e)
   {
	   System.out.println("Reason for Error::" + e.getMessage());
   }
}
}
