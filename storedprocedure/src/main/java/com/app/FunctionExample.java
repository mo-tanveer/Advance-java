package com.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class FunctionExample {
public static void main(String args[])
{
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the code::");
	int _code = sc.nextInt();
	
	try(Connection cn = MyConnection.getConnected())  //try for the resource --> close() statement will not write
			{
		       PreparedStatement ps = cn.prepareStatement("select calculatePF(?)");
		       ps.setInt(1, _code);
		       ResultSet rs = ps.executeQuery();
		       rs.next();
		       
		       System.out.println("The Provident Fund is ::" + rs.getString(1));
			}
	catch(Exception e) 
	{
		System.out.println("Reason of error::" + e.getMessage());
	}
	
  }
}
