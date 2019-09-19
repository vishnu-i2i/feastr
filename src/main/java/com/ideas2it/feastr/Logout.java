package com.ideas2it.feastr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Logout {  
    
    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {  
        ModelAndView model = new ModelAndView("login");
        HttpSession session=request.getSession();
        session.invalidate();
        model.addObject("message","You are successfully logged out!");
        return model;
    }  
}  
