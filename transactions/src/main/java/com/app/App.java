package com.app;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the source account no. ::");
        int _source = sc.nextInt();
        
        System.out.println("Enter the target account no. ::");
        int _target = sc.nextInt();
        
        System.out.println("Amount to be transferred::");
        double _amount = sc.nextDouble();
        
        try {
        	Connection cn = MyConnection.getConnected();
        	
        	if(!cn.isClosed())
        	{
        		cn.setAutoCommit(false);
        		
        		Statement statement = cn.createStatement();
        		
        		statement.addBatch("update account_info set balance_amount = balance_amount - " + _amount + " where acno = " + _source + " ");
        		statement.addBatch("update account_info set balance_amount = balance_amount + " + _amount + " where acno = " + _target + " ");
        		
        		int [] status = statement.executeBatch();
        		boolean isSuccess = true;
        		
        		for(int i : status)
        		{
        			if(i<1)
        			{
        				isSuccess = false;
        				break;
        			}
        		}
        		
        		if(isSuccess)
        		{
        			cn.commit();
        			System.out.println("Transaction successful!");
        		}
        		else
        		{
        			cn.rollback(); //remove all queries bcoz transaction failed
        			System.out.println("Transaction failed!");
        		}
        	}
        	cn.close();
        }
        catch(Exception e)
        {
        	System.out.println("Reason of error::" + e.getMessage());
        }
;    }
}
