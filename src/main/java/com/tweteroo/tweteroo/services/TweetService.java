package com.tweteroo.tweteroo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.tweteroo.DTOs.TweetDTO;
import com.tweteroo.tweteroo.models.Tweet;
import com.tweteroo.tweteroo.repositories.TweetRepo;

@Service
public class TweetService {
  
  @Autowired
  private TweetRepo repo;

  public void saveTweet(TweetDTO tweet) {
    repo.save(new Tweet(tweet));
  }
}
