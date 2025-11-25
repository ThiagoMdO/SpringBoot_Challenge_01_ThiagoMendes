package com.firstChallege_Fast_Rental.service.pricing.strategy;

import com.firstChallege_Fast_Rental.enums.Brand;

public class KawasakiRentalPriceStrategy implements RentalPriceStrategy{
    @Override
    public double calculatePricePercentage() {
        return Brand.KAWASAKI.getTax();
    }
}
