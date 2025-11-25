package com.firstChallege_Fast_Rental.car.service;

import com.firstChallege_Fast_Rental.car.exceptions.build.ErrorCodeEnum;
import com.firstChallege_Fast_Rental.car.exceptions.customException.CustomSecurityException;
import com.firstChallege_Fast_Rental.car.model.entities.Car;
import com.firstChallege_Fast_Rental.car.repository.CarRepository;
import com.firstChallege_Fast_Rental.dto.in.CarRequestDTO;
import com.firstChallege_Fast_Rental.dto.out.CarResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository repository;

    public Page<CarResponseDTO> getAllCars(
            String model,
            String brand,
            String color,
            Integer minFabricationYear,
            Integer maxFabricationYear,
            Double minPrice,
            Double maxPrice,
            Pageable pageable
    ) {
        return repository.findAllCarsWithFilters(
                model,
                brand,
                color,
                minFabricationYear,
                maxFabricationYear,
                minPrice,
                maxPrice,
                pageable).map(CarResponseDTO::toDTO);
    }

    public CarResponseDTO getCarById(String id) {
        return repository.findById(id)
                .map(CarResponseDTO::toDTO)
                .orElseThrow(() -> new CustomSecurityException(ErrorCodeEnum.VEHICLE_NOT_FOUND));
    }

    public CarResponseDTO createCar(CarRequestDTO carRequestDTO) {
        checkYearIsCorrect(carRequestDTO.fabricationYear());

        var newCar = buildEntity(carRequestDTO);

        return CarResponseDTO.toDTO(newCar);
    }

    private Car buildEntity(CarRequestDTO dto) {
//        var car = Car.builder()
//                .brand(dto.brand())
//                .model(dto.model())
//                .color(dto.color())
//                .fabricationYear(dto.fabricationYear())
//                .price(dto.price())
//                .build();
        var car = new Car(dto);

        return repository.save(car);
    }

    private void checkYearIsCorrect(Integer fabricationYear) {

        int currentYear = java.time.Year.now().getValue();

        if (fabricationYear > currentYear) {
            throw new CustomSecurityException(ErrorCodeEnum.INVALID_YEAR);
        }
    }
}

