package com.ideas2it.feastr.service;

import java.sql.Date;
import java.util.List;

import com.ideas2it.feastr.exception.CustomException;
import com.ideas2it.feastr.model.Address;
import com.ideas2it.feastr.model.Hotel;

/**
 * HotelServiceImpl inteface contains the Unique id generation and business logic  
 * methods for the Hotels of feastr application 
 */
public interface IHotelService {

    /**
     * Generates unique hotel id by getting the size of the list from 
     * database and increments size by one and appends it to 'C'
     * @return generated unique hotel Id
     */
    String generateId() throws CustomException;
    
     /**
     * Generates the local date and converts it to sql date and returns it
     * @return current Date in sql date format
     */
    Date generateDate();
    
    /**
     * Gets the Hotel object with the corresponding id from dao class
     * @param  Id of the object to be retrieved
     * @return Hotel Object containing the hotel idd
     */
    Hotel retrieveHotelById(String id) throws CustomException;
    
    /**
     * Gets the list of hotels from DAO and returns to the controller
     * @return: List of Hotel objects
     */
    List<Hotel> retrieveAllHotels() throws CustomException;
    
    /**
     * gets the list of hotels whose status is true from DAO
     *
     * @return list of available hotels to the servlet
     */
    List<Hotel> retrieveAvailableHotels() throws CustomException;
    
    /**
     * Calls the insertHotel method in the DAO class
     * @param: the hotel to be added in the list
     * @return boolean true after successful addition
     */
    boolean createHotel(Hotel hotel) throws CustomException;
    
    /**
     * Calls the updateHotel method in DAO class
     * @param Hotel pojo Object with the new hotel details 
     */
    void updateHotel(Hotel hotel) throws CustomException;

    /**
     * Calls the deleteHotel method in the DAO class
     * @param: Hotel Object which is to be deleted
     */
    void deleteHotel(Hotel hotel) throws CustomException;

    /**
     * Assigns the addresses list to the Hotel object
     * @param address of the Address type and the Hotel to which the address 
     *        is to be added
     */
    void addAddress(Hotel hotel, Address address);
}
