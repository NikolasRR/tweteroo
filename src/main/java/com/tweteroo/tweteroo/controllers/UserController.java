package com.tweteroo.tweteroo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.tweteroo.DTOs.UserDTO;
import com.tweteroo.tweteroo.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sign-up")
public class UserController {

  @Autowired
  private UserService service;
  
  @PostMapping
  public String create(@RequestBody @Valid UserDTO req) {
    service.saveUser(req);
    return "OK";
  }
}
