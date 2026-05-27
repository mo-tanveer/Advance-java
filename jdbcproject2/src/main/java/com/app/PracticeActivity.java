package com.app;

import java.sql.Statement;
import java.sql.Connection;
import java.util.Scanner;

public class PracticeActivity{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter source account number::");
		int source = sc.nextInt();
		
		System.out.println("Enter the target acc no.::");
		int target = sc.nextInt();
		
		System.out.println("Amount to be transfered::");
		double amount = sc.nextDouble();
		
		try {
			Connection cn = MyConnection.getConnected();
			
			if(!cn.isClosed())
			{
				cn.setAutoCommit(false);
				
				Statement state = cn.createStatement();
				
				state.addBatch("update account_info set balance_amount = balance_amount-" + amount +" where acno=" + source + " ");
				
				state.addBatch("update account_info set balance_amount = balance_amount+" + amount +" where acno=" + target + " ");
				
				int status[] = state.executeBatch();
				
				boolean isSuccess = true;
				
				for(int i : status)
				{
					if(i < 1)
					{
						isSuccess = false;
						break;
					}
				}
				
				if(isSuccess)
				{
					cn.commit();
					System.out.println("transaction successfull...");
				}
				else {
					cn.rollback();
					System.out.println("Transaction Failed....");
				}

			}
			cn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}