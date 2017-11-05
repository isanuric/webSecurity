package de.isanuric.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

		private ServletContext context;
		
		public void init(FilterConfig fConfig) throws ServletException {
			this.context = fConfig.getServletContext();
			this.context.log("AuthenticationFilter initialized");
		}
		
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
			HttpServletRequest  req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			// if there is no current session dont't returns a new session.
			HttpSession session = req.getSession(false);
			
			String plainText  = request.getParameter("plainText");
			String cipherText = request.getParameter("result");
			
			System.out.println("filter9: " + plainText);
			System.out.println("filter9: " + cipherText);
			
			
			
//			System.out.println("filter: " + session.getId());
			
//			if (plainText == null) {
//				 Enumeration<String> e = session.getAttributeNames();
//				 while (e.hasMoreElements()) {
//				      String name = (String) e.nextElement();
////				      System.out.println(name + ": " + session.getAttribute(name)  );
//				      session.removeAttribute(name);
//				 }
//			}
			
			 String uri = req.getRequestURI();
			this.context.log("Requested URI: " + uri);
			
			if (session == null && !(uri.endsWith("login.jsp") || uri.endsWith("LoginServlet"))) {
				this.context.log("Unauthorized access request");
				res.sendRedirect("login.jsp");
			}else{
				this.context.log("Authorized access request");
				// pass the request along the filter chain
				chain.doFilter(request, response);
			}
		}

		public void destroy() {
			//close any resources here
		}

}
