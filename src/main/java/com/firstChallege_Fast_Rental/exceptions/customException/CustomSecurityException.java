package com.firstChallege_Fast_Rental.exceptions.customException;

import com.firstChallege_Fast_Rental.exceptions.StandardExceptionHandler;
import com.firstChallege_Fast_Rental.exceptions.build.ErrorCodeEnum;
import org.springframework.http.HttpStatus;

public class CustomSecurityException extends StandardExceptionHandler {
    public CustomSecurityException(ErrorCodeEnum codeEnum) {
        super(codeEnum, HttpStatus.NOT_FOUND);
    }
}
