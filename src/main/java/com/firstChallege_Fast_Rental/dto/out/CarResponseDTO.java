package com.firstChallege_Fast_Rental.dto.out;

import com.firstChallege_Fast_Rental.car.model.entities.Car;

public record CarResponseDTO(
        String id,
        String chassiId,
        String model,
        String brand,
        String color,
        String fabricationYear,
        Double price) {

    public static CarResponseDTO toDTO(Car car) {
        return new CarResponseDTO(
                car.getId(),
                car.getChassiId(),
                car.getModel(),
                car.getBrand().getDescription(),
                car.getColor(),
                String.valueOf(car.getFabricationYear()),
                car.getPrice()
        );
    }
}
