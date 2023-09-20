package com.firstChallege_Fast_Rental.car.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Car {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long chassiId;
    private String model;
    private String brand;
    private String color;
    private String fabricationYear;
}
