package servletactivity;

import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletMethod extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "init method initialized");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		
		int n = Integer.parseInt(req.getParameter("txt_value"));
		
		int fact = 1;
		
		for(int i=1; i<=n; i++)
		{
		   fact = fact * i;
		}
		out.println(fact);
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
