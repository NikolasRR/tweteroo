package com.tweteroo.tweteroo.models;

import com.tweteroo.tweteroo.DTOs.TweetDTO;

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
@Table(name = "tweets")
public class Tweet {
  
  public Tweet(TweetDTO tweet) {
    this.text = tweet.tweet();
    this.username = tweet.username();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;

  @Column(length = 300, nullable = false)
  public String text;

  @Column(length = 20, nullable = false)
  public String username;
}
