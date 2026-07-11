package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.swing.JOptionPane;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	
	Connection cn;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		cn = (Connection)config.getServletContext().getAttribute("CONN");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			PrintWriter out = resp.getWriter();
			
			if(!cn.isClosed())
			{
				out.println("Database Connection is present in the Servlet");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
