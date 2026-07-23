package com.app;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		try
		{
			int value1 = Integer.parseInt(req.getParameter("txt_first"));
			int value2 = Integer.parseInt(req.getParameter("txt_Second"));
			
			String operationName = req.getParameter("operation");
			
			if(operationName.equals("Add"))
			  {
				RequestDispatcher rd = req.getRequestDispatcher("/AddServlet");
				rd.forward(req, resp);
			  }
			
			else {
				RequestDispatcher rd = req.getRequestDispatcher("/SubServlet");
				rd.forward(req, resp);
			}

		}
		catch(Exception e)
		{
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			
			rd.include(req, resp);
			out.println("<hr>");
			
			out.println("<font color=red> Invalid Value Entered! </font>");
		}
		
	}
}
