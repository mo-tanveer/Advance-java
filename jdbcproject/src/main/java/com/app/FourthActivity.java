//combination of 2nd and 3
package com.app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class FourthActivity {
	
	public static void showRecords(Connection cn) throws Exception
	{
		PreparedStatement ps =cn.prepareStatement("select * from employee");
		
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			System.out.println("-------------");
		
		System.out.println(rs.getMetaData().getColumnLabel(1) + "::" + rs.getInt(1));
		System.out.println(rs.getMetaData().getColumnLabel(2) + "::" + rs.getString(2));
		System.out.println(rs.getMetaData().getColumnLabel(3) + "::" + rs.getString(3));

		    System.out.println("---------------");

	  }
	}

	public static void main(String args[])
	{
		Scanner sc =  new Scanner(System.in);
		System.out.println("Enter the name");
		String name = sc.nextLine();
		System.out.println("Enter the Salary");
		double salary = sc.nextDouble();
		
		try 
		{
		   Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mlk?autoReconnect=true&useSSL=false","root","boot");
		   
		   if(!cn.isClosed())
		   {
			   PreparedStatement ps = cn.prepareStatement("insert into employee(name,salary) values(?,?)");
			   
			   ps.setString(1, name);
			   ps.setDouble(2, salary);
			   
			   int a = ps.executeUpdate();
			   
			   if(a>0)
			   {
				   System.out.println("Record added..");
				   showRecords(cn);
				   
			   }
		   }
		   cn.close();
		   
		}
		catch(Exception e)
		{
			System.out.println("Reason for error::" + e.getMessage());
		}
		
		
	}
}
