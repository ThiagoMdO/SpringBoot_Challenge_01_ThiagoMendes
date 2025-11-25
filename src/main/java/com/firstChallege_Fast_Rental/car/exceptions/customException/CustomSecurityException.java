package com.firstChallege_Fast_Rental.car.exceptions.customException;

import com.firstChallege_Fast_Rental.car.exceptions.StandardExceptionHandler;
import com.firstChallege_Fast_Rental.car.exceptions.build.ErrorCodeEnum;
import org.springframework.http.HttpStatus;

public class CustomSecurityException extends StandardExceptionHandler {
    public CustomSecurityException(ErrorCodeEnum codeEnum) {
        super(codeEnum, HttpStatus.NOT_FOUND);
    }
}
