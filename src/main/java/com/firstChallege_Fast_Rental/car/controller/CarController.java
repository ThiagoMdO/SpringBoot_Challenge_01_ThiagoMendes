package com.firstChallege_Fast_Rental.car.controller;

import com.firstChallege_Fast_Rental.car.bean.Car;
import com.firstChallege_Fast_Rental.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {
    @Autowired
    private CarService carService;
    @GetMapping("/car")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }
    @GetMapping("/car/{id}")
    public ResponseEntity<String> getAllCarsDetails(@PathVariable long id) {
        Optional<Car> car = carService.getCarDetails(id);
        if (car.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Response 404: car doesn't found");
        }
    }
    @PostMapping("/car")
    public ResponseEntity<String> createCar(@RequestBody Car car) {
        return carService.createCar(car);
    }
}