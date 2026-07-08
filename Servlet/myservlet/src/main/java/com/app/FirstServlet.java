package com.app;


import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	
	//1. This is executed once in the life-cycle of servlet when first request falls on Servlet
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		JOptionPane.showMessageDialog(null, "The first request comes & servlet Init method executed");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		
//		out.println("The Get method is giving output to Browser");
		
		out.println("The first Response is coming from doGet the recived value is ::" + req.getParameter("txt_value"));
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =resp.getWriter();
		
		out.println("Do Post respond");
		out.close();
	}
	


}
