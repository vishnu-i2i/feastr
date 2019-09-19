package com.ideas2it.feastr.util;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.util.regex.Matcher;

import com.ideas2it.feastr.exception.CustomException;

/**
 * Util class contains the validation of format for phone number,vehicle number,
 * license number and date of birth
 */
public class CommonUtil {

    /**
     * validate phone number checks the phone number format
     * 
     * @param Phone Number entered by the user
     * @return boolean value true if valid phone number else false 
     */
    public static boolean validatePhoneNumber(String phoneNumber) {
        String pattern = "^[7-9][0-9]{9}$";
        return phoneNumber.matches(pattern);
    }
  
    /**
     * validate vehicle number checks the vehicle number format
     * 
     * @param vehicle Number entered by the user
     * @return boolean value true if valid vehicle number else false
     */
    public static boolean validateVehicleNumber(String phoneNumber) {
        String pattern = "^[A-Z]{2} [0-9]{2} [A-Z] [0-9]{4}$";
        return phoneNumber.matches(pattern);
    }

    /**
     * validate license number checks the license number format
     * 
     * @param license Number entered by the user
     * @return boolean value true if valid license number else false
     */
    public static boolean validateLicenseNumber(String licenseNumber) {
        String pattern = "^[A-Z]{2}[0-9]{2} [0-9]{11}$";
        return licenseNumber.matches(pattern);
    }

    /**
     * checks if a the price value contains less than two decimal places
     * and is not equal to zero
     *
     * @param  : contains the dish price entered by user
     * @return : boolean value true if price is valid
     */
    public static boolean validatePrice(BigDecimal price) {
       return !((price.compareTo(((BigDecimal.valueOf(0.0)))) == 1)
                && (price.scale() == 2)); 
    }

    /**
     * checks if the mail id format is valid
     *
     * @param  mail id entered by the user
     * @return boolean value true is mailId is valid
     */
    public static boolean validateMailId(String mailId) {
        String pattern = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+[.]+[a-z](.+)$";
        return !mailId.matches(pattern);
    }

    /**
     * checks if the pincode format is valid
     *
     * @param  pincode entered by the user
     * @return boolean value true is pincode is valid
     */
    public static boolean validatePincode(String pincode) {
        String pattern = "^[0-9]{6}$";
        return !pincode.matches(pattern);
    }  
    
    /** calculates the age of the person and checks if the age is greater 
     *  than 18 years 
     *
     *  @param String Date Of Birth entered by the user
     *  @return boolean false if it has valid date format
     */
    public static boolean validateDOB(String dob) throws CustomException{
        try {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate.parse(dob,dateFormat);
            return false;
        } catch(DateTimeParseException e) {
            throw new CustomException("Invalid Date Format.Enter in YYYY-MM-DD");
        }
    }
}
