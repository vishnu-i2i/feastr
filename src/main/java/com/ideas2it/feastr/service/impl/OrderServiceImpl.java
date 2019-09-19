package com.ideas2it.feastr.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.feastr.exception.CustomException;
import com.ideas2it.feastr.dao.OrderDAO;
import com.ideas2it.feastr.model.Customer;
import com.ideas2it.feastr.model.Dish;
import com.ideas2it.feastr.model.Executive;
import com.ideas2it.feastr.model.Hotel;
import com.ideas2it.feastr.model.Order;
import com.ideas2it.feastr.service.ICustomerService;
import com.ideas2it.feastr.service.IExecutiveService;
import com.ideas2it.feastr.service.IHotelService;
import com.ideas2it.feastr.service.IMenuService;
import com.ideas2it.feastr.service.IOrderService;

/**
 * OrderServiceImpl is implemented from the IOrderService interface
 * and the implementation comments are in the interface
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private ExecutiveServiceImpl executiveService;
    @Autowired
    private HotelServiceImpl hotelService;
    @Autowired
    private MenuServiceImpl menuService;
    @Autowired
    private OrderDAO orderDAO;

    public Boolean checkCustomer(String customerId,String phoneNumber) 
            throws CustomException{
        Customer customer = customerService.retrieveCustomerById(customerId);
        if (null == customer) {
            return null;
        } else {
            if(phoneNumber.equals(customer.getPhoneNumber())) {
                return customer.getRole().equals("admin");
            } else {
                return null;
            }
        }
    }

    public List<Hotel> retrieveAvailableHotels() throws CustomException {
        return hotelService.retrieveAvailableHotels();
    }
         
    public List<Dish> retrieveMenuByHotelId(String hotelId) throws CustomException {
        return menuService.retrieveMenuByHotelId(hotelId);
    }
    
    public Dish retrieveDishById(String id) throws CustomException {
        return menuService.retrieveDishById(id);
    }
    
    public void calculateTotal(Order order, Dish dish, int quantity) {
        BigDecimal cost = new BigDecimal(0);
        cost = (new BigDecimal(quantity)).multiply(dish.getPrice()); 
        order.setTotal(cost.add(order.getTotal()));
        order.setOrderDetails(order.getOrderDetails() +dish.getName() 
                              + "-" + quantity + ", ");
    }
    
    public int createOrder(Order order) throws CustomException {
        return orderDAO.insertOrder(order);
    }
    

    public Executive setExecutiveForOrder(Order order) throws CustomException {
        for (Executive executive : executiveService.retrieveAllExecutives()) {
            if  (true == executive.getStatus()) {
                executiveService.deleteExecutive(executive);
                order.setExecutiveId(executive.getExecutiveId());
                return executive;
            }
        }
        return null;
    }
}
