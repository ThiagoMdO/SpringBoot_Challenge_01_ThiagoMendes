package com.firstChallege_Fast_Rental.car.controller;

import com.firstChallege_Fast_Rental.car.bean.Car;
import com.firstChallege_Fast_Rental.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.util.StringUtils;


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
    public ResponseEntity<String> getAllCarsDetails(@PathVariable long id){
        try{
            Optional<Car> car = repository.findById(id);
            if(car.get().getChassiId() != null){
                String data = "Response 200: on success in your search " + car.get();
                return ResponseEntity.ok(data);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Response 404: car doesn't found");
    }

    @PostMapping("/car")
    public ResponseEntity<String> createCar(@RequestBody Car car){
        try{
            if(!StringUtils.hasText(car.getBrand())
                    || !StringUtils.hasText(car.getModel())
                    || !StringUtils.hasText(car.getColor())
                    || !StringUtils.hasText(car.getFabricationYear())
            )
            {
                String responseData = "Response 400: Bad Request: Please insert all of the fields in the form";
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
                //throw new IllegalArgumentException("Please insert all of the fields in the form");

            }else {
                if(Objects.equals(car.getBrand(), "Ford")
                        || Objects.equals(car.getBrand(),"Chevrolet")
                        || Objects.equals(car.getBrand(),"BMW")
                        || Objects.equals(car.getBrand(),"Volvo"))
                {
                    repository.save(car);
                    String responseData = "Response 201, success to create: " + car;
                    return ResponseEntity.ok(responseData);
                }else{
                    String responseData = "Response 404: Not found: Model not authorized for registration, the field brand needs to be one of this brands: Ford, Chevrolet, BMW or Volvo. Please try again";
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseData);
                    //throw new IllegalArgumentException("Erro 404, model not authorized for registration, the field brand needs to be one of this brands: Ford, Chevrolet, BMW or Volvo. Please try again");
                }
            }
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Error, restart the application");
        }
    }
}
