package com.ideas2it.feastr.service.impl;

import java.math.BigDecimal;
import java.lang.String;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.feastr.dao.MenuDAO;
import com.ideas2it.feastr.exception.CustomException;
import com.ideas2it.feastr.model.Dish;
import com.ideas2it.feastr.model.Hotel;
import com.ideas2it.feastr.service.IHotelService;
import com.ideas2it.feastr.service.IMenuService;

/**
 * MenuServiceImpl is implemented from the IMenuService interface
 * and the implementation comments are in the interface
 */
@Service
public class MenuServiceImpl implements IMenuService {
    @Autowired
    private MenuDAO menuDao;
    @Autowired
    private HotelServiceImpl hotelService;
    
    public String generateId() throws CustomException{
        long size = menuDao.getCountOfMenu();
        return ("D" + ++size);
    }
    
    public Date generateDate() { 
        LocalDate now = LocalDate.now();
        return Date.valueOf(now);
    }

    public Dish retrieveDishById(String id) throws CustomException{
        Dish dish = menuDao.getDishById(id);
        if (null == dish) {
            throw new CustomException("Invalid Dish Id" + id);
        } else {
            return dish;
        }
    }
    
    public List<Dish> retrieveMenuByHotelId(String hotelId) throws CustomException{
        return menuDao.getMenuByHotelId(hotelId);
    }
 
    public boolean createDish(Dish item) throws CustomException {
        return menuDao.insertDish(item).equals(item.getDishId());
    }
    
    public void updateDish(Dish item) throws CustomException{
        menuDao.updateDish(item);
    }

    public void deleteDish(Dish item) throws CustomException{
        menuDao.deleteDish(item);
    }
}
