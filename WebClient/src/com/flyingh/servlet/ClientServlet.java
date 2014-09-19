package com.flyingh.servlet;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyingh.ejb.HelloEJBLocal;

public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			final InitialContext context = new InitialContext();
			final HelloEJBLocal helloEJB = (HelloEJBLocal) context.lookup("HelloEJB/local");
			response.getWriter().write(helloEJB.sayHello("Flyingh"));
		} catch (final NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
