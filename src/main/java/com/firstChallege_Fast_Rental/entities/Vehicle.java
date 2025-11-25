package com.firstChallege_Fast_Rental.entities;

import com.firstChallege_Fast_Rental.enums.Brand;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "vehicle")
@Data
@ToString(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(unique = true)
    private String chassiId;

    private String model;

    @Enumerated(EnumType.STRING)
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
