package com.ideas2it.feastr.service;

import java.util.List;

import com.ideas2it.feastr.exception.CustomException;
import com.ideas2it.feastr.model.Customer;
import com.ideas2it.feastr.model.Dish;
import com.ideas2it.feastr.model.Executive;
import com.ideas2it.feastr.model.Hotel;
import com.ideas2it.feastr.model.Order;

public interface IOrderService {
    
    /**
     * Gets the customer object from the customer Id and checks the entered 
     * phone number is equal to the customer phone number
     *
     * @param String Customer Id which fetches the customer Object
     * @param String phone number is checked with the phone number of the 
     *        customer whose id is entered
     * @return Boolean true if the customer id contains 
     *         corresponding phone number
     */
    Boolean checkCustomer(String customerId,String phoneNumber) throws CustomException;
    
    /**
     * Calls the retrieveAvailableHotels method in hotel service and gets the 
     * list of available hotels 
     * @return the list of Available hotels in the Application 
     */
    List<Hotel> retrieveAvailableHotels() throws CustomException ;
    
    /**
     * Calls the retrieveMenuByHotelId method in menu service and gets the 
     * list of available menu 
     * @param the hotel id whose menu is to be retrived
     * @return Menu List of the hotel
     */
    List<Dish> retrieveMenuByHotelId(String hotelId) throws CustomException ;
    
    /**
     * Calls the retrieveDishById method in menu service 
     *  
     * @param Dish Id whose object is fetched
     * @return Dish Object whose Id is passed
     */
    Dish retrieveDishById (String id) throws CustomException ;
    
    /**
     * Calculates the total value of order and returns the total value
     *
     * @param Order object containing the order details
     * @param Dish object contaning the item details
     * @param int quantity of the item to be ordered
     */
    void calculateTotal(Order order, Dish dish, int quantity) ;
    
    /**
     * Adds the order details to the order table through DAO
     *
     * @param Order object containing order details
     * @return Int value =1 if order added succesfully
     */
    int createOrder(Order order) throws CustomException ;
   
    /**
     * Checks the status of the Delivery exectives and assigns active executive
     * to the order and deactivates the executive
     *
     * @param : order object to which the executive is assigned
     */
    Executive setExecutiveForOrder(Order order) throws CustomException;
}
