package com.firstChallege_Fast_Rental.repository;

import com.firstChallege_Fast_Rental.entities.Car;
import com.firstChallege_Fast_Rental.entities.Motorcycle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface MotorcycleRepository extends JpaRepository<Motorcycle, UUID> {
    @Query("""
        SELECT m
        FROM Motorcycle m
        WHERE (:model IS NULL OR LOWER(m.model) LIKE LOWER(CONCAT('%', :model, '%')))
          AND (:brand IS NULL OR LOWER(m.brand) LIKE LOWER(CONCAT('%', :brand, '%')))
          AND (:color IS NULL OR LOWER(m.color) LIKE LOWER(CONCAT('%', :color, '%')))
          AND (:minFabricationYear IS NULL OR m.fabricationYear >= :minFabricationYear)
          AND (:maxFabricationYear IS NULL OR m.fabricationYear <= :maxFabricationYear)
          AND (:minPrice IS NULL OR m.price >= :minPrice)
          AND (:maxPrice IS NULL OR m.price <= :maxPrice)
        """)
    Page<Car> findAllMotorcycleWithFilters(
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
