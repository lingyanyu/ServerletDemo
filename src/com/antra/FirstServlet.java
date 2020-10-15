package com.antra;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
	
	public void service(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("in first Servlet");
	}

}
