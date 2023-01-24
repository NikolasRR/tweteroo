package com.tweteroo.tweteroo.controllers;

import javax.security.auth.login.AccountException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.tweteroo.DTOs.UserDTO;
import com.tweteroo.tweteroo.middlewares.ErrorHandler;
import com.tweteroo.tweteroo.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sign-up")
public class UserController extends ErrorHandler{

  @Autowired
  private UserService service;
  
  @PostMapping
  public String create(@RequestBody @Valid UserDTO req) throws AccountException {
    service.saveUser(req);
    return "OK";
  }
}
