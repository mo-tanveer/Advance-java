package com.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchActivity {
public static void main(String args[])
{
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the code::");
	int _code = sc.nextInt();
	
	try {
		Connection cn = MyConnection.getConnected();
		
		if(!cn.isClosed())
		{
			PreparedStatement ps = cn.prepareStatement("select * from employee where code=?");
			
			ps.setInt(1, _code);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				System.out.println(rs.getString(1)  + " " + rs.getString(2) + " " + rs.getString(3)); 
			}
			else
			{
				System.out.println("Record Does not Exist");
				
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
