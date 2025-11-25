package com.firstChallege_Fast_Rental.entities;


import com.firstChallege_Fast_Rental.dto.in.MotorcycleRequest;
import com.firstChallege_Fast_Rental.enums.Brand;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Motorcycle extends Vehicle{

    private boolean abs;
    private boolean storageBox;

    public Motorcycle(MotorcycleRequest requestDTO) {
        super(
        requestDTO.chassiId(),
        requestDTO.model(),
        requestDTO.brand(),
        requestDTO.color(),
        requestDTO.fabricationYear(),
        requestDTO.price());
    }

    public Motorcycle(
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
}
