package com.firstChallege_Fast_Rental.car.exceptions.build;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCodeEnum {
    VEHICLE_NOT_FOUND("Veiculo não encotrado."),

    INVALID_BRAND("Marca inválida"),
    INVALID_YEAR("Ano inválido"),
    INVALID_PRICE("Valor incorreto, precisa ser ")

    SYSTEM_ERROR("Erro na consulta dos dados, problema no sistema.")
    ;

    private final String message;
}
