package com.firstChallege_Fast_Rental.car.controller;

import com.firstChallege_Fast_Rental.car.service.CarService;
import com.firstChallege_Fast_Rental.dto.in.CarRequestDTO;
import com.firstChallege_Fast_Rental.dto.out.CarResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/cars")
    public ResponseEntity<Page<CarResponseDTO>> getAllCars(
            @RequestParam(required = false) String model,
            @RequestParam(required = false)  String brand,
            @RequestParam(required = false)  String color,
            @RequestParam(required = false)  Integer minFabricationYear,
            @RequestParam(required = false)  Integer maxFabricationYear,
            @RequestParam(required = false)  Double minPrice,
            @RequestParam(required = false)  Double maxPrice,
            @PageableDefault(
                size = 15,
                sort = {"model"},
                direction = Sort.Direction.ASC) Pageable pageable
    ) {
        var cars = carService.getAllCars(model, brand, color, minFabricationYear, maxFabricationYear, minPrice, maxPrice, pageable);

        return ResponseEntity.ok(cars);
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<CarResponseDTO> getCarById(@PathVariable String id) {
        var car = carService.getCarById(id);

        return ResponseEntity.ok(car);
    }

    @PostMapping("/crete/car")
    public ResponseEntity<CarResponseDTO> createCar(@RequestBody @Valid CarRequestDTO carRequestDTO) {
        var carCreated = carService.createCar(carRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(carCreated);
    }
}