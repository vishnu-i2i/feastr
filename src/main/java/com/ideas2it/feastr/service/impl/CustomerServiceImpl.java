package com.ideas2it.feastr.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.feastr.exception.CustomException;
import com.ideas2it.feastr.dao.CustomerDAO;
import com.ideas2it.feastr.model.Address;
import com.ideas2it.feastr.model.Customer;
import com.ideas2it.feastr.model.Dish;
import com.ideas2it.feastr.model.Executive;
import com.ideas2it.feastr.model.Hotel;
import com.ideas2it.feastr.model.Order;
import com.ideas2it.feastr.service.ICustomerService;
import com.ideas2it.feastr.service.IExecutiveService;
import com.ideas2it.feastr.service.IHotelService;
import com.ideas2it.feastr.service.IMenuService;

/**
 * CustomerServiceImpl is implemented from the ICustomerService interface
 * and the implementation comments are in the interface
 */
@Service
public class CustomerServiceImpl implements ICustomerService{
    @Autowired
    private CustomerDAO customerDao;

    public String generateId() throws CustomException{
        long size = customerDao.getCountOfCustomers();
        return ("C" + ++size);
    }
    
    public Date generateDate() { 
        LocalDate now = LocalDate.now();
        return Date.valueOf(now);
    }
    
    public Customer retrieveCustomerById(String id) throws CustomException{
        Customer customer = customerDao.getCustomerById(id);
        if (null == customer) {
            throw new CustomException("Invalid Customer Id" + id);
        } else {
            return customer;
        }
    }
 
    public List<Customer> retrieveAllCustomers() throws CustomException{
        return customerDao.getAllCustomers();
    }

    public boolean createCustomer(Customer customer) throws CustomException {
        return (customerDao.insertCustomer(customer).equals(customer.getCustomerId()));
    }
    
    public void updateCustomer(Customer customer) throws CustomException {
       customerDao.updateCustomer(customer);
   }

    public void deleteCustomer(Customer customer) throws CustomException{
        customerDao.deleteCustomer(customer);
    }

    public void addAddress(Customer customer, Address address) {
        List<Address> addresses = customer.getAddresses();
        addresses.add(address);
        customer.setAddresses(addresses);
    }
}

