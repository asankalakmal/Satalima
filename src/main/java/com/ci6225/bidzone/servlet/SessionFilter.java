package com.ci6225.bidzone.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter("/*")
public class SessionFilter implements Filter {

    public SessionFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        String loginURI = req.getContextPath() + "/Login";
        String loginURI1 = req.getContextPath() + "/register";
        
        
        String signUpURI3 = req.getContextPath() + "/Signup";

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = req.getRequestURI().equals(loginURI) || req.getRequestURI().equals(loginURI1);
        boolean signupRequest = req.getRequestURI().equals(signUpURI3);
        boolean filter = req.getRequestURI().equals(req.getContextPath()) || 
        		req.getRequestURI().equals(req.getContextPath()+"/");
        boolean resourceFile = req.getRequestURI().toLowerCase().endsWith("js") || req.getRequestURI().toLowerCase().endsWith("css")
                    || req.getRequestURI().toLowerCase().endsWith("png") || req.getRequestURI().toLowerCase().endsWith("jpg")
                    || req.getRequestURI().toLowerCase().endsWith("jpeg");

        if (loggedIn || loginRequest || signupRequest || filter || resourceFile) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect(req.getContextPath() + "/register");
            return;
        }
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
