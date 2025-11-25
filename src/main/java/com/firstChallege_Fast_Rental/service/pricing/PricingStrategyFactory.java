package com.firstChallege_Fast_Rental.service.pricing;

import com.firstChallege_Fast_Rental.service.pricing.strategy.*;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PricingStrategyFactory {

    private final Map<String, RentalPriceStrategy> strategies = Map.of(
        "FORD", new FordRentalPriceStrategy(),
        "CHEVROLET", new ChevroletPriceStrategy(),
        "BMW", new BMWRentalPriceStrategy(),
        "VOLVO", new VolvoRentalPriceStrategy(),
        "HONDA", new HondaRentalPriceStrategy(),
        "YAMAHA", new YamahaRentalPriceStrategy(),
        "SUZUKI", new SuzukiRentalPriceStrategy(),
        "KAWASAKI", new KawasakiRentalPriceStrategy()
    );

    public RentalPriceStrategy getStrategy(String brand) {
        return strategies.getOrDefault(brand.toUpperCase(), () -> 1.0);
    }
}
