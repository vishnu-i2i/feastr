package com.ideas2it.feastr.model;

import java.sql.Date;

/**
 * POJO for the Address type for the Customer POJO in the feastr application
 */ 
public class Address {
    private int addressId;
    private Customer customer;
    private Hotel hotel;
    private String streetName;
    private String city;
    private String pincode;
    
    public int getAddressId() {
        return addressId;
    }
 
    public void setAddressId(int addressId) {
        this.addressId = addressId;
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
    
    public String getStreetName() {
        return streetName;
    }
 
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }
 
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String toString() {
        return (streetName + " " + city + " " + pincode);
    }
}
