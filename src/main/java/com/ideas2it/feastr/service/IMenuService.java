package com.ideas2it.feastr.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.ideas2it.feastr.exception.CustomException;
import com.ideas2it.feastr.model.Hotel;
import com.ideas2it.feastr.model.Dish;

/**
 * MenuServiceImpl contains the business logic  
 * methods for the Menu of feastr application 
 */
public interface IMenuService {

    /**
     * Generates unique dish id by getting the size of the list from 
     * database and increments size by one and appends it to 'C'
     * @return generated unique dish Id
     */
    String generateId() throws CustomException;
    
    /**
     * Generates the local date and converts it to sql date and returns it
     * @return current Date in sql date format
     */
    Date generateDate();

    /**
     * Gets the Dish object with the corresponding id from dao class
     * @param  Id of the object to be retrieved
     * @return Dish Object containing the dish idd
     */
    Dish retrieveDishById(String id) throws CustomException;

    /**
     * Gets the menu of the particular hotel whose id is passed from the dao 
     * and sends it to the servlet
     * @param the hotel id who menu is to be retrived
     * @return Menu List of the hotel
     */
    List<Dish> retrieveMenuByHotelId(String hotelId) throws CustomException;

    /**
     * Calls the insertDish method in the DAO class
     * @param: the dish to be added in the list
     * @return boolean true after successful addition
     */
    boolean createDish(Dish item) throws CustomException;
     
    /**
     * Calls the updateDish method in DAO class
     * @param Dish pojo Object with the new dish details 
     */
    void updateDish(Dish item) throws CustomException;
     
    /**
     * Calls the deleteDish method in the DAO class
     * @param: Dish Object which is to be deleted
     */
    void deleteDish(Dish item) throws CustomException;
}
