package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DatabaseServlet extends HttpServlet {
	Connection cn;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mlk?autoReconnect=true&useSSL=false","root","boot");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("text_name");
		double salary = Double.parseDouble(req.getParameter("text_salary"));
		try {
			if(!cn.isClosed()) {
				PreparedStatement ps = cn.prepareStatement("insert into employee(name,salary) values(?,?)");
				ps.setString(1, name);
				ps.setDouble(2, salary);
				int a = ps.executeUpdate();
				if(a>0) {
					out.println("record inserted!");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			if(!cn.isClosed()) {
				cn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}