package com.app;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

public class MyResponseWrapper extends HttpServletResponseWrapper {

	HttpServletResponse resp;
	public MyResponseWrapper(HttpServletResponse response) {
		super(response);
		this.resp = response;
	}
	
	@Override
	public void setContentType(String type) {
		// TODO Auto-generated method stub
		
		if(type.equals("text/html"))
		{
			super.setContentType("text/html");
		}
	}

}
