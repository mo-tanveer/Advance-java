
//Showing output of MYSql cmd table into console of eclips

package com.app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ThirdActivity {

	public static void main(String args[])
	{
		try {
			Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mlk?autoReconnect=true&useSSL=false","root","boot");
			
			if(!cn.isClosed())
			{
				PreparedStatement ps = cn.prepareStatement("select * from employee");
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())
				{
					System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDouble(3));
				}
			}
			cn.close();
		}
		catch(Exception e) {
			System.out.println("Reason of error::" + e.getMessage());
		}
	}
}
