package com.firstChallege_Fast_Rental.car.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Brand {
    FORD("Ford"),
    CHEVROLET("Chevrolet"),
    BMW("BMW"),
    VOLVO("Volvo");

    final String description;
}
