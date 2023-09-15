package com.firstChallege_Fast_Rental.car.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name="car")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Car {
    @Id
    @GeneratedValue
    private Long chassiId;
    private String model;
    private String brand;
    private String color;
    private String fabricationYear;
}
