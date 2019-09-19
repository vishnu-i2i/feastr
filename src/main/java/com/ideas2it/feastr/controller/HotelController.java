package com.ideas2it.feastr.controller;

import java.io.IOException;
import java.sql.Date;
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
import com.ideas2it.feastr.model.Hotel;
import com.ideas2it.feastr.service.IHotelService;
import com.ideas2it.feastr.service.impl.HotelServiceImpl;
import com.ideas2it.feastr.util.CommonUtil;

/**
 * HotelController adds a hotel to the hotels, displays all hotels and active 
 * hotels to the user, updates a particular hotel in the hotels list, soft 
 * deletes a hotel from the list in the Feastr application.
 */
@Controller
public class HotelController {
    @Autowired
    private HotelServiceImpl hotelService;
    
    /**
     * Gets the hotel details from the user in jsp page and sets it the 
     * hotel object which is added to the hotels list
     */
    @RequestMapping("/registerHotel")
    public ModelAndView registerHotel(HttpServletRequest request, 
            HttpServletResponse response, Hotel hotel)
            throws IOException, ServletException {
        try {
            hotel.setHotelId(hotelService.generateId());
            hotel.setFirstName(request.getParameter("firstName"));
            hotel.setLastName(request.getParameter("lastName"));
            hotel.setPhoneNumber(request.getParameter("phoneNumber"));
            hotel.setMailId(request.getParameter("mailId"));
            hotel.setManagerName(request.getParameter("managerName"));
            hotel.setLocation(request.getParameter("location"));
            hotel.setCreatedDate(hotelService.generateDate());
            hotel.setUpdatedDate(hotelService.generateDate());
            hotel.setStatus(true);
            Address address = new Address();
            address.setStreetName(request.getParameter("street"));
            address.setCity(request.getParameter("city"));
            address.setPincode(request.getParameter("pincode"));
            hotelService.addAddress(hotel,address);
            hotelService.createHotel(hotel);
            return displayAllHotels(request,response);
        } catch (CustomException exception) {
            return (new ModelAndView("ErrorPage","error",exception));
        }
    }
   
    /**
     * Gets the list of hotels from server and forwards the request, response
     */
    @RequestMapping("/displayAllHotels")
    public ModelAndView displayAllHotels(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        ModelAndView model = new ModelAndView("DisplayHotels");
        try {
            List<Hotel> hotels = hotelService.retrieveAllHotels();
            model.addObject("hotels", hotels);
        } catch (CustomException exception) {
            model = new ModelAndView("ErrorPage","error",exception);
        }
        return model;
    }
    
    /**
     * Gets the particular hotel with corresponding Hotel id 
     * and forwards the  obtained Hotel object 
     */
    @RequestMapping("/fetchHotel")
    public ModelAndView fetchHotel(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        ModelAndView model = new ModelAndView("UpdateHotel");
        try {
            Hotel hotel = 
                hotelService.retrieveHotelById(request.getParameter("id"));
            HttpSession session = request.getSession();
            session.setAttribute("hotel", hotel);
        } catch (CustomException exception) {
            model = new ModelAndView("ErrorPage","error",exception);
        }
        return model;
    }

    /**
     * Updates the hotel details in the hotels list to the particular
     * Hotel object
     */
    @RequestMapping("/updateHotel")
    public ModelAndView updateHotel(HttpServletRequest request, 
            HttpServletResponse response) throws IOException, ServletException {
        try {
            HttpSession session = request.getSession(false);
            Hotel hotel = (Hotel) session.getAttribute("hotel");
            hotel.setFirstName(request.getParameter("firstName"));
            hotel.setLastName(request.getParameter("lastName"));
            hotel.setPhoneNumber(request.getParameter("phoneNumber"));
            hotel.setMailId(request.getParameter("mailId"));
            hotel.setManagerName(request.getParameter("managerName"));
            hotel.setLocation(request.getParameter("location"));
            hotel.setCreatedDate(hotelService.generateDate());
            hotel.setUpdatedDate(hotelService.generateDate());
            hotel.setStatus(true);
            Address address = hotel.getAddresses().get(0);
            address.setStreetName(request.getParameter("street"));
            address.setCity(request.getParameter("city"));
            address.setPincode(request.getParameter("pincode"));
            hotelService.updateHotel(hotel);
            return displayAllHotels(request,response);
        } catch(CustomException exception) {
            return (new ModelAndView("ErrorPage","error",exception));
        }
    }
    
    /**
     * Soft deletes the Hotel from the list of hotels 
     * by geting the object from the entered hotel id
     */
    @RequestMapping("/deleteHotel")
    public ModelAndView deleteHotel(HttpServletRequest request, 
            HttpServletResponse response) throws IOException, ServletException {
        try {
            Hotel hotel = 
                hotelService.retrieveHotelById(request.getParameter("id"));
            hotel.setUpdatedDate(hotelService.generateDate());
            hotel.setStatus(false);
            hotelService.deleteHotel(hotel);
            return displayAllHotels(request,response);
        } catch(CustomException exception) {
            return (new ModelAndView("ErrorPage","error",exception));
        }
    }
}
