package com.firstChallege_Fast_Rental.car.model.entities;

import com.firstChallege_Fast_Rental.dto.in.CarRequestDTO;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Car extends Vehicle{
    public Car(CarRequestDTO requestDTO) {
        super(
                requestDTO.chassiId(),
                requestDTO.model(),
                requestDTO.brand(),
                requestDTO.color(),
                requestDTO.fabricationYear(),
                requestDTO.price());
    }
}
