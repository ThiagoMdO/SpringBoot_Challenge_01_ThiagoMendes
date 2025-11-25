package com.firstChallege_Fast_Rental.dto.in;

import com.firstChallege_Fast_Rental.enums.Brand;
import jakarta.validation.constraints.*;

public record CarRequestUpdateDTO(
        String model,

        @NotNull(message = "Precisa da marca.")
        Brand brand,

        @NotBlank(message = "Precisa da color.")
        String color,

        @Min(value = 1900, message = "Ano de fabricação inválido.")
        Integer fabricationYear,

        @Positive(message = "O preço deve ser maior que zero.")
        Double price,

        @Min(value = 1, message = "Deve ser pelo menos uma porta.")
        @Max(value = 6, message = "Número maximo de portas são 6.")
        Integer doors,

        boolean air,

        boolean automatic,

        boolean airbag
) {
}
