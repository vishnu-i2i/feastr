package com.ideas2it.feastr.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * POJO class of the Menu in the feastr application contains the getter and
 * setter methods of the data 
 */
public class Customer {
    private String customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String mailId;
    private String dob;
    private boolean status;
    private String role;
    private Date createdDate;
    private Date updatedDate;
    private List<Address> addresses = new ArrayList<>();

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String id) {
        this.customerId = id ;
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
   
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        return (customerId + "\t" + firstName + "\t" + lastName + "\t" + 
                phoneNumber + "\t" + mailId);
    }
}
