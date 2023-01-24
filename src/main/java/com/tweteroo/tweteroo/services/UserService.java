package com.tweteroo.tweteroo.services;

import java.util.List;

import javax.security.auth.login.AccountException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.tweteroo.DTOs.UserDTO;
import com.tweteroo.tweteroo.models.User;
import com.tweteroo.tweteroo.repositories.UserRepo;

@Service
public class UserService {

  @Autowired
  private UserRepo repo;

  public void saveUser(UserDTO user) throws AccountException{
    if (Boolean.TRUE.equals(this.usernameTaken(user.username())))
      throw new AccountException("username já está em uso");

    repo.save(new User(user));
  }

  private Boolean usernameTaken(String username) {
    List<User> user = repo.findByUsername(username);

    boolean result = true;
    if (user.isEmpty()) {
      result = false;
    }
    return result;
  }
}
