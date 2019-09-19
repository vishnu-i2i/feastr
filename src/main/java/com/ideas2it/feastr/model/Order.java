package com.ideas2it.feastr.model;

import java.math.BigDecimal;
import java.sql.Date;

public class Order {
    private int orderId;
    private Customer customer = new Customer();
    private Hotel hotel = new Hotel();
    private Executive executive = new Executive();
    private BigDecimal total = new BigDecimal(0);
    private String orderDetails = "";
    private Date createdDate;
    
    public int getOrderId() {
        return orderId;
    }
 
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    
    public Executive getExecutive() {
        return executive;
    }

    public void setExecutive(Executive executive) {
        this.executive = executive;
    }
    
    public String getCustomerId() {
        return customer.getCustomerId();
    }

    public void setCustomerId(String customerId) {
        this.customer.setCustomerId(customerId);
    }
    
    public String getHotelId() {
        return hotel.getHotelId();
    }

    public void setHotelId(String hotelId) {
        this.hotel.setHotelId(hotelId);
    }
    
    public String getExecutiveId() {
        return executive.getExecutiveId();
    }

    public void setExecutiveId(String executiveId) {
        this.executive.setExecutiveId(executiveId);
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }
    
    public BigDecimal getTotal() {
        return total;
    }
    
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
    public Date getCreatedDate() {
        return createdDate;
    }
 
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
