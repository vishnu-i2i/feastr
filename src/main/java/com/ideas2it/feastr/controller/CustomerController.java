package com.ideas2it.feastr.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.math.BigDecimal;
import java.util.InputMismatchException;
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
import com.ideas2it.feastr.model.Address;
import com.ideas2it.feastr.model.Customer;
import com.ideas2it.feastr.service.ICustomerService;
import com.ideas2it.feastr.service.impl.CustomerServiceImpl;

/**
 * CustomerController adds a customer to the customers, displays the list of 
 * customers to the user, updates a particular customer in the 
 * customers list, soft deletes a customer from the list in the application.
 */
@Controller
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;
    
    /**
     * Gets the customer details from the user in jsp page and sets it the 
     * customer object which is added to the customers list
     * @param request contains the customer details to be added to the object
     */
    @RequestMapping("/registerCustomer")
    public ModelAndView registerCustomer(HttpServletRequest request, 
            HttpServletResponse response, Customer customer)
            throws IOException, ServletException {
        try {
            customer.setCustomerId(customerService.generateId());
            customer.setFirstName(request.getParameter("firstName"));
            customer.setLastName(request.getParameter("lastName"));
            customer.setPhoneNumber(request.getParameter("phoneNumber"));
            customer.setMailId(request.getParameter("mailId"));
            customer.setDob(request.getParameter("dob"));
            customer.setCreatedDate(customerService.generateDate());
            customer.setUpdatedDate(customerService.generateDate());
            customer.setStatus(true);
            customer.setRole("customer");
            Address address = new Address();
            address.setStreetName(request.getParameter("street"));
            address.setCity(request.getParameter("city"));
            address.setPincode(request.getParameter("pincode"));
            customerService.addAddress(customer,address);
            Address address1 = new Address();
            address1.setStreetName(request.getParameter("street1"));
            address1.setCity(request.getParameter("city1"));
            address1.setPincode(request.getParameter("pincode1"));
            customerService.addAddress(customer,address1);
            customerService.createCustomer(customer);
            return displayAllCustomers(request,response);
        } catch (CustomException exception) {
            return (new ModelAndView("ErrorPage","error",exception));
        }
    }

    /**
     * Gets the list of customers from server and forwards the request, response
     * @param request contains the list of customers data in 
     */
    @RequestMapping("/displayAllCustomers")
    public ModelAndView displayAllCustomers(HttpServletRequest request, 
            HttpServletResponse response) throws IOException, ServletException {
        ModelAndView model = new ModelAndView("DisplayCustomers");
        try {
            List<Customer> customers = customerService.retrieveAllCustomers();
            model.addObject("customers", customers);
        } catch (CustomException exception) {
            model = new ModelAndView("ErrorPage","error",exception);
        }
        return model;
    }
    
    /**
     * Gets the particular customer with corresponding customer id 
     * and forwards the obtained customer object 
     */
    @RequestMapping("/fetchCustomer")
    public ModelAndView fetchCustomer(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        ModelAndView model = new ModelAndView("UpdateCustomer");
        try {
            Customer customer = 
                customerService.retrieveCustomerById(request.getParameter("id"));
            HttpSession session = request.getSession();
            session.setAttribute("customer", customer);  
        } catch (CustomException exception) {
            model = new ModelAndView("ErrorPage","error",exception);
        }
        return model;
    }

    /**
     * Updates the customer details in the customers list to the particular
     * Customer object
     */
    @RequestMapping("/updateCustomer")
    public ModelAndView updateCustomer(HttpServletRequest request, 
            HttpServletResponse response)
            throws IOException, ServletException {
        try {
            HttpSession session = request.getSession(false);
            Customer customer = (Customer) session.getAttribute("customer");
            customer.setFirstName(request.getParameter("firstName"));
            customer.setLastName(request.getParameter("lastName"));
            customer.setPhoneNumber(request.getParameter("phoneNumber"));
            customer.setMailId(request.getParameter("mailId"));
            customer.setDob(request.getParameter("dob"));
            customer.setCreatedDate(customerService.generateDate());
            customer.setUpdatedDate(customerService.generateDate());
            customer.setStatus(true);
            Address address = customer.getAddresses().get(0);
            address.setStreetName(request.getParameter("street"));
            address.setCity(request.getParameter("city"));
            address.setPincode(request.getParameter("pincode"));
            Address address1 = customer.getAddresses().get(1);
            address1.setStreetName(request.getParameter("street1"));
            address1.setCity(request.getParameter("city1"));
            address1.setPincode(request.getParameter("pincode1"));
            customerService.updateCustomer(customer);
            return displayAllCustomers(request,response);
        } catch(CustomException exception) {
            return (new ModelAndView("ErrorPage","error",exception));
        }
    }

    /**
     * Soft deletes the Customer from the list of customers 
     * by geting the object from the entered customer id
     */
    @RequestMapping("/deleteCustomer")
    public ModelAndView deleteCustomer(HttpServletRequest request, 
            HttpServletResponse response) throws IOException, ServletException {
        try {
            Customer customer = 
                customerService.retrieveCustomerById(request.getParameter("id"));
            customer.setUpdatedDate(customerService.generateDate());
            customer.setStatus(false);
            customerService.deleteCustomer(customer);
            return displayAllCustomers(request,response);
        } catch(CustomException exception) {
            return (new ModelAndView("ErrorPage","error",exception));
        }
    }
}
