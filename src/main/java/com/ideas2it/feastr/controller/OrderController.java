package com.ideas2it.feastr.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ideas2it.feastr.exception.CustomException;
import com.ideas2it.feastr.model.Customer;
import com.ideas2it.feastr.model.Executive;
import com.ideas2it.feastr.model.Hotel;
import com.ideas2it.feastr.model.Dish;
import com.ideas2it.feastr.model.Order;
import com.ideas2it.feastr.service.IOrderService;
import com.ideas2it.feastr.service.impl.OrderServiceImpl;

/**
 * This class checks the a valid customer login into the application and display 
 * the list of hotels and then the menu for the selected hotel adds the dishes 
 * to cart and assigns executive for the placed order.
 */
@Controller
public class OrderController { 
    @Autowired
    private OrderServiceImpl orderService;   
    
    /**
     * Checks the customer id and phone number is valid and displays the 
     * list of available hotels if the user is a customer else 
     * displays mainmenu page if admin credentails are valid
     * @param request contains the customerId and phone number to be verified  
     */
    @RequestMapping("/validateLogin")
    public ModelAndView validateLogin(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        ModelAndView model = new ModelAndView();
        try {
            HttpSession session = request.getSession();
            String id = request.getParameter("username");
            String password = request.getParameter("password");
            Boolean isAdmin = orderService.checkCustomer(id,password);
            if (isAdmin) {
                session.setAttribute("customerId",id);
                model.setViewName("MainMenu");
            } else { 
                session.setAttribute("customerId",id);
                model = getAvailableHotels(request,response);
            }       
        } catch (CustomException exception) {
            model = new ModelAndView("ErrorPage","error",exception);
        } catch (NullPointerException exception) {
            model = new ModelAndView("login","message","Enter valid username and password");
        }
        return model;
    }   
    
    /**
     * Gets the list of Available hotels from server and 
     * forwards the request, response
     * @param the list of hotel is set in request parameter and retrived in jsp
     */
    public ModelAndView getAvailableHotels(HttpServletRequest request, 
            HttpServletResponse response) throws IOException, ServletException,
            CustomException {
        ModelAndView model = new ModelAndView("Order");
        List<Hotel> hotels = orderService.retrieveAvailableHotels();
        HttpSession session = request.getSession(false);
        session.setAttribute("hotels", hotels); 
        return model;
    }
    
    /**
     * Gets the menu from database with the corresponding hotel id and selected
     * category and forwards the request,response
     * @param request contains the hotel id whose menu is to be retrived
     */
    @RequestMapping("/displayAvailableMenu")
    public ModelAndView displayAvailableMenu(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        try {
            ModelAndView model = new ModelAndView("Order");
            List<Dish> dishes = 
                orderService.retrieveMenuByHotelId(request.getParameter("hotelId"));
            HttpSession session = request.getSession(false);
            session.setAttribute("menu", dishes);
            session.setAttribute("category",request.getParameter("category"));
            return model;
        } catch (CustomException exception) {
            return (new ModelAndView("ErrorPage","error",exception));
        }
    }
 
    /**
     * The details of the dish to be ordered is updated and the total 
     * value of the order is calculated and Delivery executive is assigned 
     * to deliver order to the customer
     * @param request contains the dish details, customer id and quantity of 
     *        ordered dish 
     */
    @RequestMapping("/placeOrder")  
    public ModelAndView placeOrder(HttpServletRequest request,
            HttpServletResponse response) throws IOException,ServletException {   
        ModelAndView model = new ModelAndView("Order");
        try {
            HttpSession session = request.getSession(false);
            Order order = new Order();
            String[] dishDetails = request.getParameter("dishDetails").split(",");
            Dish dish = orderService.retrieveDishById(dishDetails[1]);
            order.setCustomerId((String) session.getAttribute("customerId"));
            order.setHotelId(dish.getHotelId());
            orderService.calculateTotal(order, dish, Integer.parseInt
                                    (request.getParameter("quantity")));
            Executive executive = orderService.setExecutiveForOrder(order);
            if (null == executive) {
                model = new ModelAndView("ErrorPage", "error", "Delivery " +
                "executive not available. Please try after sometime. Sorry " +
                "for the inconvenience caused");           
            } else {
                int orderId = orderService.createOrder(order);    
                PrintWriter out = response.getWriter();
                out.println("Successfully placed order.Your order id is " 
                + orderId + " will be delivered by " + executive + ". Please pay "
                + order.getTotal() + " rupees.");
                out.close();
            }
        } catch (CustomException exception) {
            model = new ModelAndView("ErrorPage","error",exception);
        }
        return model;
    }  
}
