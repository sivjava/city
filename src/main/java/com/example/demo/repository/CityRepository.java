package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.City;

public interface CityRepository extends JpaRepository<City, Long> {

}
