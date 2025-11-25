package com.firstChallege_Fast_Rental.dto.in;

import com.firstChallege_Fast_Rental.enums.Brand;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record MotorcycleRequest(
        @NotBlank(message = "Precisa do número do Chassi.")
        String chassiId,

        @NotBlank(message = "Precisa do nome do modelo.")
        String model,

        @NotNull(message = "Precisa da marca.")
        Brand brand,

        @NotBlank(message = "Precisa da color.")
        String color,

        @NotNull(message = "Precisa do ano de fabricação.")
        @Min(value = 1900, message = "Ano de fabricação inválido.")
        Integer fabricationYear,

        @NotNull(message = "Precisa do preço do veículo.")
        @Positive(message = "O preço deve ser maior que zero.")
        Double price,

        boolean abs,

        boolean storageBox
) {
}
