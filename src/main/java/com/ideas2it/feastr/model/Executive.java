package com.ideas2it.feastr.model;

import java.sql.Date;

/**
 * POJO class of the Delivery Executives in the feastr application contains the 
 * getter and setter methods of the data 
 */
public class Executive {
    private String executiveId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String mailId;
    private String vehicleNumber;
    private String licenseNumber;
    private String dob;
    private boolean status;
    private Date createdDate;
    private Date updatedDate;
    
    public String getExecutiveId() {
        return executiveId;
    }

    public void setExecutiveId(String id) {
        this.executiveId = id ;
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

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
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
        return (executiveId + " " + firstName + " " + lastName + " " 
                + phoneNumber + " " + vehicleNumber);
    }
}
