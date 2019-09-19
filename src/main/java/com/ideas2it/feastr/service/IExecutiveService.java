package com.ideas2it.feastr.service;

import java.sql.Date;
import java.util.List;

import com.ideas2it.feastr.exception.CustomException;
import com.ideas2it.feastr.model.Executive;

/**
 * ExecutiveServiceImpl inteface contains the Unique id generation and business 
 * logic methods for the Executives of feastr application 
 */
public interface IExecutiveService {
    /**
     * Generates unique executive id by getting the size of the list from 
     * database and increments size by one and appends it to 'C'
     * @return generated unique executive Id
     */
    String generateId() throws CustomException;

    
     /**
     * Generates the local date and converts it to sql date and returns it
     * @return current Date in sql date format
     */
    Date generateDate();

    /**
     * Gets the list of executives from DAO and returns to the controller
     * @return: List of Executive objects
     */
    List<Executive> retrieveAllExecutives() throws CustomException;

    /**
     * Gets the Executive object with the corresponding id from dao class
     * @param  Id of the object to be retrieved
     * @return Executive Object containing the executive idd
     */
    Executive retrieveExecutiveById(String id) throws CustomException;

    /**
     * Calls the insertExecutive method in the DAO class
     * @param: the executive to be added in the list
     * @return boolean true after successful addition
     */
    boolean createExecutive(Executive executive) throws CustomException;
    
    /**
     * Calls the updateExecutive method in DAO class
     * @param Executive pojo Object with the new executive details 
     */
    void updateExecutive(Executive executive) throws CustomException;

    /**
     * Calls the deleteExecutive method in the DAO class
     * @param: Executive Object which is to be deleted
     */
    void deleteExecutive(Executive executive) throws CustomException;
}
