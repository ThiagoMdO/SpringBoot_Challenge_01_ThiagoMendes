package com.firstChallege_Fast_Rental.entities;

import com.firstChallege_Fast_Rental.dto.in.CarRequestDTO;
import com.firstChallege_Fast_Rental.dto.in.CarRequestUpdateDTO;
import com.firstChallege_Fast_Rental.enums.Brand;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Car extends Vehicle{
    private Integer doors;
    private boolean air;
    private boolean automatic;
    private boolean airbag;

    public Car(CarRequestDTO requestDTO) {
        super(
                requestDTO.chassiId(),
                requestDTO.model(),
                requestDTO.brand(),
                requestDTO.color(),
                requestDTO.fabricationYear(),
                requestDTO.price()
        );
        this.doors = requestDTO.doors();
        this.air = requestDTO.air();
        this.automatic = requestDTO.automatic();
        this.airbag = requestDTO.airbag();
    }

    public Car(
        String chassiId,
        String model,
        Brand brand,
        String color,
        Integer fabricationYear,
        Double price
    ) {
        super(
            chassiId,
            model,
            brand,
            color,
            fabricationYear,
            price
        );
    }

    public void updateEntity(CarRequestUpdateDTO requestUpdateDTO) {
        if (requestUpdateDTO.model() != null) setModel(requestUpdateDTO.model());
        if (requestUpdateDTO.brand() != null) setBrand(requestUpdateDTO.brand());
        if (requestUpdateDTO.color() != null) setColor(requestUpdateDTO.color());
        if (requestUpdateDTO.fabricationYear() != null) setFabricationYear(requestUpdateDTO.fabricationYear());
        if (requestUpdateDTO.price() != null) setPrice(requestUpdateDTO.price());
        if (requestUpdateDTO.doors() != null) setDoors(requestUpdateDTO.doors());
        setAir(requestUpdateDTO.air());
        setAutomatic(requestUpdateDTO.automatic());
        setAirbag(requestUpdateDTO.airbag());
    }
}
