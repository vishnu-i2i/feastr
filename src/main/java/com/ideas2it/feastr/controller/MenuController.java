package com.ideas2it.feastr.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

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
import com.ideas2it.feastr.model.Hotel;
import com.ideas2it.feastr.model.Dish;
import com.ideas2it.feastr.service.IMenuService;
import com.ideas2it.feastr.service.impl.MenuServiceImpl;
import com.ideas2it.feastr.util.CommonUtil;

/**
 * MenuController adds a dish to the menu, displays all the dishes and serving
 * dishes to the user, updates a particular dish in the menu, soft deletes a
 * dish from the menu and places order to the Feastr application to deliver to
 * the customer.
 */
@Controller
public class MenuController {
    @Autowired
    private MenuServiceImpl menuService;
    
    /**
     * Gets the dish details from the user in jsp page and sets it the 
     * Dish object which is added to the menu
     */
    @RequestMapping("/registerDish")
    public ModelAndView registerDish(HttpServletRequest request, 
            HttpServletResponse response, Dish item) 
            throws IOException, ServletException {
        try {
            item.setDishId(menuService.generateId());
            item.setHotelId(request.getParameter("hotelId"));
            item.setName(request.getParameter("name"));
            BigDecimal price = new BigDecimal(request.getParameter("price"));
            item.setPrice(price);
            item.setCategory(request.getParameter("category"));
            item.setAvailability(true);
            item.setCreatedDate(menuService.generateDate());
            item.setUpdatedDate(menuService.generateDate());
            menuService.createDish(item);
            return displayHotelMenu(request,response);
        } catch(CustomException exception) {
            return (new ModelAndView("ErrorPage","error",exception));
        }
    }

    /**
     * Gets the menu from database with the corresponding hotel id
     * and forwards the request,response
     */
    @RequestMapping("/displayHotelMenu") 
    public ModelAndView displayHotelMenu(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        ModelAndView model = new ModelAndView("DisplayMenu");
        try {
            List<Dish> dishes = 
                menuService.retrieveMenuByHotelId(request.getParameter("hotelId"));
            model.addObject("menu",dishes);
        } catch (CustomException exception) {
            model = new ModelAndView("ErrorPage","error",exception);
        }
        return model;
    }
    
    /**
     * Gets the particular dish with corresponding Dish id 
     * and forwards the obtained Dish object
     */
    @RequestMapping("/fetchDish")
    public ModelAndView fetchDish(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        ModelAndView model = new ModelAndView("UpdateDish");
        try {
            Dish dish = 
                menuService.retrieveDishById(request.getParameter("id"));
            HttpSession session = request.getSession();
            session.setAttribute("dish", dish); 
        } catch (CustomException exception) {
            model = new ModelAndView("ErrorPage","error",exception);
        }
        return model;
    }

    /**
     * Updates the dish details in the menu to the particular
     * Dish object
     */
    @RequestMapping("/updateDish")
    public ModelAndView updateDish(HttpServletRequest request, 
            HttpServletResponse response) throws IOException, ServletException {
        try {
            HttpSession session = request.getSession(false);
            Dish item = (Dish) session.getAttribute("dish");
            item.setName(request.getParameter("name"));
            BigDecimal price = new BigDecimal(request.getParameter("price"));
            item.setPrice(price);
            item.setCategory(request.getParameter("category"));
            item.setAvailability(true);
            item.setUpdatedDate(menuService.generateDate());
            menuService.updateDish(item);
            return displayHotelMenu(request,response);
        } catch(CustomException exception) {
            return (new ModelAndView("ErrorPage","error",exception));
        }
    }

    /**
     * Soft deletes the dish from the Menu by geting 
     * the object from the entered dish id
     */
    @RequestMapping("/deleteDish")
    public ModelAndView deleteDish(HttpServletRequest request, 
            HttpServletResponse response) throws IOException, ServletException {
        try {
            Dish item = menuService.retrieveDishById(request.getParameter("id"));
            item.setUpdatedDate(menuService.generateDate());
            item.setAvailability(false);
            menuService.deleteDish(item);
            return displayHotelMenu(request,response);
        } catch(CustomException exception) {
            return (new ModelAndView("ErrorPage","error",exception));
        }
    }
}
