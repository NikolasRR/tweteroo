package com.tweteroo.tweteroo.middlewares;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.AccountException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.validation.ValidationException;

public class ErrorHandler {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(ValidationException.class)
  public Map<String, String> handleExceptions404(ValidationException ex) {
    Map<String, String> errors = new HashMap<>();
    errors.put("erro", ex.getMessage());
    return errors;
  }

  @ExceptionHandler(AccountException.class)
  public ResponseEntity<Object> handleExceptions409(AccountException ex) {
    return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
  }

}