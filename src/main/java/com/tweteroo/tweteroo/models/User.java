package com.tweteroo.tweteroo.models;

import com.tweteroo.tweteroo.DTOs.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {
  
  public User(UserDTO user) {
    this.username = user.username();
    this.avatar = user.avatar();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;

  @Column(length = 20, nullable = false, unique = true)
  public String username;

  @Column(length = 500, nullable = false)
  public String avatar;
}
