package com.ideas2it.feastr.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ideas2it.feastr.exception.CustomException;
import com.ideas2it.feastr.model.Executive;
import com.ideas2it.feastr.service.IExecutiveService;
import com.ideas2it.feastr.service.impl.ExecutiveServiceImpl;

/**
 * ExecutiveController adds a executive to the executives, displays all 
 * executives and active executives to the user, updates a particular executive 
 * in the executives list, soft deletes a executive from the list in the Feastr 
 * application.
 */
@Controller
public class ExecutiveController {
    @Autowired
    private ExecutiveServiceImpl executiveService;
    
    @RequestMapping("/addExecutive")
    public ModelAndView addExecutive(HttpServletRequest request, 
            HttpServletResponse response) throws IOException, ServletException {
        ModelAndView model = new ModelAndView("AddExecutive");
        Executive executive = new Executive();
        model.addObject("executive",executive);
        return model;
    }
    
    /**
     * Gets the executive details from the user in jsp page and sets it the 
     * executive object which is added to the executives list
     */
    @RequestMapping("/registerExecutive")
    public ModelAndView registerExecutive(HttpServletRequest request, 
            HttpServletResponse response, @ModelAttribute Executive executive) 
            throws IOException, ServletException {
        try {
            executive.setExecutiveId(executiveService.generateId());
            executive.setCreatedDate(executiveService.generateDate());
            executive.setUpdatedDate(executiveService.generateDate());
            executive.setStatus(true);
            executiveService.createExecutive(executive);
            return displayAllExecutives(request,response);
        } catch(CustomException exception) {
            return (new ModelAndView("ErrorPage","error",exception));
        }
    }

    /**
     * Gets the list of executives from server and forwards the request, response
     */
    @RequestMapping("/displayAllExecutives")
    public ModelAndView displayAllExecutives(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        ModelAndView model = new ModelAndView("DisplayExecutives");
        try {
            List<Executive> executives = executiveService.retrieveAllExecutives();
            model.addObject("executives", executives);
        } catch (CustomException exception) {
            model = new ModelAndView("ErrorPage","error",exception);
        }
        return model;
    }
    
    /**
     * Gets the particular hotel with corresponding executive id 
     * and forwards the obtained executive object 
     */
    @RequestMapping("/fetchExecutive")
    public ModelAndView fetchExecutive (HttpServletRequest request, 
            HttpServletResponse response) 
            throws IOException, ServletException {
        ModelAndView model;
        try {
            Executive executive = 
                executiveService.retrieveExecutiveById(request.getParameter("id"));
            model = new ModelAndView("UpdateExecutive","executive", executive); 
        } catch (CustomException exception) {
            model = new ModelAndView("ErrorPage","error",exception);
        }
        return model;
    }
    
    /**
     * Updates the executive details in the executives list to the particular
     * Executive object
     */
    @RequestMapping("/updateExecutive")
    public ModelAndView updateExecutive (HttpServletRequest request, 
            HttpServletResponse response,@ModelAttribute Executive executive)
            throws IOException, ServletException {
        try {
            executive.setCreatedDate(executiveService.generateDate());
            executive.setUpdatedDate(executiveService.generateDate());
            executive.setStatus(true);
            executiveService.updateExecutive(executive);
            return displayAllExecutives(request,response);
        } catch(CustomException exception) {
            return (new ModelAndView("ErrorPage","error",exception));
        }
    }

    /**
     * Soft deletes the Executive from the list of executivess 
     * by geting the object from the entered executive id
     */
    @RequestMapping("/deleteExecutive")
    public ModelAndView deleteExecutive(HttpServletRequest request, 
            HttpServletResponse response) throws IOException, ServletException {
        try {
            Executive executive = executiveService.retrieveExecutiveById(request.getParameter("id"));
            executive.setUpdatedDate(executiveService.generateDate());
            executive.setStatus(false);
            executiveService.deleteExecutive(executive);
            return displayAllExecutives(request,response);
        } catch (CustomException exception) {
            return (new ModelAndView("ErrorPage","error",exception));
        }
    }
}
