package com.firstChallege_Fast_Rental.car.exceptions;

import com.firstChallege_Fast_Rental.car.exceptions.build.ErrorCodeEnum;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class StandardExceptionHandler extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    private final String messageErrorCode;

    private final HttpStatus httpStatus;

    public StandardExceptionHandler(ErrorCodeEnum codeEnum, HttpStatus httpStatus) {
        this.messageErrorCode = codeEnum.getMessage();
        this.httpStatus = httpStatus;
    }

    public StandardExceptionHandler(ErrorCodeEnum codeEnum, HttpStatus httpStatus, String type) {
        this.messageErrorCode = codeEnum.getMessage() + ": " + type;
        this.httpStatus = httpStatus;
    }

}
