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
import com.ideas2it.feastr.model.Hotel;

/**
 * HotelDAO access the database tables hotel and address and adds,updates 
 * and retrives data from the tables
 */
@Repository
public class HotelDAO {
    private SessionFactory factory = HibernateUtil.buildSessionFactory();
    private Session session;
    
    /**
     * Inserts the hotel data entered by the admin to the hotel table 
     * and address of hotel in address table with hotel Id 
     * @param Hotel object contains the data to be inserted into table
     * @return String id on successful addition of hotel to the database
     */
    public String insertHotel(Hotel hotel) throws CustomException {
        String hotelId = null;
        Transaction transact = null;
        try {
            session = factory.openSession();
            transact = session.beginTransaction();
            hotelId = (String) session.save(hotel);
            transact.commit();
        } catch (HibernateException exception) {
            if (transact!=null) {
                transact.rollback();
            }
            throw new CustomException("Unable to add Hotel " + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return hotelId;
    }

    /**
     * Retrives the list of hotels and their addresses from the hotel table
     * and address table in database
     * @return List of all the Hotels from table to the service class
     */
    public List<Hotel> getAllHotels() throws CustomException {
        List hotels =null;
        try {
            session = factory.openSession();
            hotels = session.createQuery("FROM Hotel").list(); 
        } catch (HibernateException exception) {
            throw new CustomException("Unable to get Hotel" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return hotels;
    }
    
    /**
     * Retrives the list of availalbe hotels and their addresses from the 
     * hotel table and address table in database
     * @return List of available Hotels from table to the service class
     */
    public List<Hotel> getAvailableHotels() throws CustomException {
        List hotels = null;
        try {
            session = factory.openSession();
            Query query = session.createQuery("FROM Hotel where status = :status");
            query.setParameter("status",true);
            hotels = query.list();
        } catch (HibernateException exception) {
            throw new CustomException("Unable to get Hotel" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return hotels;
    }
    
    /**
     * Gets the hotel with the corresponding hotel id from the table and returns
     * to service
     * @param id of the hotel which is to be retrived
     * @return Hotel object with the corresponding id
     */
    public Hotel getHotelById(String id) throws CustomException {
        Hotel hotel = null;
        try {
            session = factory.openSession();
            hotel = session.get(Hotel.class , id);
        } catch (HibernateException exception) {
            throw new CustomException("Unable to get Hotel" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return hotel;
    } 
       
    /**
     * Replaces the entry with matching hotel Id with the new data contained 
     * in the hotel object
     * @param POJO object Hotel to be updated in database table
     */   
    public void updateHotel(Hotel hotel) throws CustomException{
        Transaction transact = null;
        try {
            session = factory.openSession();
            transact = session.beginTransaction();
            session.update(hotel); 
            transact.commit();
        } catch (HibernateException exception) {
            if (transact!=null) {
                transact.rollback();
            }
            throw new CustomException("Unable to update Hotel" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    /**
     * Gets the size of the hotels in Hotel Table and returns it
     * @return long size of the number of hotels
     */
    public long getCountOfHotels() throws CustomException{
        Long count = 0L;
        Transaction transact = null;
        try {
            session = factory.openSession();
            transact = session.beginTransaction();
            Query query = session.createQuery("SELECT COUNT(hotelId) from Hotel");
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
     * Deletes the hotel by setting the status to false
     * @param Hotel object which is to be deleted
     */
    public void deleteHotel(Hotel hotel) throws CustomException{
        Transaction transact = null;
        try {
            session = factory.openSession();
            transact = session.beginTransaction();
            session.update(hotel);
            transact.commit();
        } catch (HibernateException exception) {
            if (transact!=null) {
                transact.rollback();
            }
            throw new CustomException("Unable to Delete Hotel" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}   
