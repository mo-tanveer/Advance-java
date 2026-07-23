package com.app;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class SubServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		int value1 = Integer.parseInt(req.getParameter("txt_first"));
		int value2 = Integer.parseInt(req.getParameter("txt_Second"));
		
		int result = value1 - value2;
		
		RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
		rd.include(req, resp);
		out.println("<hr>");
		
		out.println("<font color=green>The result of Substraction ::- "+ result + "</font>");
	}

}
