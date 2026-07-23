package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Authenticator.RequestorType;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class SecondServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		out.print("Second Serv:-"+req.getParameter("tname"));
	}

}
