package de.isanuric.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.isanuric.model.MessageDigestGen;
import org.apache.commons.lang3.StringUtils;


/**
 * Servlet implementation class StartServlet
 */
//@WebServlet("/StartServlet")
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet");

		String plainText = request.getParameter("plainText");
		String cipherText = request.getParameter("result");

		if (!StringUtils.isBlank(plainText)) {
		
			MessageDigestGen msgDgst = new MessageDigestGen();
			cipherText = msgDgst.createMessageDigest(plainText);
		    request.setAttribute("plainText", plainText);
		    request.setAttribute("result", cipherText);
			getServletContext().getRequestDispatcher("/messageDigest.jsp").forward(request, response);
		}
		
		System.out.println("--->" + request.getParameter("refresh"));
		if (request.getParameter("refresh") != null) {
			request.removeAttribute("plainText");
			request.removeAttribute("result");
			getServletContext().getRequestDispatcher("/messageDigest.jsp").forward(request, response);
		}
			
    		// create Cookie
//    		Cookie userCookie = new Cookie("user", cipherText);
//    		userCookie.setMaxAge(2*60);
//    		response.addCookie(userCookie);
//			response.sendRedirect("messageDigest.jsp");

	}

}
