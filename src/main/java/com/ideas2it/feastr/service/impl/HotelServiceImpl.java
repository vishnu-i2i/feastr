package com.ideas2it.feastr.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.feastr.exception.CustomException;
import com.ideas2it.feastr.dao.HotelDAO;
import com.ideas2it.feastr.model.Address;
import com.ideas2it.feastr.model.Hotel;
import com.ideas2it.feastr.service.IHotelService;

/**
 * HotelServiceImpl is implemented from the IHotelService interface
 * and the implementation comments are in the interface
 */
@Service
public class HotelServiceImpl implements IHotelService {
    @Autowired
    private HotelDAO hotelDao;

    public String generateId() throws CustomException{
        long size = hotelDao.getCountOfHotels();
        return ("H" + ++size);
    }
    
    public Date generateDate() { 
        LocalDate now = LocalDate.now();
        return Date.valueOf(now);
    }

    public Hotel retrieveHotelById(String id) throws CustomException{
        Hotel hotel = hotelDao.getHotelById(id);
        if (null == hotel) {
            throw new CustomException("Invalid Hotel Id" + id);
        } else {
            return hotel;
        }
    }
 
    public List<Hotel> retrieveAllHotels() throws CustomException{
        return hotelDao.getAllHotels();
    }
    
    public List<Hotel> retrieveAvailableHotels() throws CustomException{
        return hotelDao.getAvailableHotels();
    }

    public boolean createHotel(Hotel hotel) throws CustomException {
        return (hotelDao.insertHotel(hotel).equals(hotel.getHotelId()));
    }
    
    public void updateHotel(Hotel hotel) throws CustomException {
        hotelDao.updateHotel(hotel);
    }

    public void deleteHotel(Hotel hotel) throws CustomException{
        hotelDao.deleteHotel(hotel);
    }
     
    public void addAddress(Hotel hotel, Address address) {
        List<Address> addresses = hotel.getAddresses();
        addresses.add(address);
        hotel.setAddresses(addresses);
    }
}
