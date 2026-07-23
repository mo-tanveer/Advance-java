package com.app;

import javax.swing.JOptionPane;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

public class MyHandler extends TagSupport {

	
	public int doStartTag() throws JspException{
		
		try {
			JspWriter out = pageContext.getOut();
			out.println("Hi tanveer");
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Reason for error" + e.getMessage());
		}
		
		
		
		return SKIP_BODY;
		
		
	}
}
