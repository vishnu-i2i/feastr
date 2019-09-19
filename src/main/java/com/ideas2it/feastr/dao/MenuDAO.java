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
import com.ideas2it.feastr.model.Dish;

/**
 * MenuDAO access the database table menu and adds,updates 
 * and retrives data from the table
 */
@Repository
public class MenuDAO {
    private SessionFactory factory = HibernateUtil.buildSessionFactory();
    private Session session;
    
    /**
     * Inserts the dish details entered by the admin to the menu table with 
     * dish Id 
     * @param Dish object contains the data to be inserted into table
     * @return String id on successful addition of dish to the database
     */
    public String insertDish(Dish dish) throws CustomException {
        String dishId = null;
        Transaction transact = null;
        try {
            session = factory.openSession();
            transact = session.beginTransaction();
            dishId = (String) session.save(dish);
            transact.commit();
        } catch (HibernateException exception) {
            if (transact!=null) {
                transact.rollback();
            }
            throw new CustomException("Unable to add Dish " + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return dishId;
    }

    /**
     * gets the menu of a particlar hotel from the database table menu
     * and adds the dishes to a list
     *
     * @return Hotel Menu containing list of dishes to be displayed
     */
    public List<Dish> getMenuByHotelId(String hotelId) throws CustomException {
        List dishes =null;
        try {
            session = factory.openSession();
            Query query = session.createQuery("FROM Dish where hotel_id = :hotelId");
            query.setParameter("hotelId", hotelId);
            dishes = query.list();
        } catch (HibernateException exception) {
            throw new CustomException("Unable to get Menu" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return dishes;
    }
    
    /**
     * Gets the dish with the corresponding dish id from the table and returns
     * to service
     * @param id of the dish which is to be retrived
     * @return Dish object with the corresponding id
     */
    public Dish getDishById(String id) throws CustomException {
        Dish dish = null;
        try {
            session = factory.openSession();
            dish = session.get(Dish.class , id);
        } catch (HibernateException exception) {
            throw new CustomException("Unable to get Dish" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return dish;
    }    
       
    /**
     * Replaces the entry with matching dish Id with the new data contained 
     * in the customer object
     * @param POJO object dish to be updated in database table
     */
    public void updateDish(Dish dish) throws CustomException{
        Transaction transact = null;
        try {
            session = factory.openSession();
            transact = session.beginTransaction();
            session.update(dish); 
            transact.commit();
        } catch (HibernateException exception) {
            if (transact!=null) {
                transact.rollback();
            }
            throw new CustomException("Unable to update Dish" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    /**
     * Gets the size of the menu in menu table and returns it
     * @return long size of the menu
     */
    public long getCountOfMenu() throws CustomException{
        Long count = 0L;
        Transaction transact = null;
        try {
            session = factory.openSession();
            transact = session.beginTransaction();
            Query query = session.createQuery("SELECT COUNT(dishId) from Dish dish");
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
     * Deletes the dish by setting the status to false
     * @param dish object which is to be deleted
     */
    public void deleteDish(Dish item) throws CustomException{
        Transaction transact = null;
        try {
            session = factory.openSession();
            transact = session.beginTransaction();
            session.update(item);
            transact.commit();
        } catch (HibernateException exception) {
            if (transact!=null) {
                transact.rollback();
            }
            throw new CustomException("Unable to Delete Dish" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}   
