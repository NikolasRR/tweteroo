package com.tweteroo.tweteroo.models;

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
// @NoArgsConstructor
@Table(name = "tweets")
public class Tweet {
  
  public Tweet() {

  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;

  @Column(length = 20, nullable = false)
  public String username;

  @Column(length = 500, nullable = false)
  public String avatar;

  @Column(length = 300, nullable = false)
  public String text;
}
