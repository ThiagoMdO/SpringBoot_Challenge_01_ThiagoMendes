package com.firstChallege_Fast_Rental.dto.out;

import com.firstChallege_Fast_Rental.entities.Car;

public record CarResponseDTO(
        String id,
        String chassiId,
        String model,
        String brand,
        String color,
        Integer fabricationYear,
        Double price,
        Double rentalPricePerDay,
        Integer doors,
        boolean air,
        boolean automatic,
        boolean airBag) {

    public static CarResponseDTO toDTO(Car car, Double rentalPricePerDay) {
        Double priceFormatted = Math.round(rentalPricePerDay * 100.0) / 100.0;

        return new CarResponseDTO(
        car.getId().toString(),
        car.getChassiId(),
        car.getModel(),
        car.getBrand().getDescription(),
        car.getColor(),
        car.getFabricationYear(),
        car.getPrice(),
        priceFormatted,
        car.getDoors(),
        car.isAir(),
        car.isAutomatic(),
        car.isAirbag()
        );
    }
}
