package com.firstChallege_Fast_Rental.service.pricing;

import com.firstChallege_Fast_Rental.enums.Brand;
import com.firstChallege_Fast_Rental.service.pricing.strategy.*;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PricingStrategyFactory {

    private final Map<Brand, RentalPriceStrategy> strategies = Map.of(
        Brand.FORD, new FordRentalPriceStrategy(),
        Brand.CHEVROLET, new ChevroletPriceStrategy(),
        Brand.BMW, new BMWRentalPriceStrategy(),
        Brand.VOLVO, new VolvoRentalPriceStrategy(),
        Brand.HONDA, new HondaRentalPriceStrategy(),
        Brand.YAMAHA, new YamahaRentalPriceStrategy(),
        Brand.SUZUKI, new SuzukiRentalPriceStrategy(),
        Brand.KAWASAKI, new KawasakiRentalPriceStrategy()
    );

    public RentalPriceStrategy getStrategy(Brand brand) {
        return strategies.getOrDefault(brand, () -> 1.0);
    }
}
