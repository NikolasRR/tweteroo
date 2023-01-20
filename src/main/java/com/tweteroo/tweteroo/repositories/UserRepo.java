package com.tweteroo.tweteroo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.tweteroo.models.User;

public interface UserRepo extends JpaRepository<User, Long> {
  List<User> findByUsername(String username);
}
