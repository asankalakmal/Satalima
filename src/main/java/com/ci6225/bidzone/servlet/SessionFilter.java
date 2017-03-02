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
//@WebFilter("*")
public class SessionFilter implements Filter {

    public SessionFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        String loginURI = req.getContextPath() + "/LoginServlet";
        String loginURI1 = req.getContextPath() + "/login.jsp";
        
        String signUpURI = req.getContextPath() + "/signup.jsp";
        String signUpURI2 = req.getContextPath() + "/signupSuccess.jsp";
        String signUpURI3 = req.getContextPath() + "/SignupServlet";

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = req.getRequestURI().equals(loginURI) || req.getRequestURI().equals(loginURI1);
        boolean signupRequest = req.getRequestURI().equals(signUpURI) || req.getRequestURI().equals(signUpURI2) || req.getRequestURI().equals(signUpURI3);
        boolean filter = req.getRequestURI().contains("Servlet") || req.getRequestURI().equals(req.getContextPath()) || 
        		req.getRequestURI().equals(req.getContextPath()+"/");

        if (loggedIn || loginRequest || !filter || signupRequest) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect("login.jsp");
            return;
        }
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
