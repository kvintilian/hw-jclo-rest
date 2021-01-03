package ru.netology.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.netology.exception.InvalidCredentials;
import ru.netology.exception.UnauthorizedUser;

import java.util.Arrays;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

  @ExceptionHandler(InvalidCredentials.class)
  protected ResponseEntity<String> icHandler(InvalidCredentials ex, WebRequest request) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(UnauthorizedUser.class)
  protected ResponseEntity<String> uuHandler(UnauthorizedUser ex, WebRequest request) {
    Logger log = LoggerFactory.getLogger(UnauthorizedUser.class);
    log.error(ex.getMessage());
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler()
  protected ResponseEntity<String> allHandler(RuntimeException ex, WebRequest request) {
    Logger log = LoggerFactory.getLogger(UnauthorizedUser.class);
    Arrays.stream(ex.getStackTrace()).forEach(l -> log.error(String.valueOf(l)));
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
