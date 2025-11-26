package com.firstChallege_Fast_Rental.service;

import com.firstChallege_Fast_Rental.dto.in.CarRequestUpdateDTO;
import com.firstChallege_Fast_Rental.entities.Vehicle;
import com.firstChallege_Fast_Rental.exceptions.build.ErrorCodeEnum;
import com.firstChallege_Fast_Rental.exceptions.customException.CustomSecurityException;
import com.firstChallege_Fast_Rental.entities.Car;
import com.firstChallege_Fast_Rental.repository.CarRepository;
import com.firstChallege_Fast_Rental.dto.in.CarRequestDTO;
import com.firstChallege_Fast_Rental.dto.out.CarResponseDTO;
import com.firstChallege_Fast_Rental.service.pricing.PricingStrategyFactory;
import com.firstChallege_Fast_Rental.service.pricing.strategy.RentalPriceStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository repository;
    private final PricingStrategyFactory priceFactory;

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
                pageable).map(c -> CarResponseDTO.toDTO(c, calculatePricePerDay(c)));
    }

    public CarResponseDTO getCarById(String id) {
        if (id == null) throw new CustomSecurityException(ErrorCodeEnum.INVALID_ID);

        var idCar = UUID.fromString(id);

        return repository.findById(idCar)
                .map(c -> CarResponseDTO.toDTO(c, calculatePricePerDay(c)))
                .orElseThrow(() -> new CustomSecurityException(ErrorCodeEnum.VEHICLE_NOT_FOUND));
    }

    public CarResponseDTO createCar(CarRequestDTO carRequestDTO) {
        checkYearIsCorrect(carRequestDTO.fabricationYear());

        var newCar = buildEntity(carRequestDTO);

        return CarResponseDTO.toDTO(newCar, calculatePricePerDay(newCar));
    }

    public CarResponseDTO updateCar(String id, CarRequestUpdateDTO requestUpdateDTO) {
        checkYearIsCorrect(requestUpdateDTO.fabricationYear());

        if (id == null) throw new CustomSecurityException(ErrorCodeEnum.INVALID_ID);

        var carToUpdate = repository.getReferenceById(UUID.fromString(id));

        carToUpdate.updateEntity(requestUpdateDTO);

        return CarResponseDTO.toDTO(carToUpdate, calculatePricePerDay(carToUpdate));
    }

    private Double calculatePricePerDay(Vehicle vehicle) {
        var days = 30;
        return (vehicle.getPrice() * priceFactory.getStrategy(vehicle.getBrand()).calculatePricePercentage()) / 100 / days;
    }

    private Car buildEntity(CarRequestDTO dto) {
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
