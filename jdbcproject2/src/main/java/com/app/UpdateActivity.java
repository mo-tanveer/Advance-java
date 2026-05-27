package com.app;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateActivity {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the code::");
		int _code = sc.nextInt();
		
		System.out.println("Enter the updated name:");
		String name = (new Scanner (System.in).nextLine());  //creates buffer
		
		System.out.println("Enter updated salary:");
		double salary = sc.nextDouble();
		
		try
		   {
			Connection cn = MyConnection.getConnected();
			
			if(!cn.isClosed())
			{
			PreparedStatement ps = cn.prepareStatement("update employee set salary=?, name=? where code=?;");
			
			ps.setDouble(1, salary);
			ps.setString(2, name);
			ps.setInt(3, _code);
			
			int a = ps.executeUpdate();
			
			if(a>0)
			{
				System.out.println("Record updated...");
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
