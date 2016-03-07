package org.test.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(description = "A simple servlet", urlPatterns =
{ "/SimpleServletPath" })
public class SimpleServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("Hello from GET method.");
		PrintWriter writer = response.getWriter();
		writer.println("<h3>Hi in HTML GET</h3>");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		response.getWriter().println(username);
		response.getWriter().println(password);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("Hello from POST method.");
		PrintWriter writer = resp.getWriter();
		writer.println("<h3>Hi in HTML POST</h3>");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// resp.getWriter().println(username);
		// resp.getWriter().println(password);

		if (username == username && password == password)
		{
			req.setAttribute("username", username);
			req.setAttribute("password", password);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/loggedin.jsp");
			rd.forward(req, resp);
		} else
		{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/html/badpass.html");
			rd.forward(req, resp);
		}
		/*
		 * req.setAttribute("username", username); req.setAttribute("password",
		 * password); RequestDispatcher rd =
		 * getServletContext().getRequestDispatcher("/jsp/loggedin.jsp");
		 * rd.forward(req, resp);
		 */
	}

}
