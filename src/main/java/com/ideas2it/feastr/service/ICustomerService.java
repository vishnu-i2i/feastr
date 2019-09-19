package com.ideas2it.feastr.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.ideas2it.feastr.exception.CustomException;
import com.ideas2it.feastr.model.Address;
import com.ideas2it.feastr.model.Customer;
import com.ideas2it.feastr.model.Dish;
import com.ideas2it.feastr.model.Executive;
import com.ideas2it.feastr.model.Hotel;
import com.ideas2it.feastr.model.Order;

/**
 * CustomerServiceImpl inteface contains the Unique id generation and business 
 * logic methods for the Customer of feastr application 
 */
public interface ICustomerService {

    /**
     * Generates unique customer id by getting the size of the list from 
     * database and increments size by one and appends it to 'C'
     * @return generated unique customer Id
     */
    String generateId() throws CustomException;
    
     /**
     * Generates the local date, converts it to sql date and returns it
     * @return current Date in sql date format
     */
    Date generateDate();
    
    /**
     * Gets the Customer object with the corresponding id from dao class
     * @param  Id of the object to be retrieved
     * @return Customer Object containing the customer idd
     */
    Customer retrieveCustomerById(String id) throws CustomException;

    /**
     * Gets the list of customers from DAO and returns to the controller
     * @return: List of Customer objects
     */
    List<Customer> retrieveAllCustomers() throws CustomException;

    /**
     * Calls the insertCustomer method in the DAO class
     * @param: the customer to be added in the list
     * @return boolean true after successful addition
     */
    boolean createCustomer(Customer customer) throws CustomException;
    
    /**
     * Calls the updateCustomer method in DAO class
     * @param Customer pojo Object with the new customer details 
     */
    void updateCustomer(Customer customer) throws CustomException;

    /**
     * Calls the deleteCustomer method in the DAO class
     * @param: Customer Object which is to be deleted
     */
    void deleteCustomer(Customer customer) throws CustomException;

    /**
     * Assigns the addresses list to the Customer object
     * @param address of the Address type and the Customer to which the address 
     *        is to be added
     */
    void addAddress(Customer customer, Address address);
}
