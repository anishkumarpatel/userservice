package com.scaler.user.demo.contolleradvices;

import com.scaler.user.demo.exceptions.UserNotFoundException;
import com.scaler.user.demo.dtos.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<MessageDto> handleNotFoundException(
            Exception exception) {
        MessageDto messageDto = new MessageDto();
        messageDto.setMessage(exception.getMessage());
        return new ResponseEntity<MessageDto>(messageDto, HttpStatus.NOT_FOUND);
    }
}
