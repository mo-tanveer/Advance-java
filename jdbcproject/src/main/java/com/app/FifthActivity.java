package com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import util.Scanner;

public class FifthActivity {
public static void main(String args[])
{
	Scanner sc = new Scanner(System.in);
	
	try
	{
		Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mlk/?autoReconnect=true&useSSL=false","root","boot");
		
		if(!cn.isClosed())
		{
			PreparedStatement ps = cn.prepareStatement("")
		}
	}
	catch(Exception e)
	{
		System.out.println("Reason for error:: " + e.getMessage());
	}
}
}