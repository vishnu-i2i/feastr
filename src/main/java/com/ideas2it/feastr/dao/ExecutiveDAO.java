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
import com.ideas2it.feastr.model.Executive;

/**
 * ExecutiveDAO access the database tables executive and adds,updates 
 * and retrives data from the table
 */
@Repository
public class ExecutiveDAO {
    private SessionFactory factory = HibernateUtil.buildSessionFactory();
    private Session session;
    
    /**
     * Inserts the executive data entered by the admin to the executive table  
     * @param Executive object contains the data to be inserted into table
     * @return String id on successful addition of executive to the database
     */
    public String insertExecutive(Executive executive) throws CustomException {
        String executiveId = null;
        Transaction transact = null;
        try {
            session = factory.openSession();
            transact = session.beginTransaction();
            executiveId = (String) session.save(executive);
            transact.commit();
        } catch (HibernateException exception) {
            if (transact!=null) {
                transact.rollback();
            }
            throw new CustomException("Unable to add Executive " + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return executiveId;
    }

    /**
     * Retrives the list of executives from the executive table
     * @return List of all the Executives from table to the service class
     */
    public List<Executive> getAllExecutives() throws CustomException {
        List executives =null;
        try {
            session = factory.openSession();
            executives = session.createQuery("FROM Executive").list(); 
        } catch (HibernateException exception) {
            throw new CustomException("Unable to get Executive" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return executives;
    }
    
    /**
     * Gets the executive with the corresponding executive id from the table and returns
     * to service
     * @param id of the executive which is to be retrived
     * @return Executive object with the corresponding id
     */
    public Executive getExecutiveById(String id) throws CustomException {
        Executive executive = null;
        try {
            session = factory.openSession();
            executive = session.get(Executive.class , id);
        } catch (HibernateException exception) {
            throw new CustomException("Unable to get Executive" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return executive;
    } 
       
    /**
     * Replaces the entry with matching executive Id with the new data contained 
     * in the executive object
     * @param Executive object to be updated in database table
     */  
    public void updateExecutive(Executive executive) throws CustomException{
        Transaction transact = null;
        try {
            session = factory.openSession();
            transact = session.beginTransaction();
            session.update(executive); 
            transact.commit();
        } catch (HibernateException exception) {
            if (transact!=null) {
                transact.rollback();
            }
            throw new CustomException("Unable to update Executive" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    /**
     * Gets the size of the executives in Executive Table and returns it
     * @return long size of the number of executives
     */
    public long getCountOfExecutives() throws CustomException{
        Long count = 0L;
        Transaction transact = null;
        try {
            session = factory.openSession();
            transact = session.beginTransaction();
            Query query = session.createQuery("SELECT COUNT(executiveId) from "
            + "Executive executive");
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
     * Deletes the executive by setting the status to false
     * @param Executive object which is to be deleted
     */
    public void deleteExecutive(Executive executive) throws CustomException{
        Transaction transact = null;
        try {
            session = factory.openSession();
            transact = session.beginTransaction();
            session.update(executive);
            transact.commit();
        } catch (HibernateException exception) {
            if (transact!=null) {
                transact.rollback();
            }
            throw new CustomException("Unable to Delete Executive" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
