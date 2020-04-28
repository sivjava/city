package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import com.example.employee.exception.RecordNotFoundException;
import com.example.demo.model.City;
import com.example.demo.service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {

	@Autowired
	CityService service;
	
	@GetMapping
    public ResponseEntity<List<City>> getAllEmployees() {
        List<City> list = service.getAllEmployees();
 
        return new ResponseEntity<List<City>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<City> getEmployeeById(@PathVariable("id") Long id) {
    	City entity = service.getEmployeeById(id);
 
        return new ResponseEntity<City>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping("/add")
    public ResponseEntity<City> createOrUpdateEmployee(@RequestBody City employee) {
    	City updated = service.createOrUpdateEmployee(employee);
        return new ResponseEntity<City>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) {
                                                   
        service.deleteEmployeeById(id);
        return HttpStatus.OK;
    }
}