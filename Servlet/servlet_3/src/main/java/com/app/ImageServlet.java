package com.app;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(maxFileSize=1000000L)
public class ImageServlet extends HttpServlet {

	Connection cn;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		cn = (Connection)config.getServletContext().getAttribute("CONN");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			String name = req.getParameter("txt_name");
			Part _image_in_part = req.getPart("file_upload");
			
			InputStream ins = _image_in_part.getInputStream();
			
			PreparedStatement ps = cn.prepareStatement("insert into visual_data(name,image) values(?,?)");
			
			ps.setString(1, name);
			ps.setBlob(2, ins);
			
			int a = ps.executeUpdate();
			
			if(a>0)
			{
				PrintWriter out = resp.getWriter();
				
				out.println("record upload");
				out.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
