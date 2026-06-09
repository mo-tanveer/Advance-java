package com.app;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.Scanner;


public class App 
{
    public static void main( String[] args )
    {
    	
    	Scanner sc = new Scanner(System.in);
        System.out.println("Enter the code...");
        int code = sc.nextInt();
       try {
    	   
    	   Connection cn = MyConnection.getConnected();
    	   
    	   if(!cn.isClosed())
    	   {
    		CallableStatement csbt = cn.prepareCall("{call getSalary(?)}");
    		
    		csbt.setInt(1, code);
    		csbt.registerOutParameter(1,Types.DOUBLE);
    		csbt.execute();
    		System.out.println("The salary of employee is ::"  + csbt.getString(1));
    	   }
    	   cn.close();
       }
       catch(Exception e)
       {
    	   System.out.println("Reason of error::" + e.getMessage());
       }
       
    }
}
