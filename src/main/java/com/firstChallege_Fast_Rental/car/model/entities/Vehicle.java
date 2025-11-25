package com.firstChallege_Fast_Rental.car.model.entities;

import com.firstChallege_Fast_Rental.car.enums.Brand;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@ToString(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String chassiId;
    private String model;
    private Brand brand;
    private String color;
    private Integer fabricationYear;
    private Double price;

    public Vehicle (
            String chassiId,
            String model,
            Brand brand,
            String color,
            Integer fabricationYear,
            Double price) {
        this.chassiId = chassiId;
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.fabricationYear = fabricationYear;
        this.price = price;
    }
}
