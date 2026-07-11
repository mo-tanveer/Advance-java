package com.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {

	String names,teacher;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		JOptionPane.showMessageDialog(null, "first request Arrives: Init executed");
		names = config.getInitParameter("Students");
		
		ServletContext webSiteInstance = config.getServletContext();
		teacher = webSiteInstance.getInitParameter("Teacher");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println("Get Method Giving output to server Hello " + names);
		out.println("<hr>");
		out.println("The Teacher Name is" + teacher);  
		out.close();
	}
}
