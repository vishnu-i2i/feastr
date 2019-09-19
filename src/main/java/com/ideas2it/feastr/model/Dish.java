package com.ideas2it.feastr.model;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * POJO class of the Menu in the feastr application contains the getter and
 * setter methods of the data 
 */
public class Dish {
    private Hotel hotel = new Hotel();
    private String dishId;
    private String name;
    private BigDecimal price;
    private boolean availability;
    private String category;
    private Date createdDate;
    private Date updatedDate;

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getHotelId() {
        return hotel.getHotelId();
    }

    public void setHotelId(String hotelId) {
        this.hotel.setHotelId(hotelId);
    }

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean available) {
        this.availability = available;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public Date getCreatedDate() {
        return createdDate;
    }
 
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    public Date getUpdatedDate() {
        return updatedDate;
    }
 
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String toString() {
        return (hotel.getHotelId() + "\t" + dishId + "\t" + name + "\t" + price 
                + "\t" + category);
    }
}
