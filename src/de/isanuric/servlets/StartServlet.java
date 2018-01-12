package de.isanuric.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import java.util.List;
import java.util.Set;
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

		// request.getParameterNames()
		Enumeration params = request.getParameterNames();
		while (params.hasMoreElements()) {
			Object object = params.nextElement();
			String fieldName = (String) object;
			String fieldValue = request.getParameter(fieldName);
			System.out.println(fieldName + ":: " + fieldValue);
		}



		if (!StringUtils.isBlank(plainText)) {

			MessageDigestGen msgDgst = new MessageDigestGen();
			cipherText = msgDgst.createMessageDigest(plainText);
		    request.setAttribute("plainText", plainText);
		    request.setAttribute("result", cipherText);
			getServletContext().getRequestDispatcher("/messageDigest.jsp").forward(request, response);
		}

		// refresh text fields
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
