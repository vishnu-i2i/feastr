package com.ideas2it.feastr.service.impl;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.feastr.exception.CustomException;
import com.ideas2it.feastr.dao.ExecutiveDAO;
import com.ideas2it.feastr.model.Executive;
import com.ideas2it.feastr.service.IExecutiveService;

/**
 * ExecutiveServiceImpl is implemented from the IExecutiveService interface
 * and the implementation comments are in the interface
 */
@Service
public class ExecutiveServiceImpl implements IExecutiveService {
    @Autowired
    private ExecutiveDAO executiveDao;

    public String generateId() throws CustomException{
        long size = executiveDao.getCountOfExecutives();
        return ("E" + ++size);
    }
    
    public Date generateDate() { 
        LocalDate now = LocalDate.now();
        return Date.valueOf(now);
    }
    
    public Executive retrieveExecutiveById(String id) throws CustomException{
        Executive executive = executiveDao.getExecutiveById(id);
        if (null == executive) {
            throw new CustomException("Invalid Executive Id" + id);
        } else {
            return executive;
        }
    }
 
    public List<Executive> retrieveAllExecutives() throws CustomException{
        return executiveDao.getAllExecutives();
    }

    public boolean createExecutive(Executive executive) throws CustomException {
        return executiveDao.insertExecutive(executive).equals(executive.getExecutiveId());
    }
    
    public void updateExecutive(Executive executive) throws CustomException{
        executiveDao.updateExecutive(executive);
   }

    public void deleteExecutive(Executive executive) throws CustomException{
        executiveDao.deleteExecutive(executive);
    }
}

