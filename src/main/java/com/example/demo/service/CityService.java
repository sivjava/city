package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.employee.exception.RecordNotFoundException;
import com.example.demo.model.City;
import com.example.demo.repository.CityRepository;



@Service
public class CityService {

	@Autowired
	CityRepository repository;
	
	public List<City> getAllEmployees()
    {
        List<City> cityList = repository.findAll();
         
        if(cityList.size() > 0) {
            return cityList;
        } else {
            return new ArrayList<City>();
        }
    }
     
    public City getEmployeeById(Long id)  
    {
        Optional<City> city = repository.findById(id);
         
        if(city.isPresent()) {
            return city.get();
        } else {
            return new City();
        }
    }
    public City createOrUpdateEmployee(City cityEntity)  
    {
        Optional<City> city = repository.findById(cityEntity.getId());
        
        if(city.isPresent()) 
        {
        	City newCity = city.get();
            newCity.setName(cityEntity.getName());
            newCity.setPincode(cityEntity.getPincode());
            newCity.setState(cityEntity.getState());
 
            newCity = repository.save(newCity);
             
            return newCity;
        } else {
        	
        repository.save(cityEntity);
             
            return cityEntity;
        }
    } 
     
    public void deleteEmployeeById(Long id)  
    {
        Optional<City> city = repository.findById(id);
         
        if(city.isPresent()) 
        {
            repository.deleteById(id);
        } 
    } 
}