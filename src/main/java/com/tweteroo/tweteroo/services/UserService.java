package com.tweteroo.tweteroo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.tweteroo.DTOs.UserDTO;
import com.tweteroo.tweteroo.models.User;
import com.tweteroo.tweteroo.repositories.UserRepo;

@Service
public class UserService {

  @Autowired
  private UserRepo repo;

  public void saveUser(UserDTO user) {
    if (Boolean.TRUE.equals(this.usernameTaken(user.username())))
      throw new Error();

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
