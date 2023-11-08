package com.example.userauthentication.exceptions;

import com.example.userauthentication.dtos.ErrorMessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvices {

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<ErrorMessageDto> handleNotFoundException(Exception exception){
        ErrorMessageDto errorMessageDto = new ErrorMessageDto();
        errorMessageDto.setErrorMessage(exception.getMessage());
        return new ResponseEntity<ErrorMessageDto>(errorMessageDto, HttpStatus.NOT_FOUND);
    }
}
