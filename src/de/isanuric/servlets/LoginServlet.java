package de.isanuric.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.isanuric.model.MysqlDB;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet(name = "loginServlet", urlPatterns = { "/loginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userFromReq = request.getParameter("user");
		String pwdFromReq  = request.getParameter("pwd");
		MysqlDB loginDb = new MysqlDB();
		
		if (loginDb.checkUserLoginInfo(userFromReq, pwdFromReq)) {
			
	    		HttpSession session = request.getSession();
	    		session.setAttribute("user", userFromReq);
	    		
	    		// Expire in 2 minute
	    		session.setMaxInactiveInterval(2*60);
	    		
	    		// create Cookie
	    		Cookie userCookie = new Cookie("user", userFromReq);
	    		userCookie.setMaxAge(2*60);
	    		response.addCookie(userCookie);
	    		response.sendRedirect("loginSuccess.jsp");
		}else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
		}
	}
	

}
