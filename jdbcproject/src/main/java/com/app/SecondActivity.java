

//Inserting single row (name , salary) in mysql cmd table 

package com.app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class SecondActivity {
  public static void main(String args[])
  {
	  Scanner sc = new Scanner(System.in);
	  
	  System.out.println("Enter the name::");
	  String name = sc.nextLine();
	  
	  System.out.println("Enter the Salary::");
	  Double salary = sc.nextDouble();
	  
	  try
	    {
		  Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mlk?autoReconnect=true&useSSL=false","root","boot");
		  
		  if(!cn.isClosed())
		  {
			  //PraparedStatement -> writing sql queries into java file 
			  PreparedStatement ps = cn.prepareStatement("insert into employee(name,salary) values(?,?)"); //?--> placeholder
			  
			  ps.setString(1, name);
			  ps.setDouble(2, salary);
			  
			  int a = ps.executeUpdate();  //insert,update,delete,create
			  
			  if(a>0)
			  {
				  System.out.println("Record Inserted");
			  }
		  }
				cn.close(); 
	    }
	     catch(Exception e)
	     {
	    	 System.out.println("Reason of Error::" + e.getMessage());
	     }
  }
}
