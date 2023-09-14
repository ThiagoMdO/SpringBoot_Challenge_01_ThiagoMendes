package com.firstChallege_Fast_Rental.car.repository;

import com.firstChallege_Fast_Rental.car.bean.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
