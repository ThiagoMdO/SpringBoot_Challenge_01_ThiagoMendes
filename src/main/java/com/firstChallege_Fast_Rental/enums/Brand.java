package com.firstChallege_Fast_Rental.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Brand {
    FORD("Ford", 5.0),
    CHEVROLET("Chevrolet", 3.0),
    BMW("BMW", 8.0),
    VOLVO("Volvo", 7.5),
    HONDA("Honda", 3.0),
    YAMAHA("Yamaha", 2.5),
    SUZUKI("Suzuki", 1.8),
    KAWASAKI("Kawasaki", 2.5);

    final String description;
    final Double tax;
}
