package com.ideas2it.feastr.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * POJO class of the Hotel in the feastr application contains the getter and
 * setter methods of the Hotel object 
 */
public class Hotel {
    private String hotelId;
    private String firstName;
    private String lastName;
    private String managerName;
    private String location;
    private String phoneNumber;
    private String mailId;
    private boolean status;
    private List <Address> addresses = new ArrayList<>();
    private Date createdDate;
    private Date updatedDate;
    
    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String id) {
        this.hotelId = id ;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Address> getAddresses() {
        return addresses;
    }
 
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
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
        return (hotelId + "\t" + firstName + "\t" + lastName + "\t" + 
                phoneNumber + "\t" + mailId);
    }
}
