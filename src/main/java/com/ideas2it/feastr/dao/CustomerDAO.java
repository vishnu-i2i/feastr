package com.ideas2it.feastr.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException; 
import org.hibernate.query.Query;
import org.hibernate.Session; 
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.stereotype.Repository;

import com.ideas2it.feastr.configuration.HibernateUtil;
import com.ideas2it.feastr.exception.CustomException;
import com.ideas2it.feastr.model.Address;
import com.ideas2it.feastr.model.Customer;

/**
 * CustomerDAO access the database tables customer and address and adds,updates 
 * and retrives data from the tables
 */
@Repository
public class CustomerDAO {
    private SessionFactory factory = HibernateUtil.buildSessionFactory();
    private Session session;
        
    /**
     * Inserts the customer data entered by the admin to the customer table 
     * and address of customer in address table with customer Id 
     * @param Customer object contains the data to be inserted into table
     * @return String id on successful addition of customer to the database
     */
    public String insertCustomer(Customer customer) throws CustomException {
        String customerId = null;
        Transaction transact = null;
        try {
            session = factory.openSession();
            transact = session.beginTransaction();
            customerId = (String) session.save(customer);
            transact.commit();
        } catch (HibernateException exception) {
            if (transact!=null) {
                transact.rollback();
            }
            throw new CustomException("Unable to add Customer " + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            } 
        }
        return customerId;
    }
    
    /**
     * Retrives the list of customers and their addresses from the customer table
     * and address table in database
     * @return List of all the Customers from table to the service class
     */
    public List<Customer> getAllCustomers() throws CustomException {
        try {
            session = factory.openSession();
            List customers = session.createQuery("FROM Customer").list(); 
            return customers;
        } catch (HibernateException exception) {
            throw new CustomException("Unable to get Customer" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    /**
     * Gets the customer with the corresponding customer id from the table and 
     * returns to service 
     * @param id of the customer which is to be retrived
     * @return Customer object with the corresponding id
     */
    public Customer getCustomerById(String id) throws CustomException {
        Customer customer = null;
        try {
            session = factory.openSession();
            customer = session.get(Customer.class , id);
        } catch (HibernateException exception) {
            throw new CustomException("Unable to get Customer" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return customer;
    } 

    /**
     * Replaces the entry with matching customer Id with the new data contained 
     * in the customer object
     * @param POJO object Customer to be updated in database table
     */    
    public void updateCustomer(Customer customer) throws CustomException{
        Transaction transact = null;
        try {
            session = factory.openSession();
            transact = session.beginTransaction();
            session.update(customer); 
            transact.commit();
        } catch (HibernateException exception) {
            if (transact!=null) {
                transact.rollback();
            }
            throw new CustomException("Unable to update Customer" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            } 
        }
    }
  
    /**
     * Gets the size of the customers in Customer Table and returns it
     * @return long size of the number of customers
     */
    public long getCountOfCustomers() throws CustomException{
        Transaction transact = null;
        Long count = 0L;
        try {
            session = factory.openSession();
            transact = session.beginTransaction();
            Query query = session.createQuery("SELECT COUNT(customer.customerId)"
            + " from Customer customer");
            count = (Long) query.getSingleResult();
        } catch (HibernateException exception) {
            if (transact!=null) {
                transact.rollback();
            }
            throw new CustomException("Unable to get count" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return count;
    }
    
    /**
     * Deletes the customer by setting the status to false
     * @param Customer object which is to be deleted
     */
    public void deleteCustomer(Customer customer) throws CustomException{
        Transaction transact = null;
        try {
            session = factory.openSession();
            transact = session.beginTransaction();
            session.update(customer);
            transact.commit();
        } catch (HibernateException exception) {
            if (transact!=null) {
                transact.rollback();
            }
            throw new CustomException("Unable to Delete Customer" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}   
