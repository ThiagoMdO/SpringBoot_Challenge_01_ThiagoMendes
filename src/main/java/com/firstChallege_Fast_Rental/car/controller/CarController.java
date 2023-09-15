package com.firstChallege_Fast_Rental.car.controller;

import com.firstChallege_Fast_Rental.car.bean.Car;
import com.firstChallege_Fast_Rental.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class CarController {
    @Autowired
    private CarRepository repository;
    @GetMapping("/car")
    public List<Car> getAllCars(){
        return repository.findAll();
    }
    @GetMapping("/car/{id}")
    public Car getAllCarsDetails(@PathVariable long id){
        Optional<Car> car = repository.findById(id);
        if(car.isEmpty()){
            throw new RuntimeException("Car don't exist, with id: " + id);
        }
        return car.get();
    }

    @PostMapping("/car")
    public void createCar(@RequestBody Car car){
        try{
            if(car.getBrand() == null || car.getBrand().isBlank()
                    || car.getModel() == null || car.getModel().isBlank()
                    || car.getColor() == null || car.getColor().isBlank()
                    || car.getFabricationYear() == null || car.getFabricationYear().isBlank()
            )
            {
                throw new Exception("Please insert all of the fields in the fill");
            }else {
                if(Objects.equals(car.getBrand(), "Ford")
                        || Objects.equals(car.getBrand(),"Chevrolet")
                        || Objects.equals(car.getBrand(),"BMW")
                        || Objects.equals(car.getBrand(),"Volvo"))
                {
                    repository.save(car);
                }else{
                    throw new Exception("Erro 404, model not authorized for registration, the field brand needs to be one of this brands: Ford, Chevrolet, BMW or Volvo. Please try again");
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
