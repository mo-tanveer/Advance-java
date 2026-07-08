package com.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class ServletImp implements Servlet {

	
	 ServletConfig myconfig;
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return myconfig;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "Servlet Has Been Created!";
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		myconfig = config;
		
		JOptionPane.showMessageDialog(null, "Servlet Initialized");
	}

	//doGet + doPost ---> service()
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		out.println("Service Method is executed The recieved value ::" + request.getParameter("txt_value"));
		
		out.close();
			
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	
}
