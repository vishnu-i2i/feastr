package com.ideas2it.feastr;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

/**
 * Main Controller contains the main method for the Feastr Hotel management 
 * application and calls the customer,hotel,executive and the menu controller
 *
 * @author Vishnu Kumar
 * @version 1.8 17/07/19 
 */
public class LoginFilter implements Filter {

    public void init(FilterConfig filterConfig){}

    /**
     * Checks the username and password entered by the user and dispatches the
     * main menu if valid credentials are entered
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);
 
        boolean isLoggedIn = (session != null && session.getAttribute("customerId") != null);
        
        String loginURI = httpRequest.getContextPath() + "/validateLogin";
     
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
 
        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login.jsp");
 
        if (isLoggedIn && (isLoginRequest || isLoginPage)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("MainMenu.jsp");
            dispatcher.forward(request, response);
 
        } else if (isLoggedIn || isLoginRequest) {
            filterChain.doFilter(request, response);
        
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.include(request, response);
        }
    }

    public void destroy(){}

}

