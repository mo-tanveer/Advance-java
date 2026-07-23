package com.app;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class MyRequestWrapper extends HttpServletRequestWrapper {

	HttpServletRequest req;
	
	public MyRequestWrapper(HttpServletRequest request)
	{
		super(request);
		this.req = request;
	}
	
	
	@Override
	public String getParameter(String name) {
	    String value = req.getParameter(name);
	    return (value != null) ? value : "NONE";
	}
	}
	
