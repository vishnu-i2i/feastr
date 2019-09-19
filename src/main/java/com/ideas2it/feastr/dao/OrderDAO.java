package com.ideas2it.feastr.dao;

import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException; 
import org.hibernate.query.Query;
import org.hibernate.Session; 
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.stereotype.Repository;

import com.ideas2it.feastr.configuration.HibernateUtil;
import com.ideas2it.feastr.exception.CustomException;
import com.ideas2it.feastr.model.Order;


/** 
 * Adds the confirmed order into the orders table in the database
 */
@Repository 
public class OrderDAO {
    private SessionFactory factory = HibernateUtil.buildSessionFactory();
    private Session session;
    /**
     * Adds the order details to the order_details table in the feastr database
     *
     * @param Order Object containing the order values
     * @return int value = 1 on successful addition
     */
    public int insertOrder(Order order) throws CustomException{ 
        int orderId = 0;
        Transaction transact = null;
        try {
            session = factory.openSession();
            transact = session.beginTransaction();
            orderId = (Integer) session.save(order);
            transact.commit();
        } catch (HibernateException exception) {
            if (transact!=null) {
                transact.rollback();
            }
            throw new CustomException("Unable to add Order " + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return orderId;
    }
}
