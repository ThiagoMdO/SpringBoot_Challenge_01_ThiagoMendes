package com.firstChallege_Fast_Rental.car.repository;

import com.firstChallege_Fast_Rental.car.model.entities.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {


    @Query("""
        SELECT c
        FROM Car c
        WHERE (:model IS NULL OR LOWER(c.model) LIKE LOWER(CONCAT('%', :model, '%')))
          AND (:brand IS NULL OR LOWER(c.brand) LIKE LOWER(CONCAT('%', :brand, '%')))
          AND (:color IS NULL OR LOWER(c.color) LIKE LOWER(CONCAT('%', :color, '%')))
          AND (:minFabricationYear IS NULL OR c.fabricationYear >= :minFabricationYear)
          AND (:maxFabricationYear IS NULL OR c.fabricationYear <= :maxFabricationYear)
          AND (:minPrice IS NULL OR c.price >= :minPrice)
          AND (:maxPrice IS NULL OR c.price <= :maxPrice)
        """)
    Page<Car> findAllCarsWithFilters(
            String model,
            String brand,
            String color,
            Integer minFabricationYear,
            Integer maxFabricationYear,
            Double minPrice,
            Double maxPrice,
            Pageable pageable
    );
}
