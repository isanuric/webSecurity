package de.isanuric.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.isanuric.model.MessageDigestGen;
import org.apache.commons.lang3.StringUtils;

import de.isanuric.model.MessageDigestGen;



/**
 * Servlet implementation class StartServlet
 */
//@WebServlet("/StartServlet")
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet");
		HttpSession session = request.getSession();
		String plainText = request.getParameter("plainText");
		String cipherText = request.getParameter("result");
		ServletContext context = session.getServletContext();
//		response.setIntHeader("Refresh", 5);
//		 Enumeration<String> e = session.getAttributeNames();
//		 while (e.hasMoreElements()) {
//		      String name = (String) e.nextElement();
//		      System.out.println(name + ": " + session.getAttribute(name)  );
//		      session.removeAttribute(name);
//		    }
		System.out.println("context: " + context.getAttribute(plainText));
		if (!StringUtils.isBlank(plainText)) {
			
//			session.removeAttribute("plainText");
//			session.removeAttribute("result");
			
			context.log(plainText);
			MessageDigestGen msgDgst = new MessageDigestGen();
			cipherText = msgDgst.createMessageDigest(plainText);
			context.log("cipher: " + cipherText);
			session.setAttribute("plainText", plainText);
			session.setAttribute("result", cipherText);
			
			context.log("fff: " + session.getAttribute("result"));
			response.sendRedirect("messageDigest.jsp");
		}
	}

}
