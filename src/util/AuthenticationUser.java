package util;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AuthenticationUser", urlPatterns = { "/*" })
public class AuthenticationUser implements Filter{

	// private UserEntity sessionUser;
	private ServletContext context;
	
	public AuthenticationUser(){
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			String contextPath = req.getContextPath();
			String uri = req.getRequestURI();
			HttpSession session = req.getSession(false);

			System.out.println(session);
			
			if (uri.indexOf("/index.xhtml") > 0 || (session != null && session.getAttribute("username") != null)
					|| uri.indexOf("/register.xhtml") > 0|| uri.indexOf("/admin.xhtml") > 0 || uri.indexOf("/user.xhtml") > 0 
					|| uri.indexOf("/home.xhtml") > 0 || uri.indexOf("/adminCompany.xhtml") > 0 || uri.indexOf("/roles.xhtml") > 0
					|| uri.indexOf("/countries.xhtml") > 0 || uri.indexOf("/adminBrand.xhtml") > 0 || uri.indexOf("/adminDepartment.xhtml") > 0
					|| uri.indexOf("/adminSector.xhtml") > 0 || uri.indexOf("/adminShop.xhtml") > 0)
				
				chain.doFilter(request, response);
			else {
				res.sendRedirect(contextPath + "/index.xhtml");
			}
		} catch (Throwable t) {
			t.getMessage();
		}

	}


	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("Initializing");

	}



	@Override
	public void destroy() {

	}

}
