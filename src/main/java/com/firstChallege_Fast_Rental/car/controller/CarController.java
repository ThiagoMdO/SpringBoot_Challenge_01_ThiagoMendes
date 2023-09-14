package com.firstChallege_Fast_Rental.car.controller;

import com.firstChallege_Fast_Rental.car.bean.Car;
import com.firstChallege_Fast_Rental.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("car")
public class CarController {
    @Autowired
    private CarRepository repository;
    @GetMapping("/car")
    public List<Car> getAllCars(){
        return repository.findAll();
    }
}
