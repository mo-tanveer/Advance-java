package com.app;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
public static Connection getConnected() throws Exception
{
  Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mlk?autoReconnect=true&useSSL=false","root","boot");
  return cn;
}
}