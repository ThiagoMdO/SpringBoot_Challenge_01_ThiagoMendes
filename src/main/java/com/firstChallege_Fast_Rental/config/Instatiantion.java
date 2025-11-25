package com.firstChallege_Fast_Rental.config;

import com.firstChallege_Fast_Rental.entities.Car;
import com.firstChallege_Fast_Rental.entities.Motorcycle;
import com.firstChallege_Fast_Rental.enums.Brand;
import com.firstChallege_Fast_Rental.repository.CarRepository;
import com.firstChallege_Fast_Rental.repository.MotorcycleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class Instatiantion implements CommandLineRunner {

    private final CarRepository carRepository;
    private final MotorcycleRepository motorcycleRepository;

    @Override
    public void run(String... args) throws Exception {

        if (carRepository.count() == 0) {

            carRepository.deleteAll();
            motorcycleRepository.deleteAll();

            var car1 = new Car(
                "123456",
                "Onix",
                Brand.FORD,
                "Red",
                2010,
                25000.00
            );
            car1.setDoors(4);
            car1.setAir(true);
            car1.setAutomatic(false);
            car1.setAirbag(true);

            var car2 = new Car(
                "987654",
                "Focus",
                Brand.FORD,
                "Blue",
                2014,
                43000.00
            );
            car2.setDoors(4);
            car2.setAir(true);
            car2.setAutomatic(true);
            car2.setAirbag(true);

            var car3 = new Car(
                "456123",
                "Cruze",
                Brand.CHEVROLET,
                "Black",
                2018,
                62000.00
            );
            car3.setDoors(4);
            car3.setAir(true);
            car3.setAutomatic(true);
            car3.setAirbag(true);

            var car4 = new Car(
                "741852",
                "S60",
                Brand.VOLVO,
                "White",
                2017,
                95000.00
            );
            car4.setDoors(4);
            car4.setAir(true);
            car4.setAutomatic(true);
            car4.setAirbag(true);

            var car5 = new Car(
                "852963",
                "320i",
                Brand.BMW,
                "Gray",
                2015,
                85000.00
            );
            car5.setDoors(4);
            car5.setAir(true);
            car5.setAutomatic(true);
            car5.setAirbag(true);

            var car6 = new Car(
                "369258",
                "Mustang",
                Brand.FORD,
                "Red",
                2020,
                230000.00
            );
            car6.setDoors(2);
            car6.setAir(true);
            car6.setAutomatic(true);
            car6.setAirbag(true);

            var moto1 = new Motorcycle(
                "MOTO123",
                "CB 500F",
                Brand.HONDA,
                "Red",
                2021,
                35000.00
            );
            moto1.setAbs(true);
            moto1.setStorageBox(false);

            var moto2 = new Motorcycle(
                "MOTO456",
                "MT-07",
                Brand.YAMAHA,
                "Blue",
                2020,
                42000.00
            );
            moto2.setAbs(true);
            moto2.setStorageBox(false);

            var moto3 = new Motorcycle(
                "MOTO789",
                "Ninja 400",
                Brand.KAWASAKI,
                "Green",
                2022,
                39000.00
            );
            moto3.setAbs(true);
            moto3.setStorageBox(false);

            var moto4 = new Motorcycle(
                "MOTO852",
                "R1200 GS",
                Brand.BMW,
                "Gray",
                2018,
                72000.00
            );
            moto4.setAbs(true);
            moto4.setStorageBox(true);

            carRepository.saveAll(List.of(car1, car2, car3, car4, car5, car6));
            motorcycleRepository.saveAll(List.of(moto1, moto2, moto3, moto4));
        }
    }
}
