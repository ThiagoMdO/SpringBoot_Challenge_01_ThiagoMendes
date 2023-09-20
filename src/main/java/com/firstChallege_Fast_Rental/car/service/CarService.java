package com.firstChallege_Fast_Rental.car.service;

import com.firstChallege_Fast_Rental.car.bean.Car;
import com.firstChallege_Fast_Rental.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository repository;

    public List<Car> getAllCars() {
        return repository.findAll();
    }

    public Optional<Car> getCarDetails(long id) {
        return repository.findById(id);
    }

    public ResponseEntity<String> createCar(Car car) {
        try {
            if (!StringUtils.hasText(car.getBrand())
                    || !StringUtils.hasText(car.getModel())
                    || !StringUtils.hasText(car.getColor())
                    || !StringUtils.hasText(car.getFabricationYear())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please insert all of the fields in the form correctly");
            } else {
                if (Objects.equals(car.getBrand().toUpperCase(), "FORD")
                        || Objects.equals(car.getBrand().toUpperCase(), "CHEVROLET")
                        || Objects.equals(car.getBrand().toUpperCase(), "BMW")
                        || Objects.equals(car.getBrand().toUpperCase(), "VOLVO")) {
                    repository.save(car);
                    return ResponseEntity.status(HttpStatus.CREATED).build();
                } else {
                    String responseData = "Response 404: Not found: Brand not authorized for registration, the field brand needs to be one of this brands: Ford, Chevrolet, BMW or Volvo. Please try again";
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseData);
                }
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
    }
}

