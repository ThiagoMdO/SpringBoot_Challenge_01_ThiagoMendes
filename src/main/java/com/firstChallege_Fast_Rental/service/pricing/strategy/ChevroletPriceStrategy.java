package com.firstChallege_Fast_Rental.service.pricing.strategy;

import com.firstChallege_Fast_Rental.enums.Brand;

public class ChevroletPriceStrategy implements RentalPriceStrategy {
    @Override
    public double calculatePricePercentage() {
        return Brand.CHEVROLET.getTax();
    }
}
